/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.entitys;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import zombieapocalypse_revised.entitys.accessories.WeaponSack;
import zombieapocalypse_revised.entitys.skins.CustomSkinSize;
import zombieapocalypse_revised.weapons.ShootableWeapon;
import zombieapocalypse_revised.weapons.Weapon;

/**
 *
 * @author Alan Tsui
 */
public class Wielder extends HumanLookingEntity{
    private WeaponSack weaponSack;
    private boolean reloading;
    
    public Wielder(int x, int y, boolean passable, double health, double maxHealth, double armor, ImageIcon icon, int speed, boolean effectedByGravity, double angle, double size, WeaponSack weaponSack) {
        super(x, y, passable, health, maxHealth, armor, icon, speed, effectedByGravity, angle, size);
        this.weaponSack = weaponSack;
        reloading = false;
    }

    public Wielder(int x, int y, boolean passable, double health, double maxHealth, double armor, ImageIcon icon, int speed, boolean effectedByGravity, double angle, double size, WeaponSack weaponSack, CustomSkinSize skinSize) {
        super(x, y, passable, health, maxHealth, armor, icon, speed, effectedByGravity, angle, size, skinSize);
        this.weaponSack = weaponSack;
        this.reloading = false;
    }
    
    public Wielder(Wielder wielder){
        super(wielder);
        this.weaponSack = wielder.weaponSack.copy();
        this.reloading = wielder.reloading;
    }
    
    @Override
    public Entity copy(){
        return new Wielder(this);
    }

    @Override
    public void update(ArrayList<Entity> entitys, int tickSpeed) {
        super.update(entitys, tickSpeed);
        weaponSack.getCurrentWeapon().update(entitys, this, tickSpeed);
    }

    @Override
    public void resize(double widthToResizeBy, double heightToResizeBy, Dimension dimension) {
        super.resize(widthToResizeBy, heightToResizeBy, dimension);
        for(int i=0;i<weaponSack.getWeapons().size();i++){
            weaponSack.getWeapons().get(i).resize(widthToResizeBy, heightToResizeBy, dimension);
        }
    }

    @Override
    public void render(Graphics2D gd) {
        if(!isMoving()){
            super.render(gd);
        }
        if(!isMoving()){
            weaponSack.getCurrentWeapon().render(gd, getFrontArm(), this);
            if(weaponSack.getCurrentWeapon() instanceof ShootableWeapon){
                setRenderFrontArm(false);
            }
        }
        if(isMoving()){
            if(weaponSack.getCurrentWeapon() instanceof ShootableWeapon){
                setRenderFrontArm(true);
            }
            super.render(gd);
        }
    }
    
    public void hit(ArrayList<Entity> entitys, int tickSpeed){
        weaponSack.getCurrentWeapon().hit(entitys, this, tickSpeed);
    }
    
    public void reload(){
        if(weaponSack.getCurrentWeapon() instanceof ShootableWeapon){
            ShootableWeapon gun = (ShootableWeapon)(weaponSack.getCurrentWeapon());
            gun.reload();
        }
    }

    public WeaponSack getWeaponSack() {
        return weaponSack;
    }

    public void setWeaponSack(WeaponSack weaponSack) {
        this.weaponSack = weaponSack;
    }

    public boolean isReloading() {
        return reloading;
    }

    public void setReloading(boolean reloading) {
        this.reloading = reloading;
    }
}
