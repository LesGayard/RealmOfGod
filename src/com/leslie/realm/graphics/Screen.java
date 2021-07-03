package com.leslie.realm.graphics;

import java.util.Random;

public class Screen {
    private int width;
    private int height;
    public int[] pixels;

    public final int MAP_SIZE = 2048;
    public final int MAP_SIZE_MASK = MAP_SIZE - 1;

    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
    /*Rendering random colors*/
    private Random random = new Random();

    /*Animation*/
    int xtime = 0;
    int ytime = 0;
    int counter = 0;

    //constructor
    public Screen(int width, int height){
        this.width = width;
        this.height = height;
        pixels = new int [width * height];

        for(int i=0; i< MAP_SIZE * MAP_SIZE ;i++){
            tiles[i] = random.nextInt(0xffffff);
            tiles[0] = 0;
        }
    }

    /*Display Image*/
    public void render(int xOffset, int yOffset) {
        counter++;
        if(counter % 100 == 0) xtime++;
        if(counter % 80 == 0) ytime++;

        for(int y=0; y<this.height ; y++){
            //ArrayBoundException
            int yy = y + yOffset;
            //if(yy <0 | yy >= height) break;

            for(int x=0; x<this.width ; x++){
                int xx = x + xOffset; //the offset
                //if(xx <0 | xx > width) break;

                //int tileIndex = (x / 16) + (y / 16) * 64;
                int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE;
                pixels[x + y * width] = /*tiles[tileIndex];*/Sprite.trees.pixels[(x&63) + (y&63) * Sprite.trees.size];
                //throw new ArrayIndexOutOfBoundsException();
            }
        }
    }

    /*Clear Image*/
    public void clear(){
        for(int i=0; i<pixels.length; i++){
            pixels[i] = 0;

        }
    }
}
