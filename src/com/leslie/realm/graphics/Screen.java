package com.leslie.realm.graphics;

import java.util.Random;

public class Screen {
    private int width;
    private int height;
    public int[] pixels;
    public int[] tiles = new int[64 * 64];
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

        for(int i=0; i<tiles.length;i++){
            tiles[i] = random.nextInt(0xffffff);
        }
    }

    /*Display Image*/
    public void render() {
        counter++;
        if(counter % 100 == 0) xtime++;
        if(counter % 80 == 0) ytime++;

        for(int y=0; y<this.height ; y++){
            //ArrayBoundException
            if(y <0 | y >= height) break;

            for(int x=0; x<this.width ; x++){
                if(x <0 | x > width) break;
                //int tileIndex = (x / 16) + (y / 16) * 64;
                int tileIndex = (x>>4) + (y>>4) * 64;
                pixels[x + y * width] = tiles[tileIndex];
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
