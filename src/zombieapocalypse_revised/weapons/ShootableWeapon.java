/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.weapons;

import alanutilites.shape.ShapeUtil;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import zombieapocalypse_revised.entitys.Entity;
import zombieapocalypse_revised.entitys.Wielder;
import zombieapocalypse_revised.limbs.Limb;

/**
 *
 * @author Alan Tsui
 */
public class ShootableWeapon extends Weapon{
    private int mag;
    private int maxMag;
    private int clip;
    private int maxClip;
    
    private boolean shoot;
    private int timeBeforeNextShot;
    private int nextShotCounter;
    
    private double gunOffset;//for rendering
    private double exitOffset;//in percent 0 to 1
    
    private int reloadSpeed;//in ticks / milliseconds
    private boolean reloading;
    private boolean reloadIndividually;
    private int reloadCounter;
    
//    private Point2D.Double exitPoint;//relative to wielders body (0,0)
    private Bullet bullet;
    
    private boolean infiniteAmmo;
    
    public ShootableWeapon(String name, int damage, ImageIcon image, int mag, int maxMag, int clip, int maxClip, int timeBeforeNextShot, int reloadSpeed, boolean reloadIndividually, double gunOffset, double exitOffset, Bullet bullet) {
        super(name, damage, image);
        this.mag = mag;
        this.maxMag = maxMag;
        this.clip = clip;
        this.maxClip = maxClip;
        
        this.gunOffset = gunOffset;
        
        this.timeBeforeNextShot = timeBeforeNextShot;
        
        this.reloadSpeed = reloadSpeed;
        this.reloadIndividually = reloadIndividually;
        
        this.exitOffset = exitOffset;
        this.bullet = bullet;
        infiniteAmmo = false;
    }
    
    public ShootableWeapon(ShootableWeapon weapon){
        super(weapon);
        this.mag = weapon.mag;
        this.maxMag = weapon.maxMag;
        this.clip = weapon.clip;
        this.maxClip = weapon.maxClip;
        
        this.gunOffset = weapon.gunOffset;

        this.shoot = weapon.shoot;
        this.timeBeforeNextShot = weapon.timeBeforeNextShot;
        this.nextShotCounter = weapon.nextShotCounter;

        this.reloadSpeed = weapon.reloadSpeed;
        this.reloading = weapon.reloading;
        this.reloadIndividually = weapon.reloadIndividually;
        this.reloadCounter = weapon.reloadCounter;
        
        this.exitOffset = weapon.exitOffset;
//        this.exitPoint = new Point2D.Double(weapon.exitPoint.x, weapon.exitPoint.y);
        this.bullet = (Bullet)weapon.bullet.copy();

        this.infiniteAmmo = weapon.infiniteAmmo;
    }

    @Override
    public Weapon copy() {
        return new ShootableWeapon(this);
    }

    @Override
    public void resize(double widthToResizeBy, double heightToResizeBy, Dimension dimension) {
        super.resize(widthToResizeBy, heightToResizeBy, dimension);
//        System.out.println("Previous "+bullet.getWidth()+" "+bullet.getHeight());
//        exitPoint.x = exitPoint.x*widthToResizeBy;
//        exitPoint.y = exitPoint.y*heightToResizeBy;
//        exitOffset = exitOffset*widthToResizeBy;
        bullet.resize(widthToResizeBy, heightToResizeBy, dimension);
        gunOffset = gunOffset*heightToResizeBy;
//        bullet.setWidth(bullet.getWidth()*widthToResizeBy);
//        bullet.setHeight(bullet.getHeight()*heightToResizeBy);
//        bullet.set
//        System.out.println("After "+bullet.getWidth()+" "+bullet.getHeight());
    }
    
    public void reload(){
        if(!reloading){
            reloading = true;
        }
    }
    
    /**
     * Replenishes ammo till max
     * @param ammoAmount  the amount of ammo to replenish
     */
    public void restoreClip(int ammoAmount){
        clip += ammoAmount;
        if(clip >= maxClip){
            clip = maxClip;
        }
    }
    
    /**
     * Replenishes mag, ignores max mag
     * @param ammoAmount  the amount of ammo to replenish
     */
    public void setMag(int ammoAmount){
        mag += ammoAmount;
    }

    @Override
    public void update(ArrayList<Entity> entitys, Wielder wielder, int tickSpeed) {
        if(reloading){
            reloadCounter += tickSpeed;
            if(reloadCounter >= reloadSpeed){
                if(mag >= maxMag){
                    reloading = false;
                }
                if(clip <= 0){
                    reloading = false;
                }
                if(reloadIndividually){
                    mag++;
                    clip--;
                }
                else{
                    if(clip-(maxMag-mag) < 0){
                        mag += clip;
                        clip = 0;
                    }
                    else if(clip-(maxMag-mag) >= 0){
                        clip -= maxMag-mag;
                        mag += maxMag-mag;
                    }
                }
            }
        }
        if(!shoot){
            nextShotCounter += tickSpeed;
            if(nextShotCounter >= timeBeforeNextShot){
                shoot = true;
                nextShotCounter = 0;
            }
        }
    }

    @Override
    public void render(Graphics2D gd, Limb limb, Wielder wielder) {        
        Graphics2D g2d = (Graphics2D)gd.create();            
//        g2d.rotate(Math.atan2(wielder.getAnglePoint().y - (wielder.getY()+exitPoint.y), wielder.getAnglePoint().x - (wielder.getX()+exitPoint.x))+Math.PI/-2.0, limb.getPivot().getX(), limb.getPivot().getY());
//        g2d.rotate(Math.atan2(wielder.getAnglePoint().y - (((limb.getY()+limb.getHeight())-gunOffset+getResizeDimension().getHeight())), wielder.getAnglePoint().x - (limb.getX()+exitOffset))+Math.PI/-2.0, limb.getPivot().getX(), limb.getPivot().getY());

        g2d.rotate(Math.atan2(wielder.getAnglePoint().y - limb.getPivot().y, wielder.getAnglePoint().x - limb.getPivot().x)+Math.PI/-2.0, limb.getPivot().getX(), limb.getPivot().getY());
        double exitOffsetPercent = getImage() == null ? exitOffset*100 : getResizeDimension().getHeight()*exitOffset;
        g2d.fillRect((int)(limb.getX()+limb.getWidth()/2+getResizeDimension().getHeight()*exitOffset), (int)((limb.getY()+limb.getHeight())-gunOffset+getResizeDimension().getHeight()), 1, 1);
        if(getImage() != null){            
            Graphics2D g2d2 = (Graphics2D)g2d.create();
            if(wielder.isLookingLeft()){
                g2d2.drawImage(getImage().getImage(), (int)(limb.getX()+limb.getWidth()-limb.getWidth()/2), (int)((limb.getY()+limb.getHeight())-gunOffset), (int)(-getResizeDimension().getWidth()), (int)getResizeDimension().getHeight(), null);
            }
            else{
                g2d2.drawImage(getImage().getImage(), (int)(limb.getX()+limb.getWidth()/2), (int)((limb.getY()+limb.getHeight())-gunOffset), (int)(getResizeDimension().getWidth()), (int)getResizeDimension().getHeight(), null);
            }
        }
        limb.render(g2d);
    }

    @Override
    public void hit(ArrayList<Entity> entitys, Wielder entity, int tickSpeed) {
        reloading = false;
        if(shoot){
            if(mag > 0 || infiniteAmmo){
                shoot = false;
                shoot(entitys, entity);
            }
        }
    }
    
    public void shoot(ArrayList<Entity> entitys, Wielder wielder){
        if(!infiniteAmmo){
            mag--;
        }
        Limb limb = wielder.getFrontArm();
        Bullet newBullet = (Bullet)bullet.copy();
//        System.out.println(wielder.getAnglePoint());
        newBullet.setAngle(Math.atan2(wielder.getAnglePoint().y - limb.getPivot().y, wielder.getAnglePoint().x - limb.getPivot().x));
        Point2D.Double point;
        if(wielder.isLookingLeft()){
            point = ShapeUtil.rotatePoint(limb.getPivot(), ((limb.getX()+limb.getWidth()-(limb.getWidth()/2))-getResizeDimension().getHeight()*exitOffset), ((limb.getY()+limb.getHeight())-gunOffset+getResizeDimension().getHeight()), newBullet.getAngle()+Math.PI/-2.0);
        }
        else{
            point = ShapeUtil.rotatePoint(limb.getPivot(), (limb.getX()+limb.getWidth()/2+getResizeDimension().getHeight()*exitOffset), ((limb.getY()+limb.getHeight())-gunOffset+getResizeDimension().getHeight()), newBullet.getAngle()+Math.PI/-2.0);
        }
//        newBullet.setX((limb.getX()+exitOffset));
//        newBullet.setY(((limb.getY()+limb.getHeight())-gunOffset+getResizeDimension().getHeight()));
        newBullet.setX(point.x);
        newBullet.setY(point.y);
        newBullet.setEntity(wielder);
        newBullet.add(wielder);
        entitys.add(newBullet);
    }
    
    
    
}
