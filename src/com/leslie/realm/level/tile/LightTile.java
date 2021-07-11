package com.leslie.realm.level.tile;

import com.leslie.realm.graphics.Screen;
import com.leslie.realm.graphics.Sprite;

public class LightTile extends Tile {
    public LightTile(Sprite sprite) {
        super(sprite);
    }

    /*Redondant code for safe !!*/
    @Override
    public boolean solid(){
        return false;
    }

    @Override
    public void render (int x, int y, Screen screen){
        screen.renderTile(x << 4  ,y << 4  ,this);
    }
}
