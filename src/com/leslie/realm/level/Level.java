package com.leslie.realm.level;

import com.leslie.realm.graphics.Screen;
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


    public void render(int xScroll, int yScroll, Screen sreen){}
}
