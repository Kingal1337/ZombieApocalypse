/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.viewer.huds;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import zombieapocalypse_revised.entitys.Wielder;
import zombieapocalypse_revised.entitys.accessories.WeaponSack;
import zombieapocalypse_revised.weapons.Weapon;

/**
 *
 * @author Alan Tsui
 */
public abstract class Hud {
    public Hud(){
        
    }
    
    public abstract void resize(double widthToResizeBy, double heightToResizeBy, Dimension dimension);
    
    public abstract void drawFPS(Graphics2D gd, double fps, double fpsSetAt, Dimension screenSize);
    
    public abstract void drawHealth(Graphics2D gd, Wielder wielder, Dimension screenSize);
    
    public abstract void drawAmmo(Graphics2D gd, Weapon currentWeapon, Dimension screenSize);
    
    public abstract void drawWeapons(Graphics2D gd, WeaponSack sack, Dimension screenSize);
}
