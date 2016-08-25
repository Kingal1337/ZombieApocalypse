/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.weapons;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import zombieapocalypse_revised.entitys.Entity;
import zombieapocalypse_revised.entitys.HumanLookingEntity;
import zombieapocalypse_revised.entitys.Wielder;
import zombieapocalypse_revised.limbs.Limb;

/**
 *
 * @author Alan Tsui
 */
public abstract class Weapon {
    public static final Weapon FIST = new MeleeWeapon("Fists", 5, null, 15, 50, null, 0, false);
    public static final Weapon MACHETE = new MeleeWeapon("Machete", 15, new ImageIcon(Weapon.class.getResource("/zombieapocalypse_revised/config/resources/weapon_skins/melee_weapons/Machete.png")), 15, 100, null, 250, false);
    public static final Weapon AK47 = new ShootableWeapon("AK-47", 5, new ImageIcon(Weapon.class.getResource("/zombieapocalypse_revised/config/resources/weapon_skins/shootable_weapons/AK47.png")), 100, 100, 500, 500, 250, 1, true, 40, .25, new Bullet(0, 0, 15, 5, true, 100, 100, 100, null, 5, false, 2, 0, 10, null));
    
    private String name;
    private int damage;
    private ImageIcon image;
    private Dimension2D resizeDimension; 
    public Weapon(String name, int damage, ImageIcon image){
        this.name = name;
        this.damage = damage;
        this.image = image;
        if(image != null){
            resizeDimension = new Dimension(image.getIconWidth()*1, image.getIconHeight()*1);
        }
    }
    
    public Weapon(Weapon weapon){
        this.name = weapon.name;
        this.damage = weapon.damage;
        this.image = weapon.image;
        if(weapon.resizeDimension != null){
            resizeDimension = new Dimension();
            resizeDimension.setSize(weapon.resizeDimension.getWidth(), weapon.resizeDimension.getHeight());
        }
    }

    public void resize(double widthToResizeBy, double heightToResizeBy, Dimension dimension) {
        if(resizeDimension != null){
            resizeDimension.setSize(resizeDimension.getWidth()*widthToResizeBy, resizeDimension.getHeight()*heightToResizeBy);
        }
    }
    
    public abstract Weapon copy();
    
    public abstract void update(ArrayList<Entity> entitys, Wielder wielder, int tickSpeed);
    
    public abstract void render(Graphics2D gd, Limb limb, Wielder wielder);
    
    public abstract void hit(ArrayList<Entity> entitys, Wielder entity, int tickSpeed);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public Dimension2D getResizeDimension() {
        return resizeDimension;
    }
    
}
