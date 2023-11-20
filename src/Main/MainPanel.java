package src.Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import src.Entities.Player;
import src.Listeners.KeyHandler;
import src.Map.ColliderChecker;
import src.Map.MapManager;


public class MainPanel extends JPanel implements Runnable{

    public final int OriginalTileSize = 16;
    public final int Scale = 3;
    public final int TileSize = (OriginalTileSize * Scale);
    public final int Rows = 13;
    public final int Cols = 17;

    public final int screenWidht = Cols * TileSize;
    public final int screenHeight = Rows * TileSize;

    boolean running = true;

    //objetos, entidades e instancias
    Player player = new Player(this);
    MapManager mapManager = new MapManager(this);
    public KeyHandler kHandler = new KeyHandler();
    public ColliderChecker coChecker = new ColliderChecker(this);

    public MainPanel(){
        this.setPreferredSize(new Dimension(screenWidht, screenHeight));
        this.setBackground(Color.black);   
        this.addKeyListener(kHandler);
        this.setFocusable(true);                
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        mapManager.drawMap(g2);
        player.drawPlayer(g2);
    }

    public void Update(){
        player.updatePlayer();
    }

    Thread thread;
    public void initThread(){
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        int fps = 60;

        long lastTime = System.nanoTime();
        double delta = 0;
        double drawInterval = 1000000000 / fps;
        
        while (running) {

            long currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                Update();
                repaint();
                delta--;
            }
        }
    }
}
