/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.animations;

import java.awt.Graphics2D;
import zombieapocalypse_revised.limbs.Limb;

/**
 *
 * @author Alan Tsui
 */
public class SlashAnimation extends AbstractAnimation{
    private int from;
    private int to;
    private int interval;
    private int current;
    private int counter;
    
    public SlashAnimation(){
        super();
        from = 150;
        to = 360;
        current = from;
    }
    
    public SlashAnimation(SlashAnimation animation){
        super(animation);
        this.from = animation.from;
        this.to = animation.to;
        this.interval = animation.interval;
        this.current = animation.current;
        this.counter = animation.counter;
    }
    
    @Override
    public AbstractAnimation copy(){
        return new SlashAnimation(this);
    }
    
    @Override
    public void update(boolean invert, int speed){
        interval = Math.abs(interval) != Math.abs(speed) ? speed : interval;
        current += interval;
        if(current > to || current < from){
            interval = -interval;
            counter++;
        }
        if(counter >= 2){
            counter = 0;
            setAnimationOver(true);
        }
    }
    
    @Override
    public void render(Graphics2D gd, Limb limb, boolean invert) {
        gd.rotate(Math.toRadians(invert ? -current : current),limb.getPivot().getX(), limb.getPivot().getY());
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }
    
    
}
