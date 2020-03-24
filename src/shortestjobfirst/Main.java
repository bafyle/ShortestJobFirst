package shortestjobfirst;

import javax.swing.*;
import java.awt.*;

class CustomPanel extends JPanel
{
    private final int lineY1 = 300;
    private final int lineY2 = 250;
    private final int StringY = 275;
    private final int numberY = 325;
    @Override
    public void paint(Graphics g)
    {
        g.drawRect(40, 250, 1000, 50);
    }
}

public class Main
{
    public static void main(String[] args)
    {
        //Make the window 1100 x 600
        // set the default layout and to resizable
        JFrame mainFrame = new JFrame("test");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1100, 600);
        //mainFrame.setLayout(null);
        mainFrame.setResizable(false);
        JPanel chartPanel = new CustomPanel();
        mainFrame.add(chartPanel);
        
        
        
        mainFrame.setVisible(true);
    }
}
