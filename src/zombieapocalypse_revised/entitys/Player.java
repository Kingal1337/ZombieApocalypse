/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.entitys;

import javax.swing.ImageIcon;
import zombieapocalypse_revised.entitys.accessories.WeaponSack;
import zombieapocalypse_revised.entitys.skins.CustomSkinSize;

/**
 *
 * @author Alan Tsui
 */
public class Player extends Wielder{

    public Player(String name, int x, int y, boolean passable, double health, double maxHealth, double armor, ImageIcon icon, int speed, boolean effectedByGravity, double angle, double size, double damageMultiplyer, WeaponSack weaponSack) {
        super(name, x, y, passable, health, maxHealth, armor, icon, speed, effectedByGravity, angle, size, damageMultiplyer, weaponSack);
    }

    public Player(String name, int x, int y, boolean passable, double health, double maxHealth, double armor, ImageIcon icon, int speed, boolean effectedByGravity, double angle, double size, double damageMultiplyer, WeaponSack weaponSack, CustomSkinSize skinSize) {
        super(name, x, y, passable, health, maxHealth, armor, icon, speed, effectedByGravity, angle, size, damageMultiplyer, weaponSack, skinSize);
    }
    
    public Player(Player player){
        super(player);
    }
    
    @Override
    public Entity copy(){
        return new Player(this);
    }

}
