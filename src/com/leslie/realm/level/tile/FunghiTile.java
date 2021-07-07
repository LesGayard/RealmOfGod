package com.leslie.realm.level.tile;

import com.leslie.realm.graphics.Screen;
import com.leslie.realm.graphics.Sprite;

public class FunghiTile extends Tile {

    public FunghiTile(Sprite sprite) {
        super(sprite);
    }

    /*Redondant code for safe !!*/
    @Override
    public boolean solid(){
        return false;
    }

    @Override
    public void render (int x, int y, Screen screen){
        screen.renderTile(x << 6  ,y << 6   ,this);
    }
}
