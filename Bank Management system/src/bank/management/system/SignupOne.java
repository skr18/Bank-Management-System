
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {
    
    long random;
    JTextField nameText,fnameText,emailText,addressText,cityText,stateText,pinText;
    JDateChooser date;
    JRadioButton male,female,others;
    JButton next;
    
    SignupOne(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L)+1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. "+ random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personal = new JLabel("Page 1: Personal Info");
        personal.setFont(new Font("Raleway",Font.BOLD,22));
        personal.setBounds(290,80,400,30);
        add(personal);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);
        
        nameText = new JTextField();
        nameText.setFont(new Font("Raleway",Font.BOLD,14));
        nameText.setBounds(300,140,400,30);
        add(nameText);
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnameText = new JTextField();
        fnameText.setFont(new Font("Raleway",Font.BOLD,14));
        fnameText.setBounds(300,190,400,30);
        add(fnameText);
        
        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        date = new JDateChooser();
        date.setBounds(300,240,400,30);
        date.setForeground(Color.black);
        add(date);
        
        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,290,200,30);
        add(email);
        
        emailText = new JTextField();
        emailText.setFont(new Font("Raleway",Font.BOLD,14));
        emailText.setBounds(300,290,400,30);
        add(emailText);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,340,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,340,60,30);
        male.setBackground(Color.white);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(400,340,100,30);
        female.setBackground(Color.white);
        add(female);
        
        others = new JRadioButton("Other");
        others.setBounds(550,340,60,30);
        others.setBackground(Color.white);
        add(others);
        
        ButtonGroup gengrp = new ButtonGroup();
        gengrp.add(male);
        gengrp.add(female);
        gengrp.add(others);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,390,200,30);
        add(address);
        
        addressText = new JTextField();
        addressText.setFont(new Font("Raleway",Font.BOLD,14));
        addressText.setBounds(300,390,400,30);
        add(addressText);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,440,200,30);
        add(city);
        
        cityText = new JTextField();
        cityText.setFont(new Font("Raleway",Font.BOLD,14));
        cityText.setBounds(300,440,400,30);
        add(cityText);
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,490,200,30);
        add(state);
        
        stateText = new JTextField();
        stateText.setFont(new Font("Raleway",Font.BOLD,14));
        stateText.setBounds(300,490,400,30);
        add(stateText);
        
        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway",Font.BOLD,22));
        pincode.setBounds(100,540,200,30);
        add(pincode);
        
        pinText = new JTextField();
        pinText.setFont(new Font("Raleway",Font.BOLD,14));
        pinText.setBounds(300,540,400,30);
        add(pinText);
        
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
        String formno = ""+random;
        String name = nameText.getText();
        String fname = fnameText.getText();
        String dob = ((JTextField)date.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }else if(others.isSelected()){
            gender = "Others";
        }
        String email = emailText.getText();
        String address = addressText.getText();
        String city = cityText.getText();
        String state = stateText.getText();
        String pin = pinText.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name can not be empty");
            }else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        new SignupOne();
    }
}
