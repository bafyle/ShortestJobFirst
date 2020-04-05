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
public class SecondPage implements ActionListener{
    JFrame m = new JFrame();
    JPanel p2=new JPanel();
    JButton b2=new JButton("calculate");
    Scrollbar scroll = new Scrollbar();
    
 

    

    
    
    
    public SecondPage(){
        m.setVisible(true);
        m.setSize(500,400);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m.setLayout(new BorderLayout());
        m.setLocation(30,30);
        m.add(p2);
        m.add(scroll);
        p2.add(b2);
        p2.setLayout(null);
        p2.setBackground(new Color(0,128,128));
        b2.setBounds(180, 270, 140, 60);
        b2.setBackground(new Color(0,128,128));
        b2.setForeground(new Color(52,73,94));
        b2.setFont(new Font("italic",Font.ITALIC,15));
        b2.addActionListener(this);
        scroll.setBounds(450, 350, 50, 300);
        scroll.setBackground(new Color(0,128,128));
        
        

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b2){
            p2.setVisible(false);
             ThirdPage h=new ThirdPage();
        }

    }
    
}
