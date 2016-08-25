/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.animations;

/**
 *
 * @author Alan Tsui
 */
public abstract class AbstractAnimation implements Animation{
    private boolean animationOver;
    
    public AbstractAnimation(){
        animationOver = true;
    }
    
    public AbstractAnimation(AbstractAnimation animation){
        this.animationOver = animation.animationOver;
    }
    
    public abstract AbstractAnimation copy();
    
    public boolean isAnimationOver() {
        return animationOver;
    }

    public void setAnimationOver(boolean animationOver) {
        this.animationOver = animationOver;
    }
    
}
