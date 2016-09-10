/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.entitys;

import javax.swing.ImageIcon;

/**
 *
 * @author Alan Tsui
 */
public class NonMovingEntity extends DamagableEntity{

    public NonMovingEntity(String name, int x, int y, int width, int height, boolean passable, double health, double maxHealth, double armor, ImageIcon icon) {
        super(name, x, y, width, height, passable, health, maxHealth, armor, icon);
    }
    
    public NonMovingEntity(NonMovingEntity entity){
        super(entity);
    }
    
    @Override
    public Entity copy(){
        return new NonMovingEntity(this);
    }
    
}
