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
import java.util.ArrayList;
import javax.swing.*;
import shortestjobfirst.SJF;

/**
 *
 * @author vip
 */
public class SecondPage implements ActionListener
{
    JFrame m = new JFrame();
    JPanel p2=new JPanel();
    JButton b2=new JButton("calculate");
    private final int processNumber;
    private ArrayList<JTextField> arrivals = new ArrayList<>();
    private ArrayList<JTextField> ends = new ArrayList<>();
    private ArrayList<shortestjobfirst.Process> processes = new ArrayList<>();
    private SJF algo;
    int numberOfPresses = 0;
    boolean zeroFound = false;
    public SecondPage(int pn)
    {
        processNumber = pn;
        m.setTitle("Shortest Job First");
        
        m.setSize(600,400);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m.setLayout(null);
        m.setLocation(30,30);
        p2.setLayout(null);
        m.add(p2);
        
        JLabel processNameL = new JLabel();
        processNameL.setText("Process number: " + (numberOfPresses+1));
        processNameL.setBounds(10, 10, 200, 30);
        processNameL.setFont(new Font(Font.MONOSPACED, 0, 18));
        p2.add(processNameL);
        
        JLabel arrivalL = new JLabel("Arrival time");
        JLabel burstL = new JLabel("Burst time");
        burstL.setFont(new Font(Font.DIALOG, 0, 16));
        arrivalL.setBounds(150, 100, 100, 30);
        burstL.setBounds(300, 100, 100, 30);
        arrivalL.setFont(new Font(Font.DIALOG, 0, 16));
        p2.add(burstL);
        p2.add(arrivalL);
        
        JTextField t1 = new JTextField();
        t1.setBounds(150, 130, 100, 30);
        p2.add(t1);
        
        JTextField t2 = new JTextField();
        t2.setBounds(300, 130, 100, 30);
        p2.add(t2);
        
        JButton addBtn = new JButton("Add");
        addBtn.setBounds(10, 270, 140, 60);
        addBtn.setBackground(new Color(0,128,128));
        addBtn.setForeground(new Color(52,73,94));
        addBtn.setFont(new Font("italic",Font.BOLD,18));
        addBtn.addActionListener((ActionEvent e)->
        {
            try
            {
                NumberFormatException throwError = new NumberFormatException();
                int arrival = Integer.parseInt(t1.getText().trim());
                int burst = Integer.parseInt(t2.getText().trim());
                if(arrival < 0 || burst <= 0)
                    throw throwError;
                if(arrival == 0)
                    zeroFound = true;
                shortestjobfirst.Process s = new shortestjobfirst.Process();
                s.processID = numberOfPresses + 1;
                s.arrivalTime = arrival;
                s.burstTime = burst;
                s.remainingTime = burst;
                processes.add(s);
                numberOfPresses++;
                if(numberOfPresses == processNumber)
                {
                    addBtn.setEnabled(false);
                    t1.setEnabled(false);
                    t2.setEnabled(false);
                }
                else
                    processNameL.setText("Process number: " + (numberOfPresses+1));
                t1.setText("");
                t2.setText("");
                t1.requestFocus();
                
            }
            catch(NumberFormatException error)
            {
                JOptionPane.showConfirmDialog(p2, "Please fill every field correclty", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            }
        });
        p2.add(addBtn);
        
        JButton backBtn = new JButton("Back");
        backBtn.setBounds(480, 10, 100, 50);
        backBtn.setBackground(new Color(230,126,34));
        backBtn.setForeground(new Color(52,73,94));
        backBtn.setFont(new Font("italic",Font.ITALIC,15));
        backBtn.addActionListener((ActionEvent ee)->
        {
            m.setVisible(false);
            FirstPage pf = new FirstPage();
        });
        p2.add(backBtn);
        
        p2.setBackground(new Color(0,128,128));
        p2.setSize(m.getSize());
        b2.setBounds(570-140, 270, 140, 60);
        b2.setBackground(new Color(0,128,128));
        b2.setForeground(new Color(52,73,94));
        b2.setFont(new Font("italic",Font.BOLD,18));
        b2.addActionListener(this);
        p2.add(b2);
        m.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b2)
        {
            if(numberOfPresses != processNumber)
                JOptionPane.showConfirmDialog(p2, "Please enter all processes data", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            else if(zeroFound == false)
                JOptionPane.showConfirmDialog(p2, "You did not enter a process with arrival time equals zero", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            else
            {
                algo = new SJF(processes);
                algo.start();
                p2.setVisible(false);
                m.setVisible(false);
                ThirdPage h=new ThirdPage(processes, algo);
            }
            /*
            boolean zeroFound = false;
            int validTextFields = 0;
            for(JTextField s : arrivals)
            {
                if(s.getText().trim() != null && !s.getText().trim().equals(""))
                {
                    validTextFields++;
                }
                else
                    break;
                String f = s.getText().trim();
                int ff;
                try
                {
                    ff = Integer.parseInt(f);
                }
                catch(NumberFormatException error){break;}
                if(ff == 0)
                {
                    zeroFound = true;
                }
            }
            for(JTextField s : ends)
            {
                String f = s.getText().trim();
                int ff;
                try
                {
                    ff = Integer.parseInt(f);
                }
                catch(NumberFormatException error){break;}
                if(s.getText().trim() != null && !s.getText().trim().equals("") && ff > 0)
                {
                    validTextFields++;
                }
                else
                    break;
            }
            if(zeroFound && validTextFields == (arrivals.size() + ends.size()))
            {
                for(int i = 0; i < arrivals.size(); i++)
                {
                    shortestjobfirst.Process s = new shortestjobfirst.Process();
                    s.arrivalTime = Integer.parseInt(arrivals.get(i).getText().trim());
                    s.burstTime = Integer.parseInt(ends.get(i).getText().trim());
                    s.processID = i+1;
                    s.remainingTime = s.burstTime;
                    processes.add(s);
                }
                
                algo = new SJF(processes);
                algo.start();
                p2.setVisible(false);
                m.setVisible(false);
                ThirdPage h=new ThirdPage(processes, algo);
            }
            else
                JOptionPane.showConfirmDialog(p2, "Please fill every field correclty", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            */
        }
    }
}
