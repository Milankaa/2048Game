package pkg2048game;

import java.awt.Color;
import java.awt.Font;

public class Tile {

    private int TileValue;

    public Tile(int value) {
        TileValue = value;
    }

    public Tile() {

    }

    public int getTileValue() {
        return TileValue;
    }

    public void setTileValue(int Value) {
        TileValue = Value;
    }
    

    public boolean isEmpty() {
        return TileValue == 0;
    }
    public Font TileValueFont()
    {
        if(TileValue<1000)
            return new Font("Arial", Font.BOLD, 45);
        else
            return new Font("Arial", Font.BOLD,36);
        
    }
    public Color TileValueColor() {
        if (TileValue < 8) {
            return Color.GRAY;
        } else {
            return Color.WHITE;
        }
    }

    public static Color TileBackground(int TileValue) {
        if (TileValue == 2) {
            return new Color(238,228,218);
        } else if (TileValue == 4) {
            return new Color(237,224,200);
        } else if (TileValue == 8) {
            return new Color(242,177,121);
        } else if (TileValue == 16) {
            return new Color(245,149,99);
        } else if (TileValue == 32) {
            return new Color(246,124,95);
        } else if (TileValue == 64) {
            return new Color(246,94,59);
        } else if (TileValue == 128) {
            return new Color(237,207,114);
        } else if (TileValue == 256) {
            return new Color(237,204,97);
        } else if (TileValue == 512) {
            return new Color(237,199,79);
        } else if (TileValue == 1024) {
            return new Color(237,197,63);
        } else if (TileValue == 2048) {
            return new Color(237,194,46);
        }
        return new Color(60,58,50);
    }
}
 