package shortestjobfirst;

import javax.swing.*;
import GuiProject.*;

public class Main
{
    public static void main(String[] args)
    {
        //Make the window 1100 x 600
        // set the default layout and to resizable
        // set layout to defualt or Border layout in the third panel;
        /*JFrame mainFrame = new JFrame("Shortest job first");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1100, 600);
        mainFrame.setLayout(null);
        mainFrame.setResizable(false);
        
        Panels s = new Panels(mainFrame);
        mainFrame.add(s.panel1());
        

        mainFrame.setVisible(true);*/
        FirstPage s = new FirstPage();
    }
}
