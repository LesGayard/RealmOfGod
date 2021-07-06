package com.leslie.realm.entity.mob;

import com.leslie.realm.entity.Entity;
import com.leslie.realm.graphics.Sprite;

/* The Mob is the creature who moves = the player...*/
public abstract class Mob extends Entity {

    /*Mob has sprite*/
    protected Sprite sprite;
    protected int direction = 0;
    protected boolean moving = false;

    public void move(){
    }

    public void update(){}

    /*collision*/
    private boolean collision(){
        return false;
    }
}
