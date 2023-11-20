package src.Entities;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    
    public int xPos;
    public int yPos;
    public int tileSize;
    public int velocity;
    
    public BufferedImage[] upSprite, downSprite, leftSprite, rightSprite;

    public Rectangle rec;
    public boolean collider;
    public boolean isActive;

    
}
