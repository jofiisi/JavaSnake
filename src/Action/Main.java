package Action;

import clocks.GameCLock;
import game.Tail;
import gui.Gui;

public class Main
{
    public static void main(String[] args)
    {
        Gui g = new Gui();
        GameCLock gc = new GameCLock();
        g.create();
        gc.start();
    }
}
