package clocks;

import Action.Collision;
import game.Snake;
import gui.Draw;

public class GameCLock extends Thread
{
    public static boolean running = true;

    public void run()
    {
        while(running)
        {
            try {
                sleep(200);
                Snake.move();
                Snake.waitToMove = false;
                Collision.collidePickUp();
                if(Collision.collideSelf())
                {
                    Snake.score = 0;
                    Snake.tails.clear();
                }
                if(Collision.collideWall())
                {
                    Snake.score = 0;
                    Snake.tails.clear();
                    Snake.head.setX(7);
                    Snake.head.setY(7);
                }
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
