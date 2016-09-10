/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.weapons;

import alanutilites.util.collision.Collision;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import zombieapocalypse_revised.entitys.DamagableEntity;
import zombieapocalypse_revised.entitys.Entity;
import zombieapocalypse_revised.entitys.HumanLookingEntity;
import zombieapocalypse_revised.entitys.MovingEntity;
import zombieapocalypse_revised.entitys.Player;

/**
 *
 * @author Alan Tsui
 */
public class Bullet extends MovingEntity{
    private boolean setInitalPoints;
    private double angle;
    private double origx;
    private double origy;
    private double distance;
    private double force;
    private int damage;
    private Entity entity;
    public Bullet(String name, int x, int y, int width, int height, boolean passable, double health, double maxHealth, double armor, ImageIcon icon, int speed, boolean effectedByGravity, int damage, double angle, double force, Entity entity) {
        super(name, x, y, width, height, passable, health, maxHealth, armor, icon, speed, effectedByGravity);
        this.damage = damage;
        this.angle = angle;
        this.force = force;
        
        distance += getSpeed();
        
        setDamagable(false);
        
        setVelocityX(Math.cos(angle) * getSpeed());
        setVelocityY(Math.sin(angle) * getSpeed());
        
        setRestoreVelXToZero(false);
    }
    
    public Bullet(Bullet bullet){
        super(bullet);
        setInitalPoints = bullet.setInitalPoints;
        angle = bullet.angle;
        origx = bullet.origx;
        origy = bullet.origy;
        distance = bullet.distance;
        damage = bullet.damage;
        this.force = bullet.force;
        this.entity = bullet.entity;
    }
    
    @Override
    public Entity copy(){
        return new Bullet(this);
    }

    @Override
    public void resize(double widthToResizeBy, double heightToResizeBy, Dimension dimension) {
        super.resize(widthToResizeBy, heightToResizeBy, dimension);
        origx = origx*widthToResizeBy;
        origy = origy*heightToResizeBy;
    }

    @Override
    public void render(Graphics2D gd) {
        Graphics2D g2d = (Graphics2D)gd.create();
        g2d.rotate(isEffectedByGravity() ? Math.atan2(getVelocityY(), getVelocityX()) : angle, getX(), getY());
        super.render(g2d);
    }

    @Override
    public void update(ArrayList<Entity> entitys, int tickSpeed) {
        super.update(entitys, tickSpeed);
        for(int i=0;i<entitys.size();i++){
            if(!entitys.get(i).equals(this)){
                if(Collision.intersects(entitys.get(i).getX()-1, entitys.get(i).getY()-1, entitys.get(i).getWidth()+2, entitys.get(i).getHeight()+2, getX()-1, getY()-1, getWidth()+2, getHeight()+2) || ((entitys.get(i) instanceof HumanLookingEntity)) && Collision.intersects(entitys.get(i).getX()-1, entitys.get(i).getY()-((HumanLookingEntity)entitys.get(i)).getHead().getHeight()-1,((HumanLookingEntity)entitys.get(i)).getHead().getWidth()+2, ((HumanLookingEntity)entitys.get(i)).getHead().getHeight()+2, getX()-1, getY()-1, getWidth()+2, getHeight()+2)){
                    if(!isIgnored(entitys.get(i))){
                        if(entitys.get(i) instanceof Bullet){
                            if(!((Bullet)(entitys.get(i))).entity.equals(this.entity)){
                                if(entitys.get(i) instanceof DamagableEntity){
                                    DamagableEntity damagableEntity = (DamagableEntity)entitys.get(i);
                                    damagableEntity.takeDamage(damage);
                                    setRemove(true);
                                    break;
                                }
                            }
                        }
                        else if(entitys.get(i) instanceof DamagableEntity){
                            DamagableEntity damagableEntity = (DamagableEntity)entitys.get(i);
                            damagableEntity.takeDamage(damage);
                            setRemove(true);
                            break;
                        }
                        else{                            
                            setRemove(true);
                            break;
                        }
                    }
                }
            }
        }
//        System.out.println("REMOVING : "+isRemove());
        if(!setInitalPoints){
            setInitalPoints = true;
//            origx = getX();
//            origy = getY();
            distance += getSpeed()*force;
            setVelocityX(calcSpeedX(angle));
            setVelocityY(calcSpeedY(angle));
        }
//        distance += getSpeed();
//        setX(origx+calcSpeedX(angle));
//        setY(origy+calcSpeedY(angle));
//        if(!isEffectedByGravity()){
//            distance += getSpeed();
//            setX(origx+calcSpeedX(angle));
//            setY(origy+calcSpeedY(angle));
//        }
    }
    
    public double calcSpeedX(double angle){
        return distance*Math.cos(angle);
    }
    
    public double calcSpeedY(double angle){
        return distance*Math.sin(angle);
    }  

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}

