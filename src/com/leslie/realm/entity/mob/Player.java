package com.leslie.realm.entity.mob;

import com.leslie.realm.graphics.Screen;
import com.leslie.realm.graphics.Sprite;
import com.leslie.realm.input.Keyboard;

public class Player extends Mob{

    private Keyboard input;
    /* Create a sprite for the player animation */
    private Sprite sprite;
    private int animate;
    private boolean walking;

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
        if (animate < 8500) animate ++;
        else animate = 0;
        int xMove = 0;
        int yMove = 0;
        if(input.up) yMove--;
        if(input.down) yMove++;
        if(input.left) xMove--;
        if(input.right) xMove++;
        if(xMove != 0 || yMove != 0) {
            move(xMove,yMove);
            this.walking = true;
        }else{
            this.walking = false;
        }

    }

    @Override
    public void render(Screen screen){
        int flip = 0;
        if(direction == 1) {
            this.sprite = Sprite.playerRight; // East
            if(walking){
                if(animate %20 > 10){
                    this.sprite = Sprite.playerRight01;
                }else{
                    this.sprite = Sprite.playerRight02;
                }
            }
        }
        if(direction == 3) {
            this.sprite = Sprite.playerLeft; // West
            if(walking){
                if(animate %20 > 10){
                    this.sprite = Sprite.playerLeft01;
                }else{
                    this.sprite = Sprite.playerLeft02;
                }
            }
        }
        if(direction == 2) {
            this.sprite = Sprite.playerBack; //South
            if(walking){
                if(animate %20 > 10){
                    this.sprite = Sprite.playerBack01;
                }else{
                    this.sprite = Sprite.playerBack02;
                }
            }
        }
        if(direction == 0) {
            this.sprite = Sprite.playerFront;
            if(walking){
                if(animate %20 > 10){
                    this.sprite = Sprite.playerFront01;
                }else{
                    this.sprite = Sprite.playerFront02;
                }
            }
        }


        screen.renderPlayer(x,y, sprite,flip);

    }
}
