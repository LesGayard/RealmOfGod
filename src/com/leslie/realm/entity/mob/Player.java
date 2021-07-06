package com.leslie.realm.entity.mob;

import com.leslie.realm.input.Keyboard;

public class Player extends Mob{

    private Keyboard input;

    /* CONSTRUCTORS */
    public Player(Keyboard input){
        this.input = input;
    }

    /* created at a specific location */
    public Player(int x, int y, Keyboard input){
        this.x = x;
        this.y = y;
        this.input = input;
    }

    /* Change the inputs of the player*/
    @Override
    public void update(){
        if(input.up) y--;
        if(input.down) y++;
        if(input.left) x--;
        if(input.right) x++;
    }

    @Override
    public void render(){}
}
