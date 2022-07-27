package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;




public class SignupTwo extends JFrame implements ActionListener{
    
    JLabel additionaldetails,relig,cast,salary,educate,occu,pan,aadhar,sen,exist,qualified, l13 , l12;//l12,l13;
    JButton next;
    JRadioButton senyes,senno,existyes,existno;
    JTextField pantf,aadhartf;
    JComboBox religion,category,income,education,occupation;
    String formno;
    
    SignupTwo(String formno){
        
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bank logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(10, 0, 150, 120);
        add(l14);
        
        
       
        
        additionaldetails = new JLabel("Page 2: Additonal Details");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 37));
        additionaldetails.setBounds(290,90,410,40);
        add(additionaldetails);
        additionaldetails.setBounds(280,30,600,40);
        add(additionaldetails);
        
        
        
        relig = new JLabel("Religion:");
        relig.setFont(new Font("Raleway", Font.BOLD, 18));
        relig.setBounds(100,120,100,30);
        add(relig);
        String religions[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(religions);
        religion.setBackground(Color.WHITE);
        religion.setFont(new Font("Raleway", Font.BOLD, 14));
        religion.setBounds(350,120,320,30);
        add(religion);
        
        
        
        cast = new JLabel("Category:");
        cast.setFont(new Font("Raleway", Font.BOLD, 18));
        cast.setBounds(100,170,100,30);
        add(cast);
        String categories[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(categories);
        category.setBounds(350,170,320,30);
        category.setBackground(Color.WHITE);
        category.setFont(new Font("Raleway", Font.BOLD, 14));
        add(category);
        
        salary = new JLabel("Income:");
        salary.setFont(new Font("Raleway", Font.BOLD, 18)); 
        salary.setBounds(100,220,100,30);
        add(salary);
        String incomes[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        income = new JComboBox(incomes);
        income.setBackground(Color.WHITE);
        income.setFont(new Font("Raleway", Font.BOLD, 14));
        income.setBounds(350,220,320,30);
        add(income);
        
        
        educate = new JLabel("Educational");
        educate.setFont(new Font("Raleway", Font.BOLD, 18));
        educate.setBounds(100,270,150,30);
        add(educate);
        String educationcategory[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        education = new JComboBox(educationcategory);
        education.setBackground(Color.WHITE);
        education.setFont(new Font("Raleway", Font.BOLD, 14));
        education.setBounds(350,270,320,30);
        add(education);
        
        
        qualified = new JLabel("Qualification:");
        qualified.setFont(new Font("Raleway", Font.BOLD, 18));
        qualified.setBounds(100,290,150,30);
        add(qualified);
        
        
        occu = new JLabel("Occupation:");
        occu.setFont(new Font("Raleway", Font.BOLD, 18));
        occu.setBounds(100,340,150,30);
        add(occu);
        String occupationcategory[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        occupation = new JComboBox(occupationcategory);
        occupation.setBackground(Color.WHITE);
        occupation.setFont(new Font("Raleway", Font.BOLD, 14));
        occupation.setBounds(350,340,320,30);
        add(occupation);
       
        
        
        pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 18));
        pan.setBounds(100,390,150,30);
        pantf = new JTextField();
        pantf.setFont(new Font("Raleway", Font.BOLD, 14));
        pantf.setBounds(350,390,320,30);
        add(pantf);
        add(pan);
        
        
        aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 18));
        aadhar.setBounds(100,440,180,30);
        aadhartf = new JTextField();
        aadhartf.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhartf.setBounds(350,440,320,30);
        add(aadhartf);
           
        add(aadhar);
        
        
        sen = new JLabel("senior Citizen:");
        sen.setFont(new Font("Raleway", Font.BOLD, 18));
        sen.setBounds(100,490,150,30);
        add(sen);
        senyes = new JRadioButton("Yes");
        senyes.setFont(new Font("Raleway", Font.BOLD, 14));
        senyes.setBounds(350,490,100,30);
        senyes.setBackground(Color.WHITE);
        add(senyes);
        senno = new JRadioButton("No");
        senno.setFont(new Font("Raleway", Font.BOLD, 14));
        senno.setBounds(460,490,100,30);
        senno.setBackground(Color.WHITE);
        add(senno);
        ButtonGroup citizengroup = new ButtonGroup();
        citizengroup.add(senyes);
        citizengroup.add(senno);
        
          
                
        exist = new JLabel("existing Account:");
        exist.setFont(new Font("Raleway", Font.BOLD, 18));
        exist.setBounds(100,540,180,30);
        add(exist);
        existyes=new JRadioButton("Yes");
        existyes.setFont(new Font("Raleway", Font.BOLD, 14));
        existyes.setBackground(Color.WHITE);
        existyes.setBounds(350,540,100,30);
        add(existyes); 
       
        existno = new JRadioButton("No");
        existno.setFont(new Font("Raleway", Font.BOLD, 14));
        existno.setBounds(460,540,100,30);
        existno.setBackground(Color.WHITE);
        add(existno);
        ButtonGroup existgroup = new ButtonGroup();
        existgroup.add(existyes);
        existgroup.add(existno);
        
        
        
        l12 = new JLabel("Form No:");
        l12.setFont(new Font("Raleway", Font.BOLD, 13));
        l12.setBounds(700,10,60,30);
        add(l12);               
        l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD, 13));
        l13.setBounds(760,10,60,30);
        add(l13);
        
        setLayout(null);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(570,640,100,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,750);
        setLocation(500,120);
        setVisible(true);
    }

    SignupTwo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
        public void actionPerformed(ActionEvent ae){
        String srelixn = (String)religion.getSelectedItem();
        String scaste   = (String)category.getSelectedItem();
        String ssalary = (String)income.getSelectedItem();
        String seducate = (String)education.getSelectedItem();
        
        String soccupaxn = (String)occupation.getSelectedItem();
        
        String span = pantf.getText();
        String saadhar = aadhartf.getText();
        
        String scitizen="";
        if(senyes.isSelected()){ 
            scitizen = "Yes";
        }
        else if(senno.isSelected()){ 
            scitizen = "No";
        }
           
        String exist_acc = "";
        if(existyes.isSelected()){ 
            exist_acc = "Yes";
        }else if(existno.isSelected()){ 
            exist_acc = "No";
        }
        
        try{
            if(pantf.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Conn c = new Conn();
                String q1 = "insert into signuptwo values('"+formno+"','"+srelixn+"','"+scaste+"','"+ssalary+"','"+seducate+"','"+soccupaxn+"','"+span+"','"+saadhar+"','"+scitizen+"','"+exist_acc+"')";
                c.s.executeUpdate(q1);
                
                //new Signup3(formno).setVisible(true);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
            
         }catch (Exception e){
            System.out.println(e);
        }
    
               
    }
    public static void main(String[] args){
        new SignupTwo("").setVisible(true);
    }
}