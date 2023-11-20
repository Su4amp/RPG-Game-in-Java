package src.Entities;

import src.Main.MainPanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import src.Listeners.KeyHandler;

public class Player extends Entity {

    MainPanel panel;
    public String direction = "down";
    KeyHandler kHandler;

    BufferedImage actualSprite;

    public Player(MainPanel panel) {

        upSprite = new BufferedImage[3];
        downSprite = new BufferedImage[3];
        leftSprite = new BufferedImage[3];
        rightSprite = new BufferedImage[3];
        rec = new Rectangle();

        this.panel = panel;
        this.kHandler = panel.kHandler;
        this.tileSize = panel.TileSize;
        loadSprites();

        xPos = (panel.screenWidht / 2) - 24;
        yPos = panel.screenHeight / 2;
        velocity = 3;

        rec.x = xPos;
        rec.y = yPos;

        rec.width = tileSize / 2;
        rec.height = tileSize / 2;
    }

    public void loadSprites() {
        try {
            downSprite[0] = ImageIO
                    .read(getClass().getResourceAsStream("/src/Resources/Sprites/Player/playerDown1.png"));
            downSprite[1] = ImageIO
                    .read(getClass().getResourceAsStream("/src/Resources/Sprites/Player/playerDown2.png"));
            downSprite[2] = ImageIO
                    .read(getClass().getResourceAsStream("/src/Resources/Sprites/Player/playerDown3.png"));

            leftSprite[0] = ImageIO
                    .read(getClass().getResourceAsStream("/src/Resources/Sprites/Player/playerLeft1.png"));
            leftSprite[1] = ImageIO
                    .read(getClass().getResourceAsStream("/src/Resources/Sprites/Player/playerLeft2.png"));
            leftSprite[2] = ImageIO
                    .read(getClass().getResourceAsStream("/src/Resources/Sprites/Player/playerLeft3.png"));

            rightSprite[0] = ImageIO
                    .read(getClass().getResourceAsStream("/src/Resources/Sprites/Player/playerRight1.png"));
            rightSprite[1] = ImageIO
                    .read(getClass().getResourceAsStream("/src/Resources/Sprites/Player/playerRight2.png"));
            rightSprite[2] = ImageIO
                    .read(getClass().getResourceAsStream("/src/Resources/Sprites/Player/playerRight3.png"));

            upSprite[0] = ImageIO
                    .read(getClass().getResourceAsStream("/src/Resources/Sprites/Player/playerUp1.png"));
            upSprite[1] = ImageIO
                    .read(getClass().getResourceAsStream("/src/Resources/Sprites/Player/playerUp2.png"));
            upSprite[2] = ImageIO
                    .read(getClass().getResourceAsStream("/src/Resources/Sprites/Player/playerUp3.png"));
        } catch (Exception e) {
            System.out.println("erro na hora de carregar as imagens");
        }
    }

    int counter = 0;
    int frame = 1;
    int spriteNum = 0;

    public void drawPlayer(Graphics2D g2) {
        g2.drawImage(animatePlayer(), xPos, yPos, tileSize, tileSize, null);
    }

    public BufferedImage animatePlayer() {
        counter++;
    
        if (counter > 12) {
            frame = (frame == 1) ? 2 : 1;
            counter = 0;
        }
    
        if (!panel.kHandler.up && !panel.kHandler.down && !panel.kHandler.left && !panel.kHandler.right) {
            actualSprite = getDirectionSprite(direction);
        } else {
            actualSprite = getDirectionSprite(direction);
        }
    
        return actualSprite;
    }
    
    private BufferedImage getDirectionSprite(String dir) {
        switch (dir) {
            case "up":
                return (!panel.kHandler.up) ? upSprite[0] : upSprite[frame];
            case "down":
                return (!panel.kHandler.down) ? downSprite[0] : downSprite[frame];
            case "left":
                return (!panel.kHandler.left) ? leftSprite[0] : leftSprite[frame];
            case "right":
                return (!panel.kHandler.right) ? rightSprite[0] : rightSprite[frame];
            default:
                return null; // Handle invalid direction
        }
    }

    public void updatePlayer() {

        collider = false;
        panel.coChecker.checkCollider(this);

        if (panel.kHandler.up == true) {
            yPos -= velocity;
            direction = "up";

        } else if (panel.kHandler.down == true) {
            yPos += velocity;
            direction = "down";

        } else if (panel.kHandler.left == true) {
            xPos -= velocity;
            direction = "left";

        } else if (panel.kHandler.right == true) {
            xPos += velocity;
            direction = "right";

        }

    }

}
