package gui;

import game.Snake;

import javax.swing.*;
import java.awt.*;



public class Draw extends JLabel
{
    int R=0, G=0, B=0;


    protected void  paintComponent(Graphics g)
    {
        Point p;
        Color rgb = new Color(R,G,B);

        if(R < 255 & B == 0 & G==0)
        {
            R++;
        }else{
            R=0;
        }

        if(G < 255 & R == 0 & B==0)
        {
            G++;
        }else{
            G=0;
        }

        if(B < 255 & R == 0& G==0)
        {
            B++;
        }else{
            B=0;
        }



        super.paintComponent(g);
        Graphics2D g2d =(Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, Gui.width, Gui.height);

        g.setColor(new Color(51, 203, 71));
        for(int i = 0; i< Snake.tails.size(); i++)
        {
            p = Snake.ptc(Snake.tails.get(i).getX(), Snake.tails.get(i).getY());
            g.fillRect(p.x, p.y, 32 ,32);
        }

        g.setColor(new Color(9, 85, 11));
        p = Snake.ptc(Snake.head.getX(), Snake.head.getY());
        g.fillRect(p.x, p.y, 32 ,32);

        g.setColor(new Color(220, 51, 0));
        p = Snake.ptc(Snake.pickUp.getX(), Snake.pickUp.getY());
        g.fillRect(p.x, p.y, 32, 32);

        g.setColor(Color.GRAY);
        for(int x = 0; x < 16; x++)
        {
            for (int y = 0; y < 16; y++)
            {
                g.drawRect(x*32 + Gui.xoff, y * 32 + Gui.yoff, 32 , 32);
            }
        }

        g.setColor(Color.BLACK);
        g.drawRect(Gui.xoff, Gui.yoff, 512, 512);

        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + Snake.score,5,25 );
        g.drawString("Best Score: " +Snake.bestscore, 645, 25);

        repaint();
    }
}
