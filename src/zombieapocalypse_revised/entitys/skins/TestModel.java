/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.entitys.skins;

import javax.swing.ImageIcon;
import zombieapocalypse_revised.entitys.Player;
import zombieapocalypse_revised.entitys.accessories.WeaponSack;

/**
 *
 * @author Alan Tsui
 */
public class TestModel extends Player{

    public TestModel(String name, int x, int y, boolean passable, double health, double maxHealth, double armor, ImageIcon icon, int speed, boolean effectedByGravity, double angle, double size, double damageMultiplyer, WeaponSack weaponSack) {
        super(name, x, y, passable, health, maxHealth, armor, icon, speed, effectedByGravity, angle, size, damageMultiplyer, weaponSack, new CustomSkinSize(DEFAULT_HEAD_SIZE, DEFAULT_ARM_SIZE, DEFAULT_LEG_SIZE, DEFAULT_BODY_SIZE, DEFAULT_HEAD_POSITION, DEFAULT_HEAD_PIVOT_POSITION, DEFAULT_ARM_PIVOT_POSITION, DEFAULT_ARM_POSITION, DEFAULT_LEG_PIVOT_POSITION, DEFAULT_LEG_POSITION));
    }

}
