
package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PinChange extends JFrame implements ActionListener{
    JLabel text,pintext, repintext ;
    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;
    
    
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images//ATM PHOTO.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1050, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1000, 1050);
        add(image);
      
        text = new JLabel("Change your PIN ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 40));
        text.setBounds(330, 165 , 400 , 50);
        image.add(text);
        
        pintext = new JLabel("New PIN:");
        pintext.setFont(new Font("System", Font.BOLD, 30));
        pintext.setBounds(330, 265 , 400 , 50);
        pintext.setForeground(Color.WHITE);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD , 25));
        pin.setForeground(Color.white);
        pin.setBackground(Color.black);
        pin.setBounds(530 , 265 , 250 , 35);
        image.add(pin);
        
        repintext = new JLabel("Re-Enter PIN:");
        repintext.setFont(new Font("System", Font.BOLD, 30));
        repintext.setBounds(270,370,400,50);
        repintext.setForeground(Color.WHITE);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD , 25));
        repin.setForeground(Color.white);
        repin.setBackground(Color.black);
        repin.setBounds(530 , 380 , 250 , 35);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setFont(new Font("raleway", Font.BOLD , 20));
        change.setBounds(530 , 475 , 170 , 40);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setFont(new Font("raleway", Font.BOLD , 20));
        back.setBounds(300 , 475 , 170 , 40);
        back.addActionListener(this);
        image.add(back);

        getRootPane().setBorder(BorderFactory.createMatteBorder(10,10,10,10,Color.BLACK));
        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);  
}
     public void actionPerformed(ActionEvent ae){
        
         if(ae.getSource()==change){
        try{        
            String npin = pin.getText();
            String rpin = repin.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(npin.equals ("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                
                Conn conn = new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                String q2 = "update login set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";
                String q3 = "update signupthree set pin = '"+rpin+"' where pin ='"+pinnumber+"' ";

                conn.s.executeUpdate(q1);
                conn.s.executeUpdate(q2);
                conn.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transaction(rpin).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }
    } else{
             setVisible(false);
             new Transaction(pinnumber).setVisible(true);
         }
     } 
    public static void main(String args[]){
       new PinChange("").setVisible(true);
    }
}