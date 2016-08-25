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

    public Player(int x, int y, boolean passable, double health, double maxHealth, double armor, ImageIcon icon, int speed, boolean effectedByGravity, double angle, double size, WeaponSack weaponSack) {
        super(x, y, passable, health, maxHealth, armor, icon, speed, effectedByGravity, angle, size, weaponSack);
    }

    public Player(int x, int y, boolean passable, double health, double maxHealth, double armor, ImageIcon icon, int speed, boolean effectedByGravity, double angle, double size, WeaponSack weaponSack, CustomSkinSize skinSize) {
        super(x, y, passable, health, maxHealth, armor, icon, speed, effectedByGravity, angle, size, weaponSack, skinSize);
    }
    
    public Player(Player player){
        super(player);
    }
    
    @Override
    public Entity copy(){
        return new Player(this);
    }

}
