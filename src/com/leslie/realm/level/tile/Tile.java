package com.leslie.realm.level.tile;

import com.leslie.realm.graphics.Screen;
import com.leslie.realm.graphics.Sprite;

/* Each tile should have its own position, its own sprite*/

/*Make it abstract ???*/
public class Tile {

    /*Find its own position*/
    public int x;
    public int y;

    /*attach a sprite to it */
    public Sprite sprite;

    public static Tile tree = new TreeTile(Sprite.trees);
    public static Tile funghi = new FunghiTile(Sprite.funghi);
    public static Tile water = new WaterTile(Sprite.water);
    public static Tile light = new LightTile(Sprite.light);

    public static Tile voidTile = new VoidTile(Sprite.voidSprite);

    /*CONSTRUCTOR*/
    public Tile(Sprite sprite){
        this.sprite = sprite;
    }

    /* what information do i need to render the tile */
    public void render (int x, int y, Screen screen){

    }


    /*Collision with it or not ?*/
    public boolean solid(){
        return false;
    }


}
