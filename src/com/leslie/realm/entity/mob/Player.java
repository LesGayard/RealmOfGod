package com.leslie.realm.entity.mob;

import com.leslie.realm.graphics.Screen;
import com.leslie.realm.graphics.Sprite;
import com.leslie.realm.input.Keyboard;

public class Player extends Mob{

    private Keyboard input;
    /* Create a sprite for the player animation */
    private Sprite sprite;

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
        int xMove = 0;
        int yMove = 0;
        if(input.up) yMove--;
        if(input.down) yMove++;
        if(input.left) xMove--;
        if(input.right) xMove++;
        if(xMove != 0 || yMove != 0) move(xMove,yMove);

    }

    @Override
    public void render(Screen screen){
        if(direction == 1) this.sprite = Sprite.playerRight; // East
        if(direction == 3) this.sprite = Sprite.playerLeft; // West
        if(direction == 2) this.sprite = Sprite.playerBack; //South
        if(direction == 0) this.sprite = Sprite.playerFront;

        screen.renderPlayer(x,y, sprite);

    }
}
