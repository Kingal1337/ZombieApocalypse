/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.weapons;

import alanutilites.util.collision.Collision;
import alanutilites.util.collision.CollisionBox;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import zombieapocalypse_revised.animations.AbstractAnimation;
import zombieapocalypse_revised.animations.SlashAnimation;
import zombieapocalypse_revised.entitys.DamagableEntity;
import zombieapocalypse_revised.entitys.Entity;
import zombieapocalypse_revised.entitys.HumanLookingEntity;
import zombieapocalypse_revised.entitys.Wielder;
import zombieapocalypse_revised.limbs.Limb;

/**
 *
 * @author Alan Tsui
 */
public class MeleeWeapon extends Weapon{
    private AbstractAnimation previousAnimation;
    private HumanLookingEntity human;
    private AbstractAnimation animation;
    private double damageMultiplyer;
    private int hitboxDistance;
    private int swingSpeed;
    private int cooldown;//in ticks / milliseconds
    private int cooldownCounter;
    
    private boolean attackAgain;
    
    private boolean multiKill;

    private boolean attacking;
    
    public MeleeWeapon(String name, int damage, ImageIcon image, int swingSpeed, int hitboxDistance, HumanLookingEntity entity, int cooldown, boolean multiKill) {
        super(name, damage, image);
        this.swingSpeed = swingSpeed;
        this.hitboxDistance = hitboxDistance;
        this.human = entity;
        this.cooldown = cooldown;
        this.multiKill = multiKill;
        attackAgain = true;
        damageMultiplyer = 1;
//        animation = new SlashAnimation(entity.getFrontArm(), swingSpeed, false);
        animation = new SlashAnimation();
    }
    
    public MeleeWeapon(MeleeWeapon weapon){
        super(weapon);
        this.previousAnimation = weapon.previousAnimation;
        this.human = weapon.human;
        this.animation = weapon.animation.copy();
        this.hitboxDistance = weapon.hitboxDistance;
        this.swingSpeed = weapon.swingSpeed;
        this.cooldown = weapon.cooldown;
        this.cooldownCounter = weapon.cooldownCounter;
        
        this.attackAgain = weapon.attackAgain;

        this.multiKill = weapon.multiKill;
        
        this.attacking = weapon.attacking;
        
        this.damageMultiplyer = weapon.damageMultiplyer;
    }
    
    @Override
    public Weapon copy() {
        return new MeleeWeapon(this);
    }

    @Override
    public void update(ArrayList<Entity> entitys, Wielder wielder, int tickSpeed) {
        if(!attackAgain){
            cooldownCounter += tickSpeed;
            if(cooldownCounter >= cooldown){
                attackAgain = true;
                cooldownCounter = 0;
            }
        }
        if(attacking){
            animation.update(wielder.isLookingLeft(), swingSpeed);
            if(animation.isAnimationOver()){
                double damageToDo = getDamage()*damageMultiplyer;
                attacking = false;
                if(cooldown > 0){
                    attackAgain = false;
                }
                wielder.setAnimateFrontArm(true);
                wielder.setRenderFrontArm(true);
                wielder.setMove(true);

                ArrayList<Entity> entitysIntersecting = null;
                if(!multiKill){
                    entitysIntersecting = new ArrayList<>();
                }
                for(int i=0;i<entitys.size();i++){
                    if(entitys.get(i) instanceof DamagableEntity){
                        DamagableEntity entity = (DamagableEntity)(entitys.get(i));
                        if(entity.isDamagable()){
                            if(wielder.isLookingLeft()){
                                if(entity.intersects(new CollisionBox(wielder.getX()-hitboxDistance, wielder.getY(), hitboxDistance, wielder.getHeight(), true))){
                                    if(!multiKill){
                                        entitysIntersecting.add(entity);
                                    }
                                    else{                                        
                                        entity.takeDamage(damageToDo);
                                    }
                                }                                
                            }
                            else{
                                if(entity.intersects(new CollisionBox(wielder.getX()+wielder.getWidth(), wielder.getY(), hitboxDistance, wielder.getHeight(), true))){
                                    if(!multiKill){
                                        entitysIntersecting.add(entity);
                                    }
                                    else{                                        
                                        entity.takeDamage(damageToDo);
                                    }
                                }
                            }
                        }
                    }
                }
                if(!multiKill){
                    DamagableEntity entity = (DamagableEntity)Collision.getClosestCollisionBox(wielder, entitysIntersecting);
                    if(entity != null){
                        entity.takeDamage(damageToDo);
                    }
                }
            }
        }
    }

    @Override
    public void render(Graphics2D gd, Limb limb, Wielder wielder) {
        Graphics2D g2d = (Graphics2D)gd.create();
        if(attacking){
            animation.render(g2d, limb, wielder.isLookingLeft());
        }
        if(getImage() != null){
            Graphics2D g2d2 = (Graphics2D)g2d.create();
            g2d2.rotate(Math.toRadians(limb.getIdleAngle()), limb.getPivot().getX(), limb.getPivot().getY());
            if(wielder.isLookingLeft()){
                g2d2.drawImage(getImage().getImage(), (int)(limb.getX()+limb.getWidth()-limb.getWidth()/2), (int)((limb.getY()+limb.getHeight())-(getHeight())), (int)(-getWidth()), (int)getHeight(), null);
            }
            else{
//                g2d2.drawRect(500,500,(int)getWidth(), (int)getHeight());
                g2d2.drawImage(getImage().getImage(), (int)(limb.getX()+limb.getWidth()/2), (int)((limb.getY()+limb.getHeight())-(getHeight())), (int)(getWidth()), (int)getHeight(), null);
            }
        }
        limb.render(g2d);
    }

    @Override
    public void hit(ArrayList<Entity> entitys, Wielder wielder, int tickSpeed, double damageMultiplyer) {
        if(!attacking && attackAgain){
            this.damageMultiplyer = damageMultiplyer;
            attacking = true;
            animation.setAnimationOver(false);
            wielder.setAnimateFrontArm(false);
            wielder.setRenderFrontArm(false);
            wielder.setMove(false);
        }
    }

    public int getSwingSpeed() {
        return swingSpeed;
    }

    public void setSwingSpeed(int swingSpeed) {
        this.swingSpeed = swingSpeed;
    }

    public int getHitboxDistance() {
        return hitboxDistance;
    }

    public void setHitboxDistance(int hitboxDistance) {
        this.hitboxDistance = hitboxDistance;
    }
}
