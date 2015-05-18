package pkg2048game;

import java.awt.Color;


public class Tile
{
  static int TileValue=2;

  public Tile(int value) 
  {
   value=TileValue;
  }
  
  public boolean isEmpty() 
  {
    return TileValue == 0;
  }
  public static Color TileBackground() 
  {
    if(TileValue==2)
        return new Color(247,247,247);
    else if(TileValue==4)
        return new Color(240,240,215);
    else if(TileValue==8)
        return new Color(255,224,0);
    else if(TileValue==16)
        return new Color(255,224,9);
    else if(TileValue==32)
        return new Color(255,102,102);
    else if(TileValue==64)
        return new Color(255,0,0);
    else if(TileValue==128)
        return new Color(255,255,153);
    else if(TileValue==256)
        return new Color(255,255,102);
    else if(TileValue==512)
        return new Color(250,240,55);
    else if(TileValue==1024)
        return new Color(250,240,40);
    else if(TileValue==2048)
        return new Color(250,240,0);
       return Color.LIGHT_GRAY;
  }
}