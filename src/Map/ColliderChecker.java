package src.Map;

import src.Entities.Entity;

import src.Main.MainPanel;

public class ColliderChecker {
    MainPanel mPanel;
    MapManager manager;

    public ColliderChecker(MainPanel panel, MapManager mapMan){
        this.mPanel = panel;
        this.manager = mapMan;
    }

    public void checkCollider(Entity player){
        /*if (player.rec.intersects(manager.furnituresTiles[1].rec)) {
            System.out.println("colidiu!");
        }*/
    }
}
