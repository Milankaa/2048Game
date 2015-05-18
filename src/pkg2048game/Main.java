
package pkg2048game;


public class Main
{
    public static void main(String[] args) 
    {
    TileFrame frame = new TileFrame();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setTitle("2048 Game");
    frame.setResizable(false);
    frame.pack();
    }
}