package shortestjobfirst;

import GuiProject.SecondPage;
import GuiProject.*;
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
        FirstPage f=new FirstPage();
    }
}
