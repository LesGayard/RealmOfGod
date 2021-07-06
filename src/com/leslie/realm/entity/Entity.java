package com.leslie.realm.entity;

import com.leslie.realm.graphics.Screen;
import com.leslie.realm.level.Level;

import java.util.Random;

public abstract class Entity {
    public int x;
    public int y;
    private boolean removed = false;
    protected Level level;
    protected final Random random = new Random();


    public void update(){
        /* run 60 times per second */}

    /* Empty Entities move*/
    public void render(Screen screen){}

    /*Removes entity from the level why not a boolean one ??*/
    public void remove(){
        removed = true;
    }

    public boolean isRemoved() {
        return removed;
    }
}
