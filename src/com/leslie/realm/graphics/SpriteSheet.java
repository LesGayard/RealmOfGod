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

    public static SpriteSheet tiles = new SpriteSheet("resources/textures/finalTree.png",2048);
    public static SpriteSheet light = new SpriteSheet("resources/textures/light.png",2048);

    /* Recréer un perso !!*/
    public static SpriteSheet playerFront = new SpriteSheet("resources/player/finalFront.png", 64);
    public static SpriteSheet playerBack = new SpriteSheet("resources/player/finalBack.png", 64);
    public static SpriteSheet playerLeft = new SpriteSheet("resources/player/playerleft.png", 64);
    public static SpriteSheet playerRight = new SpriteSheet("resources/player/finalRight.png", 64);
    /* walking*/
    public static SpriteSheet playerFront01 = new SpriteSheet("resources/player/front01.png",64);
    public static SpriteSheet playerFront02 = new SpriteSheet("resources/player/front02.png",64);

    public static SpriteSheet playerBack01 = new SpriteSheet("resources/player/back01.png", 64);
    public static SpriteSheet playerBack02 = new SpriteSheet("resources/player/back02.png", 64);

    public static SpriteSheet playerRight01 = new SpriteSheet("resources/player/right01.png", 64);
    public static SpriteSheet playerRight02 = new SpriteSheet("resources/player/right02.png", 64);

    public static SpriteSheet playerLeft01 = new SpriteSheet("resources/player/left01.png", 64);
    public static SpriteSheet playerLeft02 = new SpriteSheet("resources/player/left02.png", 64);

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
