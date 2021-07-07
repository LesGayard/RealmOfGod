package com.leslie.realm.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class SpriteSheet {

    private String path;
    public   int size;
    public int[] pixels;

    public static SpriteSheet tiles = new SpriteSheet("resources/textures/FinalRealmOfGodTexture.png",2048);
    /* Recréer un perso !!*/
    public static SpriteSheet player = new SpriteSheet("resources/player/playerfront.png", 64);

    //CONSTRUCTOR
    public SpriteSheet(String path, int size){
        this.path = path;
        this.size = size;
        pixels = new int [size * size];
        load(path);
    }

    //LOADING THE SPRIDESHEET
    private void load(String path){
        try {
            //BufferedImage image = ImageIO.read(Objects.requireNonNull(SpriteSheet.class.getResource(path)));
            BufferedImage image = ImageIO.read( new File(path) );

            int w = image.getWidth();
            int h = image.getHeight();

            //Image to pixels conversion
            image.getRGB(0,0,w,h,pixels,0,w);

        }catch(IOException ioException){
            ioException.printStackTrace();
        }
    }


}
