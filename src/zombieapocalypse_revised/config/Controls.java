/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.config;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author Alan Tsui
 */
public class Controls {
    public static final int DEFAULT_UP = KeyEvent.VK_W;
    public static final int DEFAULT_DOWN = KeyEvent.VK_S;
    public static final int DEFAULT_LEFT = KeyEvent.VK_A;
    public static final int DEFAULT_RIGHT = KeyEvent.VK_D;
    public static final int DEFAULT_JUMP = KeyEvent.VK_SPACE;
    
    public static final int DEFAULT_SHOOT = MouseEvent.BUTTON1;
    public static final int RELOAD = KeyEvent.VK_R;
    
    public static final int PAUSE = KeyEvent.VK_ESCAPE;
    
    public static final int CHANGE_WEAPONS = KeyEvent.VK_Q;
    
    public int up;
    public int down;
    public int left;
    public int right;
    public int jump;
    
    public int shoot;
    public int reload;
    
    public int pause;
    
    public int changeWeapons;

    public Controls(){
        reset();
    }
    
    public Controls(int up, int down, int left, int right, int jump, int shoot, int reload, int pause, int changeWeapons) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.jump = jump;
        
        this.shoot = shoot;
        this.reload = reload;
        
        this.pause = pause;
        
        this.changeWeapons = changeWeapons;
    }
    
    public Controls(Controls controls){
        this.up = controls.up;
        this.down = controls.down;
        this.left = controls.left;
        this.right = controls.right;
        this.jump = controls.jump;
        
        this.shoot = controls.shoot;
        this.reload = controls.reload;
        
        this.pause = controls.pause;
        
        this.changeWeapons = controls.changeWeapons;
    }
    
    public Controls copy(){
        return new Controls(this);
    }
    
    public void reset(){
        up = DEFAULT_UP;
        down = DEFAULT_DOWN;
        left = DEFAULT_LEFT;
        right = DEFAULT_RIGHT;
        jump = DEFAULT_JUMP;
        
        shoot = DEFAULT_SHOOT;
        reload = RELOAD;
        
        pause = PAUSE;
        
        changeWeapons = CHANGE_WEAPONS;
    }
    
    public static Controls defaultControls(){
        return new Controls();
    }
    
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder
                .append("[")
                .append("Controls:")
                .append("UP").append("-").append(up)
                .append("DOWN").append("-").append(down)
                .append("LEFT").append("-").append(left)
                .append("RIGHT").append("-").append(right)
                .append("JUMP").append("-").append(jump)
                .append("SHOOT").append("-").append(shoot)
                .append("RELOAD").append("-").append(reload)
                .append("PAUSE").append("-").append(pause)
                .append("CHANGE_WEAPONS").append("-").append(changeWeapons)
                .append(";")
                .append("]");
        return builder.toString();
    }
    
}
