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
    public static final Weapon FISTS = new MeleeWeapon("Fists", 2, null, 15, 50, null, 0, false);
    public static final Weapon MACHETE = new MeleeWeapon("Machete", 15, new ImageIcon(Weapon.class.getResource("/zombieapocalypse_revised/config/resources/weapon_skins/melee_weapons/Machete.png")), 15, 100, null, 250, false);
    
    public static final Weapon AK47 = new ShootableWeapon("AK-47", 5, new ImageIcon(Weapon.class.getResource("/zombieapocalypse_revised/config/resources/weapon_skins/shootable_weapons/AK47.png")), 100, 100, 500, 500, 125, 250, true, 40, .25, new Bullet("Bullet", 0, 0, 20, 5, true, 1, 1, 1, null, 5, false, 2, 0, 7, null));
    public static final Weapon REVOLVER = new ShootableWeapon("Revolver", 25, new ImageIcon(Weapon.class.getResource("/zombieapocalypse_revised/config/resources/weapon_skins/shootable_weapons/Revolver.png")), 6, 6, 128, 128, 500, 1000, true, 10, .55, new Bullet("Bullet", 0, 0, 15, 3, true, 1, 1, 1, null, 5, false, 10, 0, 5, null));
    
    private String name;
    private int damage;
    private ImageIcon image;
    private double width;
    private double height;
    private boolean ammo;
    public Weapon(String name, int damage, ImageIcon image){
        this.name = name;
        this.damage = damage;
        this.image = image;
        if(image != null){
            width = image.getIconWidth();
            height = image.getIconHeight();
        }
    }
    
    public Weapon(Weapon weapon){
        this.name = weapon.name;
        this.damage = weapon.damage;
        this.image = weapon.image;
        width = weapon.width;
        height = weapon.height;
        
    }

    public void resize(double widthToResizeBy, double heightToResizeBy, Dimension dimension) {
        width = width*widthToResizeBy;
        height = height*heightToResizeBy;
    }
    
    public abstract Weapon copy();
    
    public abstract void update(ArrayList<Entity> entitys, Wielder wielder, int tickSpeed);
    
    public abstract void render(Graphics2D gd, Limb limb, Wielder wielder);
    
    public abstract void hit(ArrayList<Entity> entitys, Wielder entity, int tickSpeed, double damageMultiplyer);

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

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
    
}
