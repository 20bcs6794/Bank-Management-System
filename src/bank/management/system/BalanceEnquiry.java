package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;


public class BalanceEnquiry extends JFrame implements ActionListener{
     JLabel image, text;
     JButton back;
     String pinnumber;
    
     
     BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images//ATM photo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1050, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 1000, 1050);
        add(image);
       
        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 20));
        back.setBounds(400, 370 , 150 , 40);
        back.addActionListener(this);
        image.add(back);
        
        Conn conn = new Conn();
        int balance = 0;
        try{
            
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
          System.out.println(e);
        }
        
        text = new JLabel("Your current Account Balance is  Rs "+balance);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 30));
        text.setBounds(220,270,600,35);
        image.add(text);
                
                
        getRootPane().setBorder(BorderFactory.createMatteBorder(10,10,10,10,Color.BLACK));        
        setLayout(null);
        setSize(1000,1050);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
}
    
     public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
    
public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}