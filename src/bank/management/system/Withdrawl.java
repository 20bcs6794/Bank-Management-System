package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdraw,back ;
    JLabel text,image;
    String pinnumber;
    
    
    Withdrawl(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images//ATM photo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1050, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 1000, 1050);
        add(image);
        
        text = new JLabel("Enter amount you want to Withdraw ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 30));
        text.setBounds(240,170,600,35);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(280,270,420,35);
        image.add(amount);
  
        withdraw = new JButton("Withdrawl");
        withdraw.setFont(new Font("Raleway", Font.BOLD, 20));
        withdraw.setBounds(550,370,150,40);
        image.add(withdraw);

        back = new JButton("BACK");
        back.setFont(new Font("Raleway", Font.BOLD, 20));
        back.setBounds(280,370,150,40);
        image.add(back);
        
        setLayout(null);
        
        
        withdraw.addActionListener((ActionListener) this);
        back.addActionListener((ActionListener) this);
        
        getRootPane().setBorder(BorderFactory.createMatteBorder(10,10,10,10,Color.BLACK));
        setSize(1000,1050);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
        try{        
            String number = amount.getText();
            Date date = new Date();
            if(ae.getSource()==withdraw){
                if(number.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdrawl");
                }else{
                    Conn conn = new Conn();
                    ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("type").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("amount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("amount"));
                       }
                    }
                    if(balance < Integer.parseInt(number)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;  
                    
                    }conn.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+number+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+number+" Withdraw Successfully");
                    
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }
        }catch(Exception e){
           System.out.println(e);
        }
            
    }    
    public static void main(String args[]){
        new Withdrawl("").setVisible(true);
    }
}
    
    
