package com.leslie.realm.graphics;

import com.leslie.realm.level.tile.Tile;

import java.util.Random;

public class Screen {
    public int width;
    public int height;
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
            int yPixels = y + yOffset;
            if(yPixels <0 | yPixels >= height) continue;

            for(int x=0; x<this.width ; x++){
                int xPixels = x + xOffset; //the offset
                if(xPixels <0 | xPixels > width) continue;

                //int tileIndex = (x / 16) + (y / 16) * 64;
                //int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE;
                /*SET THE OFFSET FOR THE MAP !!*/
                pixels[xPixels + yPixels * width] = /*tiles[tileIndex];*/Sprite.trees.pixels[(x&63) + (y&63) * Sprite.trees.size];
                //throw new ArrayIndexOutOfBoundsException();
            }
        }
    }

    /* Display the Tile*/
    public void renderTile(int xPosition, int yPosition, Tile tile){
        /*rendering individual Tiles*/
        for(int y=0; y< tile.sprite.size; y++){
            int yAbsolute = y + yPosition;
            for(int x=0; x<tile.sprite.size; x++){
                int xAbsolute = x + xPosition;

                /*EVITER L INFINI */
                if(xAbsolute < 0 || xAbsolute >= width || yAbsolute > 0 || yAbsolute >= width) break;

                pixels[xAbsolute + yAbsolute * width] = tile.sprite.pixels[x + y * tile.sprite.size];
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
