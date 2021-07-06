package com.leslie.realm.entity.mob;

import com.leslie.realm.entity.Entity;
import com.leslie.realm.graphics.Sprite;

/* The Mob is the creature who moves = the player...*/
public abstract class Mob extends Entity {

    /*Mob has sprite*/
    protected Sprite sprite;
    protected int direction = 0;
    protected boolean moving = false;

    /* controls how pixels move on the screen */
    public void move( int xMove, int yMove){
        /* Determine the direction the Mob is moving */
        if(xMove > 0 ) direction = 1; // East
        if(xMove < 0 ) direction = 3; // West
        if(yMove > 0 ) direction = 2; //South
        if(yMove < 0 ) direction = 0; // North


        /* 3 possibilities for x and y : left - right -up - down - no movement */
        /* -1 / 0 / +1 */
        if(!collision()){
            x += xMove;
            y += yMove;
        }


    }

    public void update(){}

    /*collision*/
    private boolean collision(){
        return false;
    }

    public void render(){}
}
