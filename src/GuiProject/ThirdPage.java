/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author vip
 */
public class ThirdPage implements ActionListener {
    JFrame r=new JFrame();
    JPanel p3=new JPanel();
    JButton b3=new JButton("BACK");
    
    
    
    
    
    public ThirdPage(){
        r.setVisible(true);
        r.setSize(500,400);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setLayout(new BorderLayout());
        r.setLocation(30,30);
        r.add(p3);
        p3.add(b3);
        p3.setLayout(null);
        p3.setBackground(new Color(52,73,94));
        b3.setBounds(180, 270, 140, 60);
        b3.setBackground(new Color(230,126,34));
        b3.setForeground(new Color(52,73,94));
        b3.setFont(new Font("italic",Font.ITALIC,15));
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
