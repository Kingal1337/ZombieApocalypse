/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.entitys.skins;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import zombieapocalypse_revised.entitys.Entity;
import zombieapocalypse_revised.entitys.Player;
import zombieapocalypse_revised.entitys.accessories.WeaponSack;

/**
 *
 * @author Alan Tsui
 */
public class BearieJunior extends Player{

    public BearieJunior(String name, int x, int y, boolean passable, double health, double maxHealth, double armor, ImageIcon icon, int speed, boolean effectedByGravity, double angle, double size, double damageMultiplyer, WeaponSack weaponSack) {
        super(name, x, y, passable, health, maxHealth, armor, icon, speed, effectedByGravity, angle, size, damageMultiplyer, weaponSack, new CustomSkinSize(
                new Dimension(60, 45), //head
                new Dimension(19, 35), //arm
                new Dimension(48, 52), //leg
                new Dimension(45, 53), //body
                new Point(0, -41),//head position
                new Point(22,-20), //head pivot position
                new Point(25,21),// arm pivot position
                new Point(15, 21), //arm position
                new Point(33,50), //leg pivot position
                new Point(9,50)//leg position
        ));
//        super(x, y, passable, health, maxHealth, armor, icon, speed, effectedByGravity, angle, size, weaponSack, new CustomSkinSize(
//                new Dimension(60, 45), //head
//                new Dimension(19, 35), //arm
//                new Dimension(48, 52), //leg
//                new Dimension(45, 53), //body
//                new Point(0, -41),//head position
//                new Point(22,-20), //head pivot position
//                new Point(25,21),// arm pivot position
//                new Point(15, 21), //arm position
//                new Point(33,50), //leg pivot position
//                new Point(9,50)//leg position
//        ));
        Skin.BEARIE_JUNIOR.applySkin(this);
    }

    @Override
    public void update(ArrayList<Entity> entitys, int tickSpeed) {
        if(isLookingLeft()){
            currentDefaultHeadPosition.x = (1*((getWidth()/2)-(getHead().getWidth()/2)));
            currentDefaultHeadPosition.y = (1*(-(getHead().getHeight()+(getHead().getHeight()/10))));
            
            currentDefaultHeadPivotPosition.x = (1*((getHead().getWidth()/3)));            
            currentDefaultHeadPivotPosition.y = (1*(-(getHead().getHeight()/2)));
            
            currentDefaultLegPosition.x = (1*(-(getWidth()/3)));
            currentDefaultLegPivotPosition.x = (1*((-(getWidth()/3))+(getFrontLeg().getWidth()/2)));
            
            currentDefaultArmPosition.x = (1*((getWidth()/2)-(getFrontArm().getWidth()/2)));
        }
        else{
            currentDefaultHeadPosition.x = (1*((getWidth()/2)-(getHead().getWidth()/3)));
            currentDefaultHeadPosition.y = (1*(-(getHead().getHeight()-(getHead().getHeight()/10))));
            
            currentDefaultHeadPivotPosition.x = (1*((getHead().getWidth()/2)));            
            currentDefaultHeadPivotPosition.y = (1*(-(getHead().getHeight()/2)));
            
            currentDefaultLegPosition.x = (1*(getWidth()/5)); 
            currentDefaultLegPivotPosition.x = (1*((getWidth()/5))+(getFrontLeg().getWidth()/2));
            
            currentDefaultArmPosition.x = (1*(getWidth()/2)-(getFrontArm().getWidth()/2));
        }

//        if(isLookingLeft()){
//            currentDefaultHeadPosition.y = (getSize()*-45);
//            currentDefaultHeadPivotPosition.y = (getSize()*-20);
//            
//            currentDefaultLegPosition.x = (getSize()*-12);
//            currentDefaultLegPivotPosition.x = (getSize()*12);
//            currentDefaultArmPosition.x = (getSize()*10);
//        }
//        else{
//            currentDefaultHeadPosition.y = (getSize()*-41);
//            currentDefaultHeadPivotPosition.y = (getSize()*-20);
//            
//            currentDefaultLegPosition.x = (getSize()*9); 
//            currentDefaultLegPivotPosition.x = (getSize()*33); 
//            currentDefaultArmPosition.x = (getSize()*15);
//        }
        super.update(entitys, tickSpeed);
    }
    
    
}
