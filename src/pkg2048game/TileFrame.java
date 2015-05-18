package pkg2048game;

import javax.swing.JFrame;

public class TileFrame extends JFrame 
{
    public TileFrame() 
    {
        TilePanel panel= new TilePanel();
        add(panel);
    }
}
