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
public class Wall extends NonMovingEntity{

    public Wall(String name, int x, int y, int width, int height, boolean passable, double health, double maxHealth, double armor, ImageIcon icon) {
        super(name, x, y, width, height, passable, health, maxHealth, armor, icon);
        setDamagable(false);
    }
    public Wall(Wall wall) {
        super(wall);
    }
    
    @Override
    public Entity copy(){
        return new Wall(this);
    }

}
