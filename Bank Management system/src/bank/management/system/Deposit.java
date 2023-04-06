
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class Deposit extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    String pin;
    
    Deposit(String pin){
        
        this.pin=pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 960, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 900, 900);
        add(l3);
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        l1.setBounds(170,300,400,35);
        l3.add(l1);
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");
        
        t1.setBounds(165,370,320,25);
        l3.add(t1);
        
        b1.setBounds(350,460,150,30);
        l3.add(b1);
        
        b2.setBounds(350,500,150,30);
        l3.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setSize(900,900);
        //setUndecorated(true);
        setLocation(300,0);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae){
         
          String amount = t1.getText();
          Date date = new Date();
            
         if(ae.getSource() == b1){
            if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
            }else{
                try{
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    
                    setVisible(false);
                    new Transactions(pin).setVisible(true); 
                    
                }catch(Exception e){
                    System.out.println(e);
                }
                    
            }
         }else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
     }
    public static void main(String args[]){
        new Deposit("");
    }
}
