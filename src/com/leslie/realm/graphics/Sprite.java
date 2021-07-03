package com.leslie.realm.graphics;

public class Sprite {

    public  int size; //may be 16 or 32 for monsters
    private int x,y;
    public int[] pixels;
    private SpriteSheet sheet;



    //THE GRASS TEXTURE -> UNIQUE
    public static Sprite trees = new Sprite(146, 0, 0, SpriteSheet.tiles);
    /*Constructor*/
    public Sprite( int size, int x, int y, SpriteSheet sheet){
        this.size = size;
        pixels = new int[size * size];
        this.x = x * size;
        this.y = y * size;
        this.sheet = sheet;

        load();

    }

    /*GETTERS + SETTERS*/
    public int getSIZE(){
        return this.size;
    }

    /*LOAD METHOD*/
    private void load(){
        //access the spritesheet pixels and find the right sprite
        /*FOR NESTED LOOPS...*/
        for(int y=0; y<size; y++){
            for(x=0; x<size; x++){
                pixels[x+y * size] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.size];
            }
        }
    }
}
