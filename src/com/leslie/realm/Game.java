package com.leslie.realm;

import com.leslie.realm.graphics.Screen;
import com.leslie.realm.input.Keyboard;
import com.leslie.realm.level.Level;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements Runnable {

    //screen resolution = retro style !!
    public static int width = 300;
    public static int height = width / 16 * 9 ;
    public static int scale = 4;

    //title change
    public static String title = "The Realm of God";
    //thread
    private Thread thread;
    //Game loop
    private boolean running = false;
    //the window
    private JFrame frame;

    //the Screen
    private Screen screen;

    /* The character should be at one level at a time*/
    private Level level;

    //the image
    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    //Keyboard event
    private Keyboard keyboard;
    //converting the image in an array of integers !
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();


    //Constructor
    public Game(){
        //The window !!
        Dimension size = new Dimension (width * scale, height * scale);
        setPreferredSize(size);

        frame = new JFrame();
        screen = new Screen(width, height);
        level = new Level(1024,1024);
        keyboard = new Keyboard();
        frame.addKeyListener(keyboard);

    }

    //THREADS METHODS
    public synchronized void start(){
        //attached to this Game object
        running = true;
        thread = new Thread(this,"Display");
        thread.start();
    }

    public synchronized void stop(){
        running = false;
        try{
            thread.join(); 
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
    }

    /*MOVE THE TILES */
    int xOffset = 0, yOffset = 0;

    public void update(){
        keyboard.update();
        /*Moving the Map/tiles with the keyboard*/
        if(keyboard.up) yOffset--;
        if(keyboard.down) yOffset++;
        if(keyboard.left) xOffset--;
        if(keyboard.right) xOffset++;
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(4);
            return;
        }
        screen.clear();
       //screen.render(xOffset,yOffset);
        level.render(xOffset,yOffset,screen);

        for(int i=0; i<pixels.length; i++){
            pixels[i] = screen.pixels[i];
        }

        //the graphic context
        Graphics g = bs.getDrawGraphics();

        /*g.setColor(Color.BLACK);
        g.fillRect(0,0, getWidth(),getHeight());*/
        g.drawImage(image,0,0,getWidth(),getHeight(),null);
        g.dispose();
        bs.show();
    }

    //GAME LOOP RUNNABLE
    @Override
    public void run(){
        // FOR THE TIMER !!
        long lastTime = System.nanoTime(); // BETTER THAN CURRENT TIME, MORE PRECISE
        long timer = System.currentTimeMillis();

        //convert the nanoseconds into milliseconds
        final double nanoseconds = 1000000000.0 / 60.0;
        double delta = 0;
        int frames = 0;
        int updates = 0;

        //requestFocus();

        while(running){
            //System.out.println("Running....");
            long now = System.nanoTime();
            delta += (now - lastTime) / nanoseconds;
            lastTime = now;
            while(delta >= 1 ){
                update();
                updates++;
                delta--;
            }
            //update();
            frames++;
            render();
            if(System.currentTimeMillis() - timer > 1000){
               timer += 1000;
               System.out.println(updates + " ups, " + frames + " fps ");
               frame.setTitle(title + "  | " + updates + " ups, " + frames + " fps " );
               updates = 0;
               frames = 0;
            }
        }
    }

    //The Main Method Maybe in another class !!!!
    public static void main (String[] args){
        Game game = new Game();
        game.frame.setResizable(false);
        game.frame.setTitle(title);
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);


        game.start();
    }
}
