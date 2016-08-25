/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.entitys;

import alanutilites.util.collision.Collision;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Alan Tsui
 */
public class MovingEntity extends DamagableEntity{
    public static final int DEFAULT_GRAVITY = 5;
            
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    public boolean jump;
    
    private boolean move;
    
    private boolean moving;
    
    private boolean canJumpAgain;
    
    private boolean restoreVelXToZero;
    
    private boolean effectedByGravity;

    private double slowness;
    private double speed;    
    private double velocityX;
    private double velocityY;
    private double jumpSpeed;
    private double gravity;
    public MovingEntity(int x, int y, int width, int height, boolean passable, double health, double maxHealth, double armor, ImageIcon icon, int speed, boolean effectedByGravity) {
        super(x, y, width, height, passable, health, maxHealth, armor, icon);        
        slowness = 0;
        this.speed = speed;
        jumpSpeed = speed*5;
        gravity = speed < 3 ? 1 : speed/3;
        move = true;
        restoreVelXToZero = true;
        this.effectedByGravity = effectedByGravity;
    }
    
    public MovingEntity(MovingEntity entity){
        super(entity);
        
        this.up = entity.up;
        this.down = entity.down;
        this.left = entity.left;
        this.right = entity.right;
        this.jump = entity.jump;

        this.move = entity.move;

        this.moving = entity.moving;

        this.canJumpAgain = entity.canJumpAgain;

        this.restoreVelXToZero = entity.restoreVelXToZero;

        this.effectedByGravity = entity.effectedByGravity;

        this.slowness = entity.slowness;
        this.speed = entity.speed;
        this.velocityX = entity.velocityX;
        this.velocityY = entity.velocityY;
        this.jumpSpeed = entity.jumpSpeed;
        this.gravity = entity.gravity;
            
    }

    @Override
    public void resize(double widthToResizeBy, double heightToResizeBy, Dimension dimension) {
        super.resize(widthToResizeBy, heightToResizeBy, dimension);
        
        slowness = slowness*widthToResizeBy;
        speed = speed*widthToResizeBy;
        velocityX = velocityX*widthToResizeBy;
        velocityY = velocityY*heightToResizeBy;
        jumpSpeed = jumpSpeed*heightToResizeBy;
        gravity = gravity*heightToResizeBy;
    }
    
    @Override
    public Entity copy(){
        return new MovingEntity(this);
    }
    
    @Override
    public void update(ArrayList<Entity> entitys, int tickSpeed){
        if(canMove()){
            if(up){
                up();
            }
            if(down){
                down();
            }
            if(left){
                left();
            }
            if(right){
                right();
            }
            if(jump){
                jump();
            }
        }
        if(effectedByGravity){
            gravity();
        }
        if(velocityY > 0){
            boolean hasHitGround = Collision.move(1, this, entitys, (velocityY));
            canJumpAgain = hasHitGround;
            if(hasHitGround){
                velocityY = 0;
            }
        }
        if(velocityY < 0){
            Collision.move(3, this, entitys, (-velocityY));
        }
        if(velocityX > 0){
            Collision.move(2, this, entitys, (velocityX));
        }
        if(velocityX < 0){
            Collision.move(4, this, entitys, (-velocityX));
        }
        moving = !(velocityY == 0 && velocityX == 0);
        if(restoreVelXToZero){
            velocityX = 0;
        }
        super.update(entitys, tickSpeed);
    }
    
    @Override
    public void render(Graphics2D gd){
        super.render(gd);
    }
    
    private void gravity(){
        velocityY += gravity;
    }
    
    private void up(){
        velocityY -= (speed) - (speed*slowness);
    }
    
    private void down(){
        velocityY += speed - (speed*slowness);
    }
    
    private void left(){
        velocityX = -(speed - (int)(speed*slowness));
    }
    
    private void right(){
        velocityX = speed - (int)(speed*slowness);
    }
    
    private void jump(){
        if(canJumpAgain){
            canJumpAgain = false;
            velocityY -= jumpSpeed;
        }
    }

    public boolean isRestoreVelXToZero() {
        return restoreVelXToZero;
    }

    public void setRestoreVelXToZero(boolean restoreVelXToZero) {
        this.restoreVelXToZero = restoreVelXToZero;
    }

    public boolean isEffectedByGravity() {
        return effectedByGravity;
    }

    public void setEffectedByGravity(boolean effectedByGravity) {
        this.effectedByGravity = effectedByGravity;
    }

    public double getSlowness() {
        return slowness;
    }

    public void setSlowness(double slowness) {
        this.slowness = slowness < 0 ? 0 : slowness > 0 ? 1 : slowness;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    public double getJumpSpeed() {
        return jumpSpeed;
    }

    public void setJumpSpeed(double jumpSpeed) {
        this.jumpSpeed = jumpSpeed;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public boolean isMoving() {
        return moving;
    }

    public boolean canMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }
}
