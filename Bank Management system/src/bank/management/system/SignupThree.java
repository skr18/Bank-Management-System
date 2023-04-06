
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    JTextField pan,aadhar;
    JRadioButton r1,r2,r3,r4,eyes,eno;
    JButton b1,b2;
    JComboBox occupation,category,income,religion,education;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formno;
    
    SignupThree(String formno){
        
        this.formno = formno;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,25));
        l1.setBounds(230,60,400,30);
        add(l1);
        
        JLabel name = new JLabel("Account Type:");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,200,30);
        add(name);
        
        r1 = new JRadioButton("Saving Account");
        r1.setBounds(100,180,150,20);
        r1.setBackground(Color.white);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposite Account");
        r2.setBounds(350,180,200,20);
        r2.setBackground(Color.white);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setBounds(100,220,150,20);
        r3.setBackground(Color.white);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposite Account");
        r4.setBounds(350,220,200,20);
        r4.setBackground(Color.white);
        add(r4);
        
        
        ButtonGroup gengrp = new ButtonGroup();
        gengrp.add(r1);
        gengrp.add(r2);
        gengrp.add(r3);
        gengrp.add(r4);
        
        
        JLabel card = new JLabel("Card:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,20);
        add(card);
        
        JLabel cardd = new JLabel("This Your 16 Digit Card No.");
        cardd.setFont(new Font("Raleway",Font.BOLD,12));
        cardd.setBounds(100,320,200,20);
        add(cardd);
        
        JLabel cardno = new JLabel("XXXX-XXXX-XXXX-4138");
        cardno.setFont(new Font("Raleway",Font.BOLD,22));
        cardno.setBounds(330,300,300,30);
        add(cardno);
        
        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        
        JLabel pind = new JLabel("This Your 4 Digit Pin");
        pind.setFont(new Font("Raleway",Font.BOLD,12));
        pind.setBounds(100,390,200,30);
        add(pind);


        JLabel pinno = new JLabel("XXXX");
        pinno.setFont(new Font("Raleway",Font.BOLD,22));
        pinno.setBounds(330,370,300,30);
        add(pinno);

        
        
        
        JLabel ser = new JLabel("Services Requried:");
        ser.setFont(new Font("Raleway",Font.BOLD,22));
        ser.setBounds(100,450,300,30);
        add(ser);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        
        
        c1.setBounds(100,500,200,30);
        add(c1);
        
        c2.setBounds(350,500,200,30);
        add(c2);
        
        c3.setBounds(100,550,200,30);
        add(c3);
        
        c4.setBounds(350,550,200,30);
        add(c4);
        
        c5.setBounds(100,600,200,30);
        add(c5);
        
        c6.setBounds(350,600,200,30);
        add(c6);
        
        c7.setBounds(100,680,600,20);
        add(c7);
        
        
        b1 = new JButton("Submit");
        b1.setFont(new Font("Raleway", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Cancel");
        b2.setFont(new Font("Raleway", Font.BOLD, 14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b1.setBounds(220,730,100,30);
        add(b1);
        
        b2.setBounds(390,730,100,30);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setSize(750,820);
        setLocation(420,30);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == b1){
            
            String atype = null;
            if(r1.isSelected()){ 
                atype = "Saving Account";
            }
            else if(r2.isSelected()){ 
                atype = "Fixed Deposit Account";
            }
            else if(r3.isSelected()){ 
                atype = "Current Account";
            }else if(r4.isSelected()){ 
                atype = "Recurring Deposit Account";
            }
            
            Random ran = new Random();
            long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
            String cardno = "" + Math.abs(first7);

            long first3 = (ran.nextLong() % 9000L) + 1000L;
            String pin = "" + Math.abs(first3);
            
            String facility = "";
            if(c1.isSelected()){ 
                facility = facility + " ATM Card";
            }
            if(c2.isSelected()){ 
                facility = facility + " Internet Banking";
            }
            if(c3.isSelected()){ 
                facility = facility + " Mobile Banking";
            }
            if(c4.isSelected()){ 
                facility = facility + " EMAIL Alerts";
            }
            if(c5.isSelected()){ 
                facility = facility + " Cheque Book";
            }
            if(c6.isSelected()){ 
                facility = facility + " E-Statement";
            } 
            
            try{
                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null, "Fields Can Not Be Empty");
                }else{
                    Conn c1 = new Conn();
                    String q1 = "insert into signupthree values('"+formno+"','"+atype+"','"+cardno+"','"+pin+"','"+facility+"')";  
                    c1.s.executeUpdate(q1);  
                    
                    String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c1.s.executeUpdate(q2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:"+ pin);
                    
                    setVisible(false);
                    new Deposit(pin).setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource() == b2){
            setVisible(false);
            new Login().setVisible(true);
        }
        
        
      
    }
    public static void main(String args[]){
        new SignupThree("");
    }
}


