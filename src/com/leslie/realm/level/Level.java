package com.leslie.realm.level;

import com.leslie.realm.graphics.Screen;

public class Level {

    private int width;
    private int height;
    private int[] tiles;

    /*CONSTRUCTOR*/
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

    private void generateLevel() {}

    /*generate time cycle*/
    private void time(){}

    /*update the level */
    public void update(){}


    public void render(int xScroll, int yScroll, Screen sreen){}
}
