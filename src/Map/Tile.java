package src.Map;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import src.Entities.Entity;

public class Tile extends Entity{
    boolean collider;
    BufferedImage tile;
    int tileSize;    
    Rectangle rec;
}
