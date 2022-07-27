package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener{
    
   long random;
   JLabel formno, personalDetails, name , fname , gender , email , marital , address , city , state , pincode  ;
   JTextField nametf, fnametf, emailtf, addresstf , citytf ,statetf,pintf;
   JButton next;
   JRadioButton male, female, other, married , unmarried;
   JDateChooser dateChooser ;
    
    
    SignupOne(){
        
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs ((ran.nextLong()%9000L)+1000L);
        
        formno=new JLabel("APPLICATION FORM No." + random );   
        formno.setFont(new Font("raleway", Font.BOLD, 38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        personalDetails =new JLabel("Page 1: Personal Details." );   
        personalDetails.setFont(new Font("raleway", Font.BOLD, 22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bank logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(10, 0, 150, 120);
        add(l11);
        
        
        name=new JLabel("Name: ");   
        name.setFont(new Font("raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);
        
        nametf = new JTextField();
        nametf.setFont(new Font("raleway", Font.BOLD,14));
        nametf.setBounds(300,140, 400, 30);
        add(nametf);
        
        
        
        fname=new JLabel("Father's Name: ");   
        fname.setFont(new Font("raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnametf = new JTextField();
        fnametf.setFont(new Font("raleway", Font.BOLD,14));
        fnametf.setBounds(300,190, 400, 30);
        add(fnametf);
        
        
        JLabel dob=new JLabel("Date Of Birth: ");   
        dob.setFont(new Font("raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
        
        gender=new JLabel("Gender: ");   
        gender.setFont(new Font("raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        other = new JRadioButton("Other");
        other.setBounds(600,290,200,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);
        
        
        email=new JLabel("Email: ");   
        email.setFont(new Font("raleway", Font.BOLD, 20));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailtf = new JTextField();
        emailtf.setFont(new Font("raleway", Font.BOLD,14));
        emailtf.setBounds(300,340, 400, 30);
        add(emailtf);
        
        marital=new JLabel("marital Status: ");   
        marital.setFont(new Font("raleway", Font.BOLD, 20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        
        
        
        
        address=new JLabel("Address: ");   
        address.setFont(new Font("raleway", Font.BOLD, 20));
        address.setBounds(100,440,200,30);
        add(address);
        
        addresstf = new JTextField();
        addresstf.setFont(new Font("raleway", Font.BOLD,14));
        addresstf.setBounds(300,440, 400, 30);
        add(addresstf);
        
        
        city=new JLabel("City: ");   
        city.setFont(new Font("raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        add(city);
        
        citytf = new JTextField();
        citytf.setFont(new Font("raleway", Font.BOLD,14));
        citytf.setBounds(300,490, 400, 30);
        add(citytf);
        
        
        state=new JLabel("State: ");   
        state.setFont(new Font("raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);
        
        statetf = new JTextField();
        statetf.setFont(new Font("raleway", Font.BOLD,14));
        statetf.setBounds(300,540, 400, 30);
        add(statetf);
        
        
        pincode=new JLabel("Pin Code: ");   
        pincode.setFont(new Font("raleway", Font.BOLD, 20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        pintf = new JTextField();
        pintf.setFont(new Font("raleway", Font.BOLD,14));
        pintf.setBounds(300,590, 400, 30);
        add(pintf);
        
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620,660, 80,30);
        next.addActionListener(this);
        add(next);
        
        
        
        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setLocation(500,120);
        setVisible(true);
    }

   
    public void actionPerformed(ActionEvent ae){
    
    String sformno= ""+random;
    String sname = nametf.getText();
    String sfname = fnametf.getText();
    String sdob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
    String sgender = null;
    if (male.isSelected()){
        sgender="Male";
        
    }else if(female.isSelected()){
        sgender="Female";
    }else if (other.isSelected()){
        sgender="Other";
    }    
    
    String semail = emailtf.getText();
    String smarital=null;
    if(married.isSelected()){
       smarital = "Married";
    }else if(unmarried.isSelected()){
        smarital = "unmarried";
    }
    
    String saddress = addresstf.getText();
    String scity = citytf.getText();
    String sstate = statetf.getText();
    String pin = pintf.getText();
    
    try{
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Name is required");
        }else{
            Conn c= new Conn();
            String query = "insert into signup values('"+sformno+"','"+sname+"','"+sfname+"','"+sdob+"','"+sgender+"','"+semail+"','"+smarital+"','"+saddress+"','"+scity+"','"+sstate+"','"+pin+"')";
            c.s.executeUpdate(query);
            setVisible(false);
            new SignupTwo(sformno).setVisible(true);
        }
    }catch(Exception e){
        System.out.println(e);
    }
    
}
    
   public static void main(String args[]){
    new SignupOne().setVisible(true);
   }
}
