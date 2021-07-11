package com.leslie.realm.graphics;

public class Sprite {

    public  int  size  = 146; //may be 16 or 32 for monsters
    private int x,y;
    public int[] pixels;
    private SpriteSheet sheet;



    //THE TREE TEXTURE -> UNIQUE
    public static Sprite trees = new Sprite(64, 0, 0, SpriteSheet.tiles);
    public static Sprite funghi = new Sprite(64, 1, 0, SpriteSheet.tiles);
    public static Sprite water = new Sprite(64, 2, 0, SpriteSheet.tiles);
    public static Sprite light = new Sprite(64, 3, 0, SpriteSheet.light);

    public static Sprite voidSprite = new Sprite(64, 0x1B87E0);
    /* The player !! to recreate !!*/
    public static Sprite playerFront = new Sprite(16,0,0,SpriteSheet.playerFront);
    public static Sprite playerBack = new Sprite(16,0,0,SpriteSheet.playerBack);
    public static Sprite playerLeft = new Sprite(16,0,0,SpriteSheet.playerLeft);
    public static Sprite playerRight = new Sprite(16,0,0,SpriteSheet.playerRight);
    /* walking*/
    public static Sprite playerFront01 = new Sprite(16,0,0,SpriteSheet.playerFront01);
    public static Sprite playerFront02 = new Sprite(16,0,0,SpriteSheet.playerFront02);
    public static Sprite playerBack01 = new Sprite(16,0,0,SpriteSheet.playerBack01);
    public static Sprite playerBack02 = new Sprite(16,0,0,SpriteSheet.playerBack02);
    public static Sprite playerRight01 = new Sprite(16,0,0,SpriteSheet.playerRight01);
    public static Sprite playerRight02 = new Sprite(16,0,0,SpriteSheet.playerRight02);
    public static Sprite playerLeft01 = new Sprite(16,0,0,SpriteSheet.playerLeft01);
    public static Sprite playerLeft02 = new Sprite(16,0,0,SpriteSheet.playerLeft02);




    /*Constructor*/
    public Sprite( int size, int x, int y, SpriteSheet sheet){
        this.size = size;
        pixels = new int[size * size];
        this.x = x * size;
        this.y = y * size;
        this.sheet = sheet;

        load();

    }

    /*CONSTRUCTOR THAT LOAD WITH COLORS for the void tile -> the void sprite*/
    public Sprite(int size, int colour){
        this.size = size;
        pixels = new int[size * size];
        setColour(colour);
    }

    private void setColour(int colour){
        for(int i=0; i< size * size ; i++){
            pixels[i] = colour;
        }
    }

    /*GETTERS + SETTERS*/
    public int getSIZE(){
        return this.size;
    }

    /*LOAD METHOD*/
    private void load(){
        //access the spritesheet pixels and find the right sprite
        /*FOR NESTED LOOPS...*/
        for(int y=0; y<size; y++){
            for(x=0; x<size; x++){
                pixels[x+y * size] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.size];
            }
        }
    }
}
