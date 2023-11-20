package src.Map;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import src.Entities.Entity;

public class Tile extends Entity{

    public int xPos = 0;
    public int yPos = 0;

    boolean collider;
    BufferedImage tile;
    int tileSize;    
    Rectangle rec;
}
