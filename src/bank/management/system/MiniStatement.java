package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
 
    JButton b1;
    JLabel mini , image, card , balance;
    
    MiniStatement(String pinnumber){
        
        super("Mini Statement");
        getRootPane().setBorder(BorderFactory.createMatteBorder(10,10,10,10,Color.BLACK));
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setSize(400,600);
        setLocation(20,20);
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images//Axis.png"));
       Image i2 = i1.getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       image = new JLabel(i3);
       image.setBounds(80, 10, 200, 40);
       add(image);
        
        
        mini = new JLabel();
        add(mini);
        
        
        balance = new JLabel ();
        balance.setBounds(20 , 400 , 300 , 20);
        add(balance);
        
        card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number:    " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){}
        	 
        try{
            int bal = 0;
            Conn conn  = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }                  
            }    
            balance.setText("Your total Balance is  Rs "+bal);
        }catch(Exception e){
         System.out.println(e);
        }
        
        setLayout(null);
        b1 = new JButton("Exit");
        add(b1);
        
        b1.addActionListener(this);
        
        mini.setBounds(20, 140, 400, 200);
        b1.setBounds(20, 500, 100, 25);
    }
        public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String[] args){
        new MiniStatement("").setVisible(true);
    }
    
}
        
        
      
