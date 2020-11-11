package Action;

import clocks.GameCLock;
import gui.Gui;

public class Main
{
    public static void main(String[] args)
    {
        Gui g = new Gui();
        GameCLock gc = new GameCLock();
        g.create();
        gc.start();
        System.out.print("GithubTest");
    }
}
