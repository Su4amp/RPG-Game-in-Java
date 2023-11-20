package src.Listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    public boolean up, down, left, right;

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            up = true;
        }else if(key == KeyEvent.VK_A){
            left = true;
        }else if (key == KeyEvent.VK_S) {
            down = true;
        }else if(key == KeyEvent.VK_D){
            right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            up = false;
        }else if(key == KeyEvent.VK_A){
            left = false;
        }else if (key == KeyEvent.VK_S) {
            down = false;
        }else if(key == KeyEvent.VK_D){
            right = false;
        }
    }

    public boolean isMoving(String direction) {
        switch (direction) {
            case "up":
                return up;
            case "down":
                return down;
            case "left":
                return left;
            case "right":
                return right;
            default:
                return false; // Direção desconhecida
        }
    }
    
}
