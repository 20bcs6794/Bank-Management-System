package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    JButton deposit , withdrawl , fastcash, ministatement ,pinchange, balanceenquiry , back;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
                
                
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images//ATM PHOTO.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1050, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1000, 1050);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawl Amount ⬇");
        text.setBounds(350, 87, 500, 100);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system",Font.BOLD,20));
        image.add(text);
        
        
        
        deposit = new JButton("RS 100");
        deposit.setFont(new Font("Raleway", Font.BOLD, 20));
        deposit.setBounds(200, 165 , 220 , 50);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Rs 500");
        withdrawl.setFont(new Font("Raleway", Font.BOLD, 20));
        withdrawl.setBounds(600, 165 , 200 , 50);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setFont(new Font("Raleway", Font.BOLD, 20));
        fastcash.setBounds(200, 270 , 220 , 50);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Rs 2000");
        ministatement.setFont(new Font("Raleway", Font.BOLD, 20));
        ministatement.setBounds(600, 270 , 200 , 50);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Rs 5000");
        pinchange.setFont(new Font("Raleway", Font.BOLD, 20));
        pinchange.setBounds(200, 370 , 220 , 50);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setFont(new Font("Raleway", Font.BOLD, 20));
        balanceenquiry.setBounds(600, 370 , 200 , 50);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 20));
        back.setBounds(409, 470 , 200 , 50);
        back.addActionListener(this);
        image.add(back);
        
        getRootPane().setBorder(BorderFactory.createMatteBorder(10,10,10,10,Color.BLACK));
        setSize(1000,1050);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3); //RS 500 remove R , s and space.
            Conn c = new Conn();     
            try{
              
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                    }
                    if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                     JOptionPane.showMessageDialog(null, "Insuffient Balance");
                     setVisible(false);
                     new Transaction(pinnumber).setVisible(true);
                     return ;
                    
                    } Date date = new Date();
                    c.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");    
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                    
                    
            }catch (Exception e){
            System.out.println(e);
            }
        
        }
    }
    
    public static void main(String args[]){
        
        new FastCash("").setVisible(true);
    }
}
