package clocks;

import Action.Collision;
import Action.Main;
import game.Snake;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class GameCLock extends Thread
{
    public static boolean running = true;
    public static String scoreF;
    File score = new File("Score.txt");
    public void run()
    {

        while(running)
        {
            try {
                score.createNewFile();
                Scanner scoreR = new Scanner(score);
                while (scoreR.hasNextLine())
                {
                    String scoreS = scoreR.nextLine();
                    Snake.bestscore = Integer.valueOf(scoreS);
                }
                scoreR.close();
                sleep(200);
                Snake.move();
                Snake.waitToMove = false;
                Collision.collidePickUp();
                scoreF = String.valueOf(Snake.bestscore);
                FileWriter scoreW = new FileWriter("Score.txt");
                scoreW.write(scoreF);
                scoreW.close();

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
            } catch (InterruptedException | IOException e)
            {
                e.printStackTrace();
            }

        }
    }
}
