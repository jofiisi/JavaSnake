package Action;

import clocks.GameCLock;
import game.Snake;
import game.Tail;
import gui.Gui;

import java.io.IOException;


public class Main
{
    public static void main(String[] args) throws IOException {
        Gui g = new Gui();
        GameCLock gc = new GameCLock();
        g.create();
        gc.start();

    }
}
