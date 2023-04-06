
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login,clear,signup;
    JTextField cardText;
    JPasswordField pinText;
    Login(){
        setTitle("Automated Teller Machine");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lable = new JLabel(i3);
        lable.setBounds(70,10,100,100);
        add(lable);
        
        JLabel text = new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raieway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);
        
        cardText = new JTextField();
        cardText.setBounds(300,150,230,30);
        cardText.setFont(new Font("Arial",Font.BOLD,14));
        add(cardText);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Osward",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);
        
        pinText = new JPasswordField();
        pinText.setBounds(300,220,230,30);
        pinText.setFont(new Font("Arial",Font.BOLD,14));
        add(pinText);
        
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.white);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            pinText.setText("");
            cardText.setText("");
        }else if(ae.getSource() == login){
                Conn c1 = new Conn();
                String cardno  = cardText.getText();
                String pin  = pinText.getText();
                String q  = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";
                try{
                    ResultSet rs = c1.s.executeQuery(q);
                    if(rs.next()){
                        setVisible(false);
                        new Transactions(pin).setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
                
        }else if(ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String args[]){
        new Login();
    }
}
