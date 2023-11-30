package src.Entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import src.Main.MainPanel;

public class Player extends Entity {

    MainPanel panel;
    String direction = "down";  

    BufferedImage actualSprite;
    int numberOfSprites = 4;

    public Player(MainPanel panel) {

        loadSprites();        

        this.panel = panel;
        xPos = 400;
        yPos = 500;
        tileSize = panel.TileSize;
        actualSprite = downIdle[0];       
    }

    public void loadSprites() {

        downIdle = new BufferedImage[numberOfSprites];
        upIdle = new BufferedImage[numberOfSprites];
        leftIdle = new BufferedImage[numberOfSprites];
        rightIdle = new BufferedImage[numberOfSprites];

        downSprite = new BufferedImage[numberOfSprites];
        upSprite = new BufferedImage[numberOfSprites];
        leftSprite = new BufferedImage[numberOfSprites];
        rightSprite = new BufferedImage[numberOfSprites];

        try {
            // IDLE ANIMATIONS
            for (int i = 0; i < numberOfSprites; i++) {
                int j= i+1;
                downIdle[i] = ImageIO.read(getClass().getResourceAsStream("/src/Resources/Sprites/Player/DOWN/DownIdle"+ j +".png"));
                upIdle[i] = ImageIO.read(getClass().getResourceAsStream("/src/Resources/Sprites/Player/UP/UpIdle" + j + ".png"));
                leftIdle[i] = ImageIO.read(getClass().getResourceAsStream("/src/Resources/Sprites/Player/LEFT/LeftIdle" + j + ".png"));
                rightIdle[i] = ImageIO.read(getClass().getResourceAsStream("/src/Resources/Sprites/Player/RIGHT/RightIdle" + j + ".png"));
            }

            //ANIMATION Sprites
            for (int i = 0; i < numberOfSprites; i++) {
                int j = i+1;
                downSprite[i] = ImageIO.read(getClass().getResourceAsStream("/src/Resources/Sprites/Player/DOWN/Down"+ j + ".png"));
                upSprite[i] = ImageIO.read(getClass().getResourceAsStream("/src/Resources/Sprites/Player/UP/Up" + j + ".png"));
                leftSprite[i] = ImageIO.read(getClass().getResourceAsStream("/src/Resources/Sprites/Player/LEFT/Left"+ j +".png"));
                rightSprite[i] = ImageIO.read(getClass().getResourceAsStream("/src/Resources/Sprites/Player/RIGHT/Right"+ j +".png"));
            }

        } catch (IOException e) {
            System.out.println("Deu erro na hora de ler a imagem!");
        }
    }

    public void drawPlayer(Graphics2D g2) {
        g2.drawImage(spriteAnimation(), xPos, yPos, tileSize, tileSize, null);
    }

    int downIdleCounter = 0;
    int upIdleCounter = 0;
    int leftIdleCounter = 0;
    int rightIdleCounter = 0;

    int frameCounter = 0;

    int frame = 0;
    int spriteFrame = 0;
    
    public BufferedImage spriteAnimation() {

        

        if (direction.equals("down") && panel.kHandler.down) {
            frameCounter++;

            if (frameCounter >= 12) {
                actualSprite = downSprite[spriteFrame];
                spriteFrame = (spriteFrame == 0) ? 1 : (spriteFrame == 1) ? 2 : (spriteFrame == 2) ? 3 : 0;                
                frameCounter = 0;
            }

        } else if (direction.equals("up") && panel.kHandler.up) {
            frameCounter++;
            
            if (frameCounter >= 12) {
                actualSprite = upSprite[spriteFrame];
                spriteFrame = (spriteFrame == 0) ? 1 : (spriteFrame == 1) ? 2 : (spriteFrame == 2) ? 3 : 0;                
                frameCounter = 0;
            }
        } else if (direction.equals("left") && panel.kHandler.left) {
            frameCounter++;

            if (frameCounter >= 12) {
                actualSprite = leftSprite[spriteFrame];
                spriteFrame = (spriteFrame == 0) ? 1 : (spriteFrame == 1) ? 2 : (spriteFrame == 2) ? 3 : 0;                
                frameCounter = 0;
            }
        } else if (direction.equals("right") && panel.kHandler.right) {
            frameCounter++;

            if (frameCounter >= 12) {
                actualSprite = rightSprite[spriteFrame];
                spriteFrame = (spriteFrame == 0) ? 1 : (spriteFrame == 1) ? 2 : (spriteFrame == 2) ? 3 : 0;                
                frameCounter = 0;
            }
        }

        // idle animation
        if (!panel.kHandler.up && !panel.kHandler.down && !panel.kHandler.left && !panel.kHandler.right) {

            if (direction.equals("down")) {
                downIdleCounter++;
                if (downIdleCounter >= 20) {
                    frame = (frame + 1) % 4;
                    actualSprite = downIdle[frame];
                    downIdleCounter = 0;
                }
            }

            if (direction.equals("up")) {
                upIdleCounter++;
                if (upIdleCounter >= 20) {
                    frame = (frame + 1) % 4;
                    actualSprite = upIdle[frame];
                    upIdleCounter = 0;
                }
            }

            if (direction.equals("right")) {
                rightIdleCounter++;
                if (rightIdleCounter >= 20) {
                    frame = (frame + 1) % 4;
                    actualSprite = rightIdle[frame];
                    rightIdleCounter = 0;
                }
            }

            if (direction.equals("left")) {
                leftIdleCounter++;
                if (leftIdleCounter >= 20) {
                    frame = (frame + 1) % 4;
                    actualSprite = leftIdle[frame];
                    leftIdleCounter = 0;
                }
            }
        }
        
        return actualSprite;
    }

    public void updatePlayer() {

        if (panel.kHandler.up) {
            yPos -= 5;
            direction = "up";            
        } else if (panel.kHandler.down) {
            yPos += 5;
            direction = "down";            
        } else if (panel.kHandler.left) {
            xPos -= 5;
            direction = "left";            
        } else if (panel.kHandler.right) {
            xPos += 5;
            direction = "right";            
        }
    }
}