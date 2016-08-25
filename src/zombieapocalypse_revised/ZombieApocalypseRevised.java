/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombieapocalypse_revised;

import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.shape.Shape;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import zombieapocalypse_revised.config.Config;
import zombieapocalypse_revised.config.Controls;
import zombieapocalypse_revised.entitys.Entity;
import zombieapocalypse_revised.entitys.Player;
import zombieapocalypse_revised.entitys.Wall;
import zombieapocalypse_revised.entitys.accessories.WeaponSack;
import zombieapocalypse_revised.entitys.skins.BearieJunior;
import zombieapocalypse_revised.entitys.skins.Skin;
import zombieapocalypse_revised.entitys.skins.TestModel;
import zombieapocalypse_revised.viewer.MainFrame;
import zombieapocalypse_revised.weapons.Bullet;
import zombieapocalypse_revised.weapons.Weapon;

/**
 *
 * @author Alan Tsui
 */
public class ZombieApocalypseRevised {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        System.out.println(Math.toRadians(-90));
//        System.out.println(Math.PI/-2.0);
        preStart();
//        AnimationTest.main(args);
//        MainFrame frame = new MainFrame();
//        LightingTest panel = new LightingTest();
//        
//        frame.changePanel(panel);
//        
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(true);
//        frame.setPreferredSize(new Dimension(500, 500));
//
//
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//
//        frame.setVisible(true);
    }
    
    public static void preStart(){
        ArrayList<Weapon> weapons = new ArrayList<>();
        weapons.add(Weapon.MACHETE);
        weapons.add(Weapon.AK47);
//        Player player = new Player(300, 150, false, 100, 100, 1, null, 12, true, 0, 1, new WeaponSack(weapons));
        BearieJunior player = new BearieJunior(300, 150, false, 100, 100, 1, null, 12, true, 0, 5, new WeaponSack(weapons));
        player.setEffectedByGravity(true);
//        player.getFrontArm().setIdleAngle(180);

//        player.getFrontArm().setIdleAngle(-90);
//        Player player = new TestModel(300, 150, false, 100, 100, 1, null, 12, true, 0, new WeaponSack(weapons));
        ArrayList<Entity> entitys = new ArrayList<>();
        Player player2 = new Player(300, 150, false, 100, 100, 0, null, 12, true, 0, 1, new WeaponSack());
        Player player3 = new Player(325, 150, false, 100, 100, 0, null, 12, true, 0, 1, new WeaponSack());
        Player player4 = new Player(350, 150, false, 100, 100, 0, null, 12, true, 0, 1, new WeaponSack());
        Player player5 = new Player(375, 150, false, 100, 100, 0, null, 12, true, 0, 1, new WeaponSack());
        Player player6 = new Player(400, 150, false, 100, 100, 0, null, 12, true, 0, 1, new WeaponSack());
        Player player7 = new Player(425, 150, false, 100, 100, 0, null, 12, true, 0, 1, new WeaponSack());
        Player player8 = new Player(450, 150, false, 100, 100, 0, null, 12, true, 0, 5, new WeaponSack());
//        entitys.add(new Wall(0, 0, 1000, 50, false, 100, 100, 100, null));
//        entitys.add(new Wall(0, 0, 50, 100, false, 100, 100, 100, null));
//        entitys.add(new Wall(1000, 0, 50, 1000, false, 100, 100, 100, null));
        entitys.add(player);
//        entitys.add(player2);
//        entitys.add(player3);
//        entitys.add(player4);
//        entitys.add(player5);
//        entitys.add(player6);
//        entitys.add(player7);
        entitys.add(player8);
//        entitys.add(new Wall(0, 200, 640, 17, false, 100, 100, 100, null));
        entitys.add(new Wall(0, 800, 10000, 50, false, 100, 100, 100, null));
        
//        Skin.BEARIE_JUNIOR.applySkin(player);

//        Skin.CARL.applySkin(player);

        Skin.GREG.applySkin(player2);
        Skin.GREG.applySkin(player3);
        Skin.GREG.applySkin(player4);
        Skin.GREG.applySkin(player5);
        Skin.GREG.applySkin(player6);
        Skin.GREG.applySkin(player7);
        Skin.GREG.applySkin(player8);
        
//        player2.setVelocityX(-1);
//        player2.setRestoreVelXToZero(false);
//        player3.setVelocityX(-1);
//        player3.setRestoreVelXToZero(false);
//        player4.setVelocityX(-1);
//        player4.setRestoreVelXToZero(false);
//        player5.setVelocityX(-1);
//        player5.setRestoreVelXToZero(false);
//        player6.setVelocityX(-1);
//        player6.setRestoreVelXToZero(false);
//        player7.setVelocityX(-1);
//        player7.setRestoreVelXToZero(false);
//        player8.setVelocityX(-1);
//        player8.setRestoreVelXToZero(false);
        start(player, Controls.defaultControls(), entitys);
    }
    
    public static void start(Player player, Controls controls, ArrayList<Entity> entitys){        
        MainFrame frame = new MainFrame();
        MainPanel panel = new MainPanel(player, controls, entitys);
        
        frame.setTitle(Config.GAME_TITLE);
        
        frame.changePanel(panel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setMinimumSize(Config.MINIMUM_FRAME_SIZE);
        frame.setPreferredSize(Config.MINIMUM_FRAME_SIZE);


        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
//        Config.makeFrameFullScreen(frame);
//        
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(ZombieApocalypseRevised.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        Config.turnOffFullScreen(frame);
    }
    
}
