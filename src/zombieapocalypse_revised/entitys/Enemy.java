/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.entitys;

import alanutilites.shape.Line;
import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import zombieapocalypse_revised.entitys.accessories.WeaponSack;
import zombieapocalypse_revised.entitys.skins.CustomSkinSize;

/**
 *
 * @author Alan Tsui
 */
public class Enemy extends Wielder{
    private double shootingRange;
    private Rectangle2D.Double viewBox;//for range
    private Player target;
    
    private Line line;
    
    public Enemy(String name, int x, int y, boolean passable, double health, double maxHealth, double armor, ImageIcon icon, int speed, boolean effectedByGravity, double angle, double size, double damageMultiplyer, WeaponSack weaponSack) {
        super(name, x, y, passable, health, maxHealth, armor, icon, speed, effectedByGravity, angle, size, damageMultiplyer, weaponSack);
        viewBox = new Rectangle2D.Double();
        line = new Line();
    }

    public Enemy(String name, int x, int y, boolean passable, double health, double maxHealth, double armor, ImageIcon icon, int speed, boolean effectedByGravity, double angle, double size, double damageMultiplyer, WeaponSack weaponSack, CustomSkinSize skinSize) {
        super(name, x, y, passable, health, maxHealth, armor, icon, speed, effectedByGravity, angle, size, damageMultiplyer, weaponSack, skinSize);
        viewBox = new Rectangle2D.Double();
        line = new Line();
    }

    public Enemy(Enemy wielder) {
        super(wielder);
        shootingRange = wielder.shootingRange;
        viewBox = new Rectangle2D.Double(wielder.viewBox.getX(), wielder.viewBox.getY(), wielder.viewBox.getWidth(), wielder.viewBox.getHeight());
        target = wielder.target;
    }

    @Override
    public void resize(double widthToResizeBy, double heightToResizeBy, Dimension dimension) {
        super.resize(widthToResizeBy, heightToResizeBy, dimension);
        shootingRange = shootingRange*widthToResizeBy;
    }
    
    @Override
    public void update(ArrayList<Entity> entitys, int tickSpeed) {
        super.update(entitys, tickSpeed);
        viewBox.setRect(getX()-shootingRange, getY()-shootingRange, (shootingRange*2)+getWidth(), (shootingRange*2)+getHeight());
        if(target == null){
            changeTarget(entitys);
        }
        else{
            Point2D.Double targetCenter = target.getCenter();
            Point2D.Double thisCenter = getCenter();
            line.setStartPoint(thisCenter.x, thisCenter.y);
            line.setStartPoint(targetCenter.x, targetCenter.y);
        }
    }
    
    public void changeTarget(ArrayList<Entity> entitys){
        for(int i=0;i<entitys.size();i++){
            if(entitys.get(i) instanceof Player){
                target = (Player)(entitys.get(i));
                break;
            }
        }
    }
}
