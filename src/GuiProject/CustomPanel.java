package GuiProject;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;


public class CustomPanel extends JPanel
{
    private final int lineY1 = 300;
    private final int lineY2 = 250;
    private final int StringY = 275;
    private final int numberY = 325;
    private int y = 0;
    public ArrayList<shortestjobfirst.Process> ps;
    public int biggestNumber;
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawRect(40, 250+y, 1000, 50);
        //g.drawString(Integer.toString(biggestNumber), 1040, numberY);
        for(shortestjobfirst.Process s : ps)
        {
            for(Integer i : s.startTimes)
            {
                int x = (int)((double)i / (double)biggestNumber * 1000);
                g.drawLine(40 + x, lineY1 + y, 40 + x, lineY2 + y);
                g.drawString(Integer.toString(i), 40 + x, numberY+y);
                g.drawString("P"+s.processID, 40+x, StringY+y);
            }
            for(Integer i : s.endTimes)
            {
                int x = (int)((double)i / (double)biggestNumber * 1000);
                g.drawLine(40 + x, lineY1+y, 40 + x, lineY2+y);
                g.drawString(Integer.toString(i), 40 + x, numberY+y);
                //g.drawString("P"+s.processID, 40+x, StringY);
            }
        }
        
    }
    public CustomPanel(ArrayList<shortestjobfirst.Process> pss, int bn)
    {
        ps = pss;
        biggestNumber = bn;      
    }
    public CustomPanel()
    {
        super();
        ps = null;
    }
}
