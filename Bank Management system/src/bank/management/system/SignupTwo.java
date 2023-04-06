
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField pan,aadhar;
    JRadioButton syes,sno,eyes,eno;
    JButton next;
    JComboBox occupation,category,income,religion,education;
    String formno;
    
    SignupTwo(String formno){
        
        this.formno = formno;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
       setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Info");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valreligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valreligion);
        religion.setBackground(Color.WHITE);
        religion.setFont(new Font("Raleway", Font.BOLD, 14));
        religion.setBounds(300,140,400,30);
        add(religion);
        
        
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valcategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valcategory);
        category.setBackground(Color.WHITE);
        category.setFont(new Font("Raleway", Font.BOLD, 14));
        category.setBounds(300,190,400,30);
        add(category);
        
        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String valincome[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        income = new JComboBox(valincome);
        income.setBackground(Color.WHITE);
        income.setFont(new Font("Raleway", Font.BOLD, 14));
        income.setBounds(300,240,400,30);
        add(income);
        
        JLabel email = new JLabel("Education:");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,290,200,30);
        add(email);
        
        String valeducation[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        education = new JComboBox(valeducation);
        education.setBackground(Color.WHITE);
        education.setFont(new Font("Raleway", Font.BOLD, 14));
        education.setBounds(300,290,400,30);
        add(education);
        
        
        JLabel gender = new JLabel("Occupation:");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,340,200,30);
        add(gender);
        
        String valoccupation[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        occupation = new JComboBox(valoccupation);
        occupation.setBackground(Color.WHITE);
        occupation.setFont(new Font("Raleway", Font.BOLD, 14));
        occupation.setBounds(300,340,400,30);
        add(occupation);
        
        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,390,200,30);
        add(address);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,390,400,30);
        add(pan);
        
        JLabel city = new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,440,200,30);
        add(city);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,440,400,30);
        add(aadhar);
        
        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,490,200,30);
        add(state);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(310,490,60,30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(410,490,100,30);
        sno.setBackground(Color.white);
        add(sno);
        
        
        ButtonGroup gengrp = new ButtonGroup();
        gengrp.add(syes);
        gengrp.add(sno);
        
        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD,22));
        pincode.setBounds(100,540,200,30);
        add(pincode);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(310,540,60,30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(410,540,100,30);
        eno.setBackground(Color.white);
        add(eno);
        
        
        ButtonGroup gengrp2 = new ButtonGroup();
        gengrp2.add(eyes);
        gengrp2.add(eno);
        
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,600,80,30);
        next.addActionListener(this);
        add(next);
        
        setSize(850,700);
        setLocation(350,30);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){

        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        
        String old = null;
        if(syes.isSelected()){
            old = "Yes";
        }else if(sno.isSelected()){
           old = "No";
        }
        
        String acc = null;
        if(eyes.isSelected()){
            acc = "Yes";
        }else if(eno.isSelected()){
           acc = "No";
        }
        
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        
        try{          
                Conn c2 = new Conn();
                String query2 = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+old+"','"+acc+"')";
                c2.s.executeUpdate(query2);
                
                //next button
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        new SignupTwo("");
    }
}

