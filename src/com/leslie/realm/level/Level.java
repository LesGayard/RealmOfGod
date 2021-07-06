package com.leslie.realm.level;

import com.leslie.realm.graphics.Screen;
import com.leslie.realm.level.tile.Tile;

/*Make it abstract*/
public class Level {

    protected int width;
    protected int height;
    /*the integers are the ID for the tiles*/
    protected int[] tiles;

    /*CONSTRUCTOR*/
     public Level(){}
     /*Generate random level*/
    public Level(int width, int height){
        this.width = width;
        this.height = height;
        tiles = new int[width * height];

        generateLevel();
    }

    /*Constructor by file*/
    public Level(String path){
        loadLevel(path);
    }

    /*METHODS*/
    private void loadLevel(String path) {
    }

    protected void generateLevel() {}

    /*generate time cycle*/
    private void time(){}

    /*update the level */
    public void update(){}


    public void render(int xScroll, int yScroll, Screen screen){
        screen.setOffset(xScroll,yScroll);
        /*Theses offset variables define the render region*/
        int x0 = xScroll >>6 ;// equivalent to int x0 = xScroll /16;
        int x1 = (xScroll + screen.width  + 2) >>6;
        int y0 = yScroll >>6;
        int y1 = (yScroll + screen.height  +2) >>6;

        for(int y=y0; y<y1; y++){
            for(int x=x0 ; x<x1; x++){
                /* GET THE RIGHT TILE TO RENDER */
                getTile(x,y).render(x,y,screen);
            }
        }


    }

    public Tile getTile (int x, int y){
        /* int x and int y are the  Tile coordonnées */
        if(x < 0 || y < 0 || x>= width || y>= height) return Tile.voidTile;
        if(tiles[x+y * width] == 0) return Tile.tree;
        return Tile.voidTile;
    }
}
