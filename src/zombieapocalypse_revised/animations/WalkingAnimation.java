/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.animations;

import java.awt.Graphics2D;
import java.awt.Point;
import zombieapocalypse_revised.limbs.Limb;

/**
 *
 * @author Alan Tsui
 */
public class WalkingAnimation extends AbstractAnimation{
    private int from;
    private int to;
    private int interval;
    private int current;
    
    public WalkingAnimation(){
        super();
        from = -45;
        to = 45;
        current = from;
    }
    
    public WalkingAnimation(WalkingAnimation animation){
        super(animation);
        this.from = animation.from;
        this.to = animation.to;
        this.interval = animation.interval;
        this.current = animation.current;
    }
    
    @Override
    public AbstractAnimation copy(){
        return new WalkingAnimation(this);
    }
    
    @Override
    public void update(boolean invert, int speed){
        interval = Math.abs(interval) != Math.abs(speed) ? speed : interval;
        current += interval;
        if(current > to || current < from){
            interval = -interval;
        }
    }
    
    @Override
    public void render(Graphics2D gd, Limb limb, boolean invert) {
        double angle = current;
        if (current >= 0){
            angle = Math.PI - current;
        }
        else{
            angle = -Math.PI - current;
        }
//        gd.fillRect(limb.getPivot().x, limb.getPivot().y,1,1);
        gd.rotate(Math.toRadians(invert ? angle : current),limb.getPivot().getX(), limb.getPivot().getY());
    }
}
