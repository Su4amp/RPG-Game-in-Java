package src.Entities;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    
    int xPos;
    int yPos;
    int tileSize;
    int velocity;
    
    BufferedImage[] upSprite, downSprite, leftSprite, rightSprite;

    Rectangle rec;
    public boolean collider;
    boolean isActive;

    
}
