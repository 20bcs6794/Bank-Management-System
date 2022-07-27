
package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
      JLabel label , l2 , l3 ;
      JTextArea myname;
      JTextField tf1;
      JPasswordField pf2;
      JButton b1,b2,b3;
    
    Login(){
        
        setLayout(null);
        
         setTitle("AUTOMATED TELLER MACHINE");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images//card.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 430, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        label = new JLabel(i3); 
        label.setBounds(0, 0, 770, 420);
        add(label);
       
        l2 = new JLabel("Card No:");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(125,100,375,30);
        label.add(l2);
        
        myname = new JTextArea("Made by- : Vanshdeep Verma");
        myname.setEditable(false);
        myname.setForeground(Color.WHITE);
        myname.setBackground(Color.black);
        myname.setFont(new Font("Raleway", Font.BOLD, 20));
        myname.setBounds(50,350,280,30);
        label.add(myname);
        
        tf1 = new JTextField(15);
        tf1.setBounds(300,100,230,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        label.add(tf1);
        
        l3 = new JLabel("PIN:");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(125,160,375,30);
        label.add(l3);
        
        pf2 = new JPasswordField(15);
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300,160,230,30);
        label.add(pf2);
        
        b1 = new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("SIGN UP");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300,220,100,30);
        label.add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430,220,100,30);
        label.add(b2);
        
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(300,280,230,30);
        label.add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        getRootPane().setBorder(BorderFactory.createMatteBorder(10,10,10,10,Color.BLACK));
        getContentPane().setBackground(Color.WHITE); 
        setSize(800,480);
        setLocation(550,200);
        setVisible(true);
    
}
    public void actionPerformed(ActionEvent ae){
        try{        
            if(ae.getSource()==b1){
                Conn c1 = new Conn();
                String cardno  = tf1.getText();
                String pin  = pf2.getText();
                String q  = "select * from login where cardnumber = '"+cardno+"' and pinnumber = '"+pin+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){ 
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }else if(ae.getSource()==b2){
                tf1.setText("");
                pf2.setText("");
            }else if(ae.getSource()==b3){
                setVisible(false);
                new SignupOne().setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        new Login().setVisible(true);
    }

    
}
