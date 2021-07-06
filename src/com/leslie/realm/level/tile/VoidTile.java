package com.leslie.realm.level.tile;

import com.leslie.realm.graphics.Screen;
import com.leslie.realm.graphics.Sprite;

public class VoidTile extends Tile {

    public VoidTile(Sprite voidSprite) {
        super(voidSprite);
    }

    @Override
    public void render (int x, int y, Screen screen){
        screen.renderTile(x << 4 ,y << 4 ,this);
    }
}
