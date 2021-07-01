package com.leslie.realm.graphics;

public class Screen {
    private int width;
    private int height;
    public int[] pixels;

    /*Animation*/
    int xtime = 0;
    int ytime = 0;
    int counter = 0;

    //constructor
    public Screen(int width, int height){
        this.width = width;
        this.height = height;
        pixels = new int [width * height];
    }

    /*Display Image*/
    public void render() {
        counter++;
        if(counter % 100 == 0) xtime++;
        if(counter % 80 == 0) ytime++;

        for(int y=0; y<this.height ; y++){
            //ArrayBoundException
            if(ytime <0 | ytime >= height) break;

            for(int x=0; x<this.width ; x++){
                if(xtime <0 | xtime > width) break;
                pixels[xtime + ytime * width] = 0xFF00FF;
                //throw new ArrayIndexOutOfBoundsException();
            }
        }
    }

    /*Clear Image*/
    public void clear(){
        for(int i=0; i<pixels.length; i++){
            pixels[i] = 0;

        }
    }
}
