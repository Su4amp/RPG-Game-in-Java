package src.Map;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

import src.Main.MainPanel;

public class MapManager{

    int[][] map;
    int[][] propsMap;
    int[][] furniture1Map;

    Tile[] floorTiles;
    Tile[] furnituresTiles;


    MainPanel mPanel;
    int tileSize;

    public MapManager(MainPanel mPanel) {
        this.mPanel = mPanel;
        floorTiles = new Tile[100];
        furnituresTiles = new Tile[100];

        tileSize = mPanel.TileSize;
        
        map = new int[mPanel.Rows][mPanel.Cols];
        propsMap = new int[mPanel.Rows][mPanel.Cols];
        furniture1Map = new int[mPanel.Rows][mPanel.Cols];

        //quantos tiles eu vou ter no meu jogo       
        
        loadTilesImages();

        map = loadTextMap("src/Resources/Maps/House.txt", map);
        propsMap = loadTextMap("src/Resources/Maps/HouseProps.txt", propsMap);
        furniture1Map = loadTextMap("src/Resources/Maps/HouseFurniture.txt", furniture1Map);
        
    }

    public int[][] loadTextMap(String path, int[][] map) {
        
        try {
            BufferedReader bReader = new BufferedReader(new FileReader(path));
            String line = "";

            int i = 0;

            while ((line = bReader.readLine()) != null) {
                String[] splitLine = line.split(" ");

                for (int j = 0; j < map[0].length && j < splitLine.length; j++) {
                    map[i][j] = Integer.parseInt(splitLine[j]);                   
                }
                i++;
            }
            bReader.close();

        } catch (IOException e) {
            System.out.println(e);
        }

        return map;
    }

    public void loadTilesImages(){
        try {
            //void
            
            floorTiles[0] = new Tile();
            floorTiles[0].tile = null;

            //floor 1
            floorTiles[1] = new Tile();
            floorTiles[1].tile = ImageIO.read(getClass().getResourceAsStream("/src/Resources/Tiles/Floor1/center1.png"));

            floorTiles[2] = new Tile();
            floorTiles[2].tile = ImageIO.read(getClass().getResourceAsStream("/src/Resources/Tiles/Floor1/center2.png"));

            floorTiles[3] = new Tile();
            floorTiles[3].tile = ImageIO.read(getClass().getResourceAsStream("/src/Resources/Tiles/Floor1/topcenter1.png"));

            floorTiles[4] = new Tile();
            floorTiles[4].tile = ImageIO.read(getClass().getResourceAsStream("/src/Resources/Tiles/Floor1/topcenter2.png"));

            floorTiles[5] = new Tile();
            floorTiles[5].tile = ImageIO.read(getClass().getResourceAsStream("/src/Resources/Tiles/Floor1/topcorner1.png"));

            floorTiles[6] = new Tile();
            floorTiles[6].tile = ImageIO.read(getClass().getResourceAsStream("/src/Resources/Tiles/Floor1/topcorner2.png"));

            floorTiles[7] = new Tile();
            floorTiles[7].tile = ImageIO.read(getClass().getResourceAsStream("/src/Resources/Tiles/Floor1/leftcenter1.png"));

            floorTiles[8] = new Tile();
            floorTiles[8].tile = ImageIO.read(getClass().getResourceAsStream("/src/Resources/Tiles/Floor1/rightcenter1.png"));

            floorTiles[9] = new Tile();
            floorTiles[9].tile = ImageIO.read(getClass().getResourceAsStream("/src/Resources/Tiles/Floor1/bottomcenter1.png"));

            floorTiles[10] = new Tile();
            floorTiles[10].tile = ImageIO.read(getClass().getResourceAsStream("/src/Resources/Tiles/Floor1/bottomcenter2.png"));


            furnituresTiles[0] = new Tile();
            furnituresTiles[0].tile = null;

            furnituresTiles[1] = new Tile();
            furnituresTiles[1].tile = ImageIO.read(getClass().getResourceAsStream("/src/Resources/Tiles/Furniture1/banquinho1.png"));
            furnituresTiles[1].collider = true;
            
            
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void drawMap(Graphics2D g2){
        int xPos = 0;
        int yPos = 0;        

        int x = 0;
        int y = 0;
        

        //drawfloor
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                g2.drawImage(floorTiles[map[i][j]].tile, xPos, yPos, tileSize, tileSize, null);
                xPos += tileSize;                
            }
            yPos += tileSize;
            xPos = 0;            
        }

        //draw furniture
        for (int i = 0; i < furniture1Map.length; i++) {
            for (int j = 0; j < furniture1Map[0].length; j++) {
                
                g2.drawImage(furnituresTiles[furniture1Map[i][j]].tile, x, y, tileSize, tileSize, null);
                x += tileSize;
            }
            y += tileSize;
            x = 0;            
        }
    }
}
