package com.leslie.realm.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    // 2 states pressed or released
    private final boolean [] keys = new boolean [120];
    public boolean up,down,left,right;


    //@Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;

    }

    //@Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }


    /*Check if a key is pressed or released*/
    public void update(){
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];

        System.out.println(up);
        for(int i=0; i<keys.length; i++){
            if(keys[i]){
                System.out.println("key ID pressed : " + i);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }



}
