package src.Entities;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    
    public int xPos;
    public int yPos;
    public int tileSize;
    public int velocity;
    
    BufferedImage[] upSprite, downSprite, leftSprite, rightSprite;
    BufferedImage[] downIdle, upIdle, leftIdle, rightIdle;

    public Rectangle rec;
    public boolean collider;
    public boolean isActive;

    
}
