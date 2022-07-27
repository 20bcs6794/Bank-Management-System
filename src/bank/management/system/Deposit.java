package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    JTextField amount;
    JButton deposit,back;
    JLabel text,image;
    String pinnumber;
    
    
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images//ATM photo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1050, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 1000, 1050);
        add(image);
        
        text = new JLabel("Enter amount you want to Deposit ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 30));
        text.setBounds(260,170,600,35);
        image.add(text);
       
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(280,270,420,35);
        image.add(amount);
        
        deposit = new JButton("DEPOSIT");
        deposit.setFont(new Font("Raleway", Font.BOLD, 20));
        deposit.setBounds(550,370,150,40);
        image.add(deposit);
        
        back = new JButton("BACK");
        back.setFont(new Font("Raleway", Font.BOLD, 20));
        back.setBounds(280,370,150,40);
        image.add(back);
        
        setLayout(null);

        
        deposit.addActionListener((ActionListener) this);
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
            if(ae.getSource()==deposit){
                if(number.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    Conn conn = new Conn();
                    conn.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+number+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+number+" Deposited Successfully");
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
        new Deposit("").setVisible(true);
    }
}
    
    
