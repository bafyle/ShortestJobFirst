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
import shortestjobfirst.*;
/**
 *
 * @author vip
 */
public class ThirdPage implements ActionListener {
    JFrame r=new JFrame();
    JTextArea waitArea = new JTextArea();
    JButton b3=new JButton("BACK");

    public ThirdPage(ArrayList<shortestjobfirst.Process> ps, SJF algo)
    {
        CustomPanel p3 = new CustomPanel(ps, algo.getBiggestCycle());
        r.setVisible(true);
        r.setSize(1100, 600);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setLayout(new BorderLayout());
        r.setLocation(30,30);
        r.setResizable(false);
        
        
        waitArea.setText("Average waiting time: " + algo.calculateWaitingTime() + "\n");
        waitArea.setFont(new Font(Font.MONOSPACED, 0, 18));
        waitArea.setEditable(false);
        waitArea.setBounds(40, 350, 300, 200);
        for(int i = 0; i < ps.size(); i++)
        {
            waitArea.setText(waitArea.getText() + "Process " + (i+1) + " wait time: " + ps.get(i).waitingTime + "\n");
        }
        JScrollPane sp = new JScrollPane(waitArea);
        sp.setBounds(40, 350, 300, 200);
        
        p3.add(b3);
        //p3.add(waitLabel);
        
        
        p3.setLayout(null);
        p3.setBackground(new Color(52,73,94));
        b3.setBounds(500, 500, 140, 60);
        b3.setBackground(new Color(230,126,34));
        b3.setForeground(new Color(52,73,94));
        b3.setFont(new Font("italic",Font.ITALIC,15));
        b3.addActionListener(this);
        p3.add(sp);
        //p3.add(waitArea);
        r.add(p3);
        p3.setVisible(false);
        p3.setVisible(true);
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
