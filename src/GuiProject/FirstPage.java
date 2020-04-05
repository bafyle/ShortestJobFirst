/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiProject;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author vip
 */
public class FirstPage extends JFrame implements ActionListener{
    JPanel p1=new JPanel();
    JLabel l =new JLabel("WELCOME...");
    JLabel l2=new JLabel("Number Of Process");
    JTextField t1=new JTextField();
    JButton b1=new JButton("DONE");
 
    
    
    
    
    
    
    
    
    
    
    
    public FirstPage(){
        this.setTitle("number of process");
        this.setResizable(false);
        this.setSize(500,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(30, 30);
        this.setVisible(true);
        this.setLayout( new BorderLayout());
        this.add(p1);
        p1.setLayout(null);
        p1.setBackground(new Color(0,128,128));
        p1.add(l);p1.add(l2);p1.add(t1);
        p1.add(b1);
        l.setForeground(new Color(230,126,34));
        l.setFont(new Font("etalic",Font.ITALIC,20));
        l.setBounds(170,40, 180, 30);
        l2.setForeground(new Color(230,126,34));
        l2.setFont(new Font("etalic",Font.ITALIC,20));
        l2.setBounds(10,140, 180, 30);
        t1.setBounds(210,140,210,30);
        b1.setBounds(180, 270, 140, 60);
        b1.setBackground(new Color(230,126,34));
        b1.setForeground(new Color(52,73,94));
        b1.setFont(new Font("italic",Font.ITALIC,15));
        b1.addActionListener(this);
        
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            p1.setVisible(false);
            SecondPage s=new SecondPage();
        
    }
    }
}