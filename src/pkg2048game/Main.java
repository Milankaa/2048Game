package pkg2048game;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Main {

    public static void main(String[] args) {

        TileFrame frame = new TileFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("2048 Game");
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocation(30, 30);
    }
}
 