/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author vip
 */
public class ThirdPage implements ActionListener {
    JFrame r=new JFrame();
    CustomPanel p3 = new CustomPanel();
    JButton b3=new JButton("BACK");
    private ArrayList<shortestjobfirst.Process> processes;

    public ThirdPage(ArrayList<shortestjobfirst.Process> ps)
    {
        processes = ps;
        r.setVisible(true);
        r.setSize(1100, 600);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setLayout(new BorderLayout());
        r.setLocation(30,30);
        r.add(p3);
        p3.add(b3);
        p3.setLayout(null);
        p3.setBackground(new Color(52,73,94));
        b3.setBounds(500, 500, 140, 60);
        b3.setBackground(new Color(230,126,34));
        b3.setForeground(new Color(52,73,94));
        b3.setFont(new Font("italic",Font.ITALIC,15));
        b3.addActionListener(this);
        
    }
    public ThirdPage()
    {
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b3){
        r.setVisible(false);
        FirstPage pf = new FirstPage();
        }
    }
    
}
