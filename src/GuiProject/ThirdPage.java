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
        r.setTitle("Shorest Job First");
        r.setLayout(null);
        r.setSize(1100, 400);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setLayout(new BorderLayout());
        r.setLocation(30,30);
        r.setResizable(false);
        
        CustomPanel p3 = new CustomPanel(ps, algo.getBiggestCycle());

        p3.setLayout(null);

        waitArea.setText("Average waiting time: " + algo.calculateWaitingTime() + "\n");
        waitArea.setFont(new Font(Font.MONOSPACED, 0, 18));
        waitArea.setBounds(50, 10, 100, 200);
        waitArea.setEditable(false);
        
        for(int i = 0; i < ps.size(); i++)
        {
            waitArea.setText(waitArea.getText() + "Process " + (i+1) + " wait time: " + ps.get(i).waitingTime + "\n");
        }
        JScrollPane sp = new JScrollPane(waitArea);
        //sp.setPreferredSize(new Dimension(300, 200));
        sp.setBounds(50, 10, 500, 200);
        p3.add(sp);

        b3.setBackground(new Color(230,126,34));
        b3.setForeground(new Color(52,73,94));
        b3.setBounds(980, 10, 100, 30);
        b3.setFont(new Font("italic",Font.ITALIC,15));
        b3.addActionListener(this);
        
        p3.add(b3);

        r.add(p3);
        r.setVisible(true);
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
