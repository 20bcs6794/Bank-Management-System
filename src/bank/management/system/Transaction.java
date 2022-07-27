package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{
    JButton deposit , withdrawl , fastcash, ministatement ,pinchange, balanceenquiry , exit;
    String pinnumber;
    
    Transaction(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
                
                
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images//ATM PHOTO.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1050, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1000, 1050);
        add(image);
        
        JLabel text = new JLabel("Please Select Your Transaction ⬇");
        text.setBounds(350, 87, 500, 100);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system",Font.BOLD,20));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Raleway", Font.BOLD, 20));
        deposit.setBounds(200, 165 , 220 , 50);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setFont(new Font("Raleway", Font.BOLD, 20));
        withdrawl.setBounds(600, 165 , 200 , 50);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton(" Fast Cash");
        fastcash.setFont(new Font("Raleway", Font.BOLD, 20));
        fastcash.setBounds(200, 270 , 220 , 50);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setFont(new Font("Raleway", Font.BOLD, 20));
        ministatement.setBounds(600, 270 , 200 , 50);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Pin Change");
        pinchange.setFont(new Font("Raleway", Font.BOLD, 20));
        pinchange.setBounds(200, 370 , 220 , 50);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setFont(new Font("Raleway", Font.BOLD, 20));
        balanceenquiry.setBounds(600, 370 , 200 , 50);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit = new JButton("Exit");
        exit.setFont(new Font("Raleway", Font.BOLD, 20));
        exit.setBounds(409, 470 , 200 , 50);
        exit.addActionListener(this);
        image.add(exit);
        
        
        getRootPane().setBorder(BorderFactory.createMatteBorder(10,10,10,10,Color.BLACK));
        setSize(1000,1600);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if (ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()== balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if (ae.getSource()==ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        
        new Transaction("").setVisible(true);
    }
}
