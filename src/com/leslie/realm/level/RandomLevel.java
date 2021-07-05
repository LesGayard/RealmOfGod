package com.leslie.realm.level;

import java.util.Random;

public class RandomLevel extends Level{

    /**Generates Random numbers or booleans */
    private final Random random = new Random();

    public RandomLevel(int width, int height){
        super(width, height);
    }

    @Override
    protected void generateLevel() {
        /*nested loop for controlling more specific tile*/
        for(int y=0; y< height; y++){
            for( int x=0; x<width; x++){
                /*fill the tile array with values...*/
                tiles[x+y * width] = random.nextInt(4);

            }
        }
    }
}
