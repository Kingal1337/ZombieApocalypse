/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.viewer.start_menu;

import java.awt.Dimension;
import java.util.ArrayList;
import zombieapocalypse_revised.APanel;
import zombieapocalypse_revised.MainPanel;
import zombieapocalypse_revised.config.Config;
import zombieapocalypse_revised.entitys.Enemy;
import zombieapocalypse_revised.entitys.Entity;
import zombieapocalypse_revised.entitys.Player;
import zombieapocalypse_revised.entitys.Wall;
import zombieapocalypse_revised.entitys.accessories.WeaponSack;
import zombieapocalypse_revised.entitys.skins.BearieJunior;
import zombieapocalypse_revised.entitys.skins.Skin;
import zombieapocalypse_revised.viewer.MainFrame;
import zombieapocalypse_revised.viewer.huds.DefaultHud;
import zombieapocalypse_revised.weapons.ShootableWeapon;
import zombieapocalypse_revised.weapons.Weapon;

/**
 *
 * @author Alan Tsui
 */
public class AllFrames {
    public static MainFrame frame = new MainFrame();
    public static MainPanel panel;
    public static StartMenu menu = new StartMenu();
    public static Options options = new Options();
    
    private AllFrames(){}
    
    public static void createMainPanel(Dimension size){
        ArrayList<Weapon> weapons = new ArrayList<>();
        weapons.add(Weapon.MACHETE.copy());
        weapons.add(Weapon.AK47.copy());
        weapons.add(Weapon.REVOLVER.copy());
//        Player player = new Player(300, 150, false, 100, 100, 1, null, 12, true, 0, 1, new WeaponSack(weapons));
        BearieJunior player = new BearieJunior("Bearie Junior", 300, 150, false, 100, 100, 1, null, 12, true, 0, 1, 1, new WeaponSack(weapons));
        player.setEffectedByGravity(true);
//        player.getFrontArm().setIdleAngle(-90);

//        player.getFrontArm().setIdleAngle(-90);
//        Player player = new TestModel(300, 150, false, 100, 100, 1, null, 12, true, 0, new WeaponSack(weapons));
        ArrayList<Entity> entitys = new ArrayList<>();
        Enemy player2 = new Enemy("Player", 450, 150, false, 100, 100, 0, null, 12, true, 0, 2, 1, new WeaponSack());
        player2.setAngle(Math.toRadians(180));
        player2.getWeaponSack().getWeapons().add(Weapon.REVOLVER.copy());
        player2.getWeaponSack().changeToNextWeapon();
        ((ShootableWeapon)(player2.getWeaponSack().getCurrentWeapon())).setInfiniteAmmo(true);
//        entitys.add(new Wall(0, 0, 1000, 50, false, 100, 100, 100, null));
//        entitys.add(new Wall(0, 0, 50, 100, false, 100, 100, 100, null));
//        entitys.add(new Wall(1000, 0, 50, 1000, false, 100, 100, 100, null));
        entitys.add(player);
        entitys.add(player2);
//        entitys.add(new Wall(0, 200, 640, 17, false, 100, 100, 100, null));
        entitys.add(new Wall("Wall", 0, 800, 10000, 50, false, 100, 100, 100, null));
        
//        Skin.BEARIE_JUNIOR.applySkin(player);

//        Skin.CARL.applySkin(player);

        Skin.GREG.applySkin(player2);
        
        
        panel = new MainPanel(player, new DefaultHud(), Config.getDefaultSettings(), entitys, size);
    }
}
