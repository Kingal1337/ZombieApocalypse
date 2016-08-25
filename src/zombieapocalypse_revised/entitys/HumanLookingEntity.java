/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.entitys;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import zombieapocalypse_revised.animations.AbstractAnimation;
import zombieapocalypse_revised.animations.WalkingAnimation;
import zombieapocalypse_revised.config.Config;
import zombieapocalypse_revised.entitys.skins.CustomSkinSize;
import zombieapocalypse_revised.limbs.Arm;
import zombieapocalypse_revised.limbs.Head;
import zombieapocalypse_revised.limbs.Leg;
import zombieapocalypse_revised.limbs.Limb;

/**
 *
 * @author Alan Tsui
 */
public class HumanLookingEntity extends MovingEntity{   
    
//    public static final Dimension DEFAULT_HEAD_SIZE = new Dimension(70,70);
//    public static final Dimension DEFAULT_ARM_SIZE = new Dimension(30,70);
//    public static final Dimension DEFAULT_LEG_SIZE = new Dimension(30,70);
//    public static final Dimension DEFAULT_BODY_SIZE = new Dimension(50,100);
//    
//    /**
//     * this point are relative to (0,0)
//     */
//    public static final Point DEFAULT_HEAD_POSITION = new Point(-10,-60);
//    
//    /**
//     * this point are relative to (0,0)
//     */
//    public static final Point DEFAULT_HEAD_PIVOT_POSITION = new Point(25,-25);
//    
//    /**
//     * this point are relative to (0,0)
//     */
//    public static final Point DEFAULT_ARM_PIVOT_POSITION = new Point(25, 15);
//    
//    /**
//     * this point are relative to (0,0)
//     */
//    public static final Point DEFAULT_ARM_POSITION = new Point(10,15);
//    
//    /**
//     * this point are relative to (0,0)
//     */
//    public static final Point DEFAULT_LEG_PIVOT_POSITION = new Point(25, 80);
//    
//    /**
//     * this point are relative to (0,0)
//     */
//    public static final Point DEFAULT_LEG_POSITION = new Point(10,80);
    
    //<editor-fold defaultstate="collapsed" desc="Old Body Sizes and Positions For 1920x1080 Screens">    
    public static final Dimension DEFAULT_HEAD_SIZE = new Dimension(50,50);
    public static final Dimension DEFAULT_ARM_SIZE = new Dimension(20,50);
    public static final Dimension DEFAULT_LEG_SIZE = new Dimension(30,50);
    public static final Dimension DEFAULT_BODY_SIZE = new Dimension(30,50);
    
    /**
     * this point are relative to (0,0)
     */
    public static final Point DEFAULT_HEAD_POSITION = new Point((DEFAULT_BODY_SIZE.width/2)-(DEFAULT_HEAD_SIZE.width/2), -DEFAULT_HEAD_SIZE.height);
    
    /**
     * this point are relative to (0,0)
     */
    public static final Point DEFAULT_HEAD_PIVOT_POSITION = new Point((DEFAULT_BODY_SIZE.width/2)-(DEFAULT_HEAD_SIZE.width/2)+(DEFAULT_HEAD_SIZE.width/2), -(DEFAULT_HEAD_SIZE.width/2));
    
    /**
     * this point are relative to (0,0)
     */
    public static final Point DEFAULT_ARM_PIVOT_POSITION = new Point(DEFAULT_BODY_SIZE.width/2, 10);
    
    /**
     * this point are relative to (0,0)
     */
    public static final Point DEFAULT_ARM_POSITION = new Point((DEFAULT_BODY_SIZE.width/2)-(DEFAULT_ARM_SIZE.width/2),10);
    
    /**
     * this point are relative to (0,0)
     */
    public static final Point DEFAULT_LEG_PIVOT_POSITION = new Point(DEFAULT_BODY_SIZE.width/2, DEFAULT_BODY_SIZE.height);
    
    /**
     * this point are relative to (0,0)
     */
    public static final Point DEFAULT_LEG_POSITION = new Point((DEFAULT_BODY_SIZE.width/2)-(DEFAULT_LEG_SIZE.width/2),DEFAULT_BODY_SIZE.height);    
    //</editor-fold>
            
//    public static final Dimension DEFAULT_HEAD_SIZE = new Dimension(17,17);
//    public static final Dimension DEFAULT_ARM_SIZE = new Dimension(7,17);
//    public static final Dimension DEFAULT_LEG_SIZE = new Dimension(10,17);
//    public static final Dimension DEFAULT_BODY_SIZE = new Dimension(10,17);
//    
//    /**
//     * this point are relative to (0,0)
//     */
//    public static final Point DEFAULT_HEAD_POSITION = new Point((DEFAULT_BODY_SIZE.width/2)-(DEFAULT_HEAD_SIZE.width/2), -DEFAULT_HEAD_SIZE.height);
//    
//    /**
//     * this point are relative to (0,0)
//     */
//    public static final Point DEFAULT_HEAD_PIVOT_POSITION = new Point((DEFAULT_BODY_SIZE.width/2)-(DEFAULT_HEAD_SIZE.width/2)+(DEFAULT_HEAD_SIZE.width/2), -(DEFAULT_HEAD_SIZE.width/2));
//    
//    /**
//     * this point are relative to (0,0)
//     */
//    public static final Point DEFAULT_ARM_PIVOT_POSITION = new Point(DEFAULT_BODY_SIZE.width/2, 3);
//    
//    /**
//     * this point are relative to (0,0)
//     */
//    public static final Point DEFAULT_ARM_POSITION = new Point((DEFAULT_BODY_SIZE.width/2)-(DEFAULT_ARM_SIZE.width/2),3);
//    
//    /**
//     * this point are relative to (0,0)
//     */
//    public static final Point DEFAULT_LEG_PIVOT_POSITION = new Point(DEFAULT_BODY_SIZE.width/2, DEFAULT_BODY_SIZE.height);
//    
//    /**
//     * this point are relative to (0,0)
//     */
//    public static final Point DEFAULT_LEG_POSITION = new Point((DEFAULT_BODY_SIZE.width/2)-(DEFAULT_LEG_SIZE.width/2),DEFAULT_BODY_SIZE.height);
    
//    public Dimension currentDefaultHeadSize = DEFAULT_HEAD_SIZE;
//    public Dimension currentDefaultArmSize = DEFAULT_ARM_SIZE;
//    public Dimension currentDefaultLegSize = DEFAULT_LEG_SIZE;
//    public Dimension currentDefaultBodySize = DEFAULT_BODY_SIZE;
//    public Point currentDefaultHeadPosition = DEFAULT_HEAD_POSITION;
//    public Point currentDefaultHeadPivotPosition = DEFAULT_HEAD_PIVOT_POSITION;
//    public Point currentDefaultArmPivotPosition = DEFAULT_ARM_PIVOT_POSITION;
//    public Point currentDefaultArmPosition = DEFAULT_ARM_POSITION;
//    public Point currentDefaultLegPivotPosition = DEFAULT_LEG_PIVOT_POSITION;
//    public Point currentDefaultLegPosition = DEFAULT_LEG_POSITION;
    
    public Dimension2D currentDefaultHeadSize;
    public Dimension2D currentDefaultArmSize;
    public Dimension2D currentDefaultLegSize;
    public Dimension2D currentDefaultBodySize;
    public Point2D.Double currentDefaultHeadPosition;
    public Point2D.Double currentDefaultHeadPivotPosition;
    public Point2D.Double currentDefaultArmPivotPosition;
    public Point2D.Double currentDefaultArmPosition;
    public Point2D.Double currentDefaultLegPivotPosition;
    public Point2D.Double currentDefaultLegPosition;
    
    private Point2D.Double anglePoint;
    private double angle;
    private double size;
    
    private AbstractAnimation frontArmAnimation;
    private AbstractAnimation backArmAnimation;
    private AbstractAnimation frontLegAnimation;
    private AbstractAnimation backLegAnimation;
    
    private Limb head;
    private Limb frontArm;
    private Limb backArm;
    private Limb frontLeg;
    private Limb backLeg;
    
    private boolean animateFrontArm;
    private boolean animateBackArm;
    private boolean animateFrontLeg;
    private boolean animateBackLeg;
    
    private boolean renderFrontArm;
    private boolean renderBackArm;
    private boolean renderFrontLeg;
    private boolean renderBackLeg;
    
    private boolean lookingLeft;
    
    /*
        size = 1 for default size;  > 1 for bigger size ; < 1 for smaller size
    */
    public HumanLookingEntity(
            int x, int y, boolean passable, double health, double maxHealth, 
            double armor, ImageIcon icon, int speed, boolean effectedByGravity,
            double angle, double size){
//            Limb[] limbs) {
        super(x, y, (int)(DEFAULT_BODY_SIZE.width*size), (int)(DEFAULT_BODY_SIZE.height*size), passable, health, maxHealth, armor, icon, speed, effectedByGravity);
//        if(limbs.length != 4){
//            try {
//                throw new Exception("Limbs cannot be greater than or less than 4");
//            } catch (Exception ex) {
//                Logger.getLogger(HumanLookingEntity.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        this.angle = angle;
        this.size = size;
        
//        frontArm = limbs[0];
//        backArm = limbs[1];
//        frontLeg = limbs[2];
//        backLeg = limbs[3];
        
        currentDefaultBodySize = new Dimension((int)(DEFAULT_BODY_SIZE.width*size), (int)(DEFAULT_BODY_SIZE.height*size));
        currentDefaultBodySize.setSize((DEFAULT_BODY_SIZE.width*size), (DEFAULT_BODY_SIZE.height*size));
        
        currentDefaultHeadPosition = new Point2D.Double((DEFAULT_HEAD_POSITION.x*size), (DEFAULT_HEAD_POSITION.y*size));
        currentDefaultHeadSize = new Dimension();
        currentDefaultHeadSize.setSize((DEFAULT_HEAD_SIZE.width*size), (DEFAULT_HEAD_SIZE.height*size));
        currentDefaultHeadPivotPosition = new Point2D.Double((DEFAULT_HEAD_PIVOT_POSITION.x*size), (DEFAULT_HEAD_PIVOT_POSITION.y*size));
        
        currentDefaultArmPosition = new Point2D.Double((DEFAULT_ARM_POSITION.x*size), (DEFAULT_ARM_POSITION.y*size));
        currentDefaultArmSize = new Dimension();
        currentDefaultArmSize.setSize((DEFAULT_ARM_SIZE.width*size), (DEFAULT_ARM_SIZE.height*size));
        currentDefaultArmPivotPosition = new Point2D.Double((DEFAULT_ARM_PIVOT_POSITION.x*size), (DEFAULT_ARM_PIVOT_POSITION.y*size));
        
        currentDefaultLegPosition = new Point2D.Double((DEFAULT_LEG_POSITION.x*size), (DEFAULT_LEG_POSITION.y*size));
        currentDefaultLegSize = new Dimension();
        currentDefaultLegSize.setSize((DEFAULT_LEG_SIZE.width*size), (DEFAULT_LEG_SIZE.height*size));
        currentDefaultLegPivotPosition = new Point2D.Double((DEFAULT_LEG_PIVOT_POSITION.x*size), (DEFAULT_LEG_PIVOT_POSITION.y*size));
        
        head = new Head(x+currentDefaultHeadPosition.getX(), x+currentDefaultHeadPosition.getY(), currentDefaultHeadSize.getWidth(), currentDefaultHeadSize.getHeight(), 0, null, new Point2D.Double(x+currentDefaultHeadPivotPosition.x, y+currentDefaultHeadPivotPosition.y));
        frontArm = new Arm(x+currentDefaultArmPosition.getX(), y+currentDefaultArmPosition.getY(), currentDefaultArmSize.getWidth(), currentDefaultArmSize.getHeight(), 0, null, new Point2D.Double(x+currentDefaultArmPivotPosition.x, y+currentDefaultArmPivotPosition.y));
        backArm = new Arm(x+currentDefaultArmPosition.getX(), y+currentDefaultArmPosition.getY(), currentDefaultArmSize.getWidth(), currentDefaultArmSize.getHeight(), 0, null, new Point2D.Double(x+currentDefaultArmPivotPosition.x, y+currentDefaultArmPivotPosition.y));
        frontLeg = new Leg(x+currentDefaultLegPosition.getX(), y+currentDefaultLegPosition.getY(), currentDefaultLegSize.getWidth(), currentDefaultLegSize.getHeight(), 0, null, new Point2D.Double(x+currentDefaultLegPivotPosition.x, y+currentDefaultLegPivotPosition.y));
        backLeg = new Leg(x+currentDefaultLegPosition.getX(), y+currentDefaultLegPosition.getY(), currentDefaultLegSize.getWidth(), currentDefaultLegSize.getHeight(), 0, null, new Point2D.Double(x+currentDefaultLegPivotPosition.x, y+currentDefaultLegPivotPosition.y));
        
        frontArmAnimation = new WalkingAnimation();
        backArmAnimation = new WalkingAnimation();
        frontLegAnimation = new WalkingAnimation();
        backLegAnimation = new WalkingAnimation();
        
        animateFrontArm = true;
        animateBackArm = true;
        animateFrontLeg = true;
        animateBackLeg = true;
        
        renderFrontArm = true;
        renderBackArm = true;
        renderFrontLeg = true;
        renderBackLeg = true;
        
        anglePoint = new Point2D.Double(0,0);
        
        setHealthOffSet((int)(head.getHeight()+10));
        setHeight(getHeight()+currentDefaultLegSize.getHeight()-((getY()+getHitBoxHeight())-(y+currentDefaultLegPosition.y)));
    }
    
    public HumanLookingEntity(
            int x, int y, boolean passable, double health, double maxHealth, 
            double armor, ImageIcon icon, int speed, boolean effectedByGravity,
            double angle, double size, CustomSkinSize skinSize){
//            Limb[] limbs) {
        super(x, y, (int)(skinSize.defaultBodySize.width*size), (int)(skinSize.defaultBodySize.height*size), passable, health, maxHealth, armor, icon, speed, effectedByGravity);
        this.angle = angle;
        this.size = size;
        
        currentDefaultBodySize = new Dimension();
        currentDefaultBodySize.setSize((skinSize.defaultBodySize.width*size), (skinSize.defaultBodySize.height*size));
        
        currentDefaultHeadPosition = new Point2D.Double((skinSize.defaultHeadPosition.x*size), (skinSize.defaultHeadPosition.y*size));
        currentDefaultHeadSize = new Dimension();
        currentDefaultHeadSize.setSize((skinSize.defaultHeadSize.width*size), (skinSize.defaultHeadSize.height*size));
        currentDefaultHeadPivotPosition = new Point2D.Double((skinSize.defaultHeadPivotPosition.x*size), (skinSize.defaultHeadPivotPosition.y*size));
        
        currentDefaultArmPosition = new Point2D.Double((skinSize.defaultArmPosition.x*size), (skinSize.defaultArmPosition.y*size));
        currentDefaultArmSize = new Dimension();
        currentDefaultArmSize.setSize((skinSize.defaultArmSize.width*size), (skinSize.defaultArmSize.height*size));
        currentDefaultArmPivotPosition = new Point2D.Double((skinSize.defaultArmPivotPosition.x*size),(skinSize.defaultArmPivotPosition.y*size));
        
        currentDefaultLegPosition = new Point2D.Double((skinSize.defaultLegPosition.x*size), (skinSize.defaultLegPosition.y*size));
        currentDefaultLegSize = new Dimension();
        currentDefaultLegSize.setSize((skinSize.defaultLegSize.width*size), (skinSize.defaultLegSize.height*size));
        currentDefaultLegPivotPosition = new Point2D.Double((skinSize.defaultLegPivotPosition.x*size), (skinSize.defaultLegPivotPosition.y*size));
        
        head = new Head(x+currentDefaultHeadPosition.x, x+currentDefaultHeadPosition.y, currentDefaultHeadSize.getWidth(), currentDefaultHeadSize.getHeight(), 0, null, new Point2D.Double(x+currentDefaultHeadPivotPosition.x, y+currentDefaultHeadPivotPosition.y));
        frontArm = new Arm(x+currentDefaultArmPosition.x, y+currentDefaultArmPosition.y, currentDefaultArmSize.getWidth(), currentDefaultArmSize.getHeight(), 0, null, new Point2D.Double(x+currentDefaultArmPivotPosition.x, y+currentDefaultArmPivotPosition.y));
        backArm = new Arm(x+currentDefaultArmPosition.x, y+currentDefaultArmPosition.y, currentDefaultArmSize.getWidth(), currentDefaultArmSize.getHeight(), 0, null, new Point2D.Double(x+currentDefaultArmPivotPosition.x, y+currentDefaultArmPivotPosition.y));
        frontLeg = new Leg(x+currentDefaultLegPosition.x, y+currentDefaultLegPosition.y, currentDefaultLegSize.getWidth(), currentDefaultLegSize.getHeight(), 0, null, new Point2D.Double(x+currentDefaultLegPivotPosition.x, y+currentDefaultLegPivotPosition.y));
        backLeg = new Leg(x+currentDefaultLegPosition.x, y+currentDefaultLegPosition.y, currentDefaultLegSize.getWidth(), currentDefaultLegSize.getHeight(), 0, null, new Point2D.Double(x+currentDefaultLegPivotPosition.x, y+currentDefaultLegPivotPosition.y));
        
        frontArmAnimation = new WalkingAnimation();
        backArmAnimation = new WalkingAnimation();
        frontLegAnimation = new WalkingAnimation();
        backLegAnimation = new WalkingAnimation();
        
        animateFrontArm = true;
        animateBackArm = true;
        animateFrontLeg = true;
        animateBackLeg = true;
        
        renderFrontArm = true;
        renderBackArm = true;
        renderFrontLeg = true;
        renderBackLeg = true;
        
        anglePoint = new Point2D.Double(0,0);
        
        setHealthOffSet((int)(head.getHeight()+10));
        setHeight(getHeight()+currentDefaultLegSize.getHeight()-((getY()+getHitBoxHeight())-(y+currentDefaultLegPosition.y)));
    }
    
    public HumanLookingEntity(HumanLookingEntity entity){
        super(entity);
        
        this.currentDefaultHeadSize = new Dimension();
        this.currentDefaultHeadSize.setSize(entity.currentDefaultHeadSize.getWidth(), entity.currentDefaultHeadSize.getHeight());
        
        this.currentDefaultArmSize = new Dimension((int)entity.currentDefaultArmSize.getWidth(), (int)entity.currentDefaultArmSize.getHeight());
        this.currentDefaultArmSize.setSize(entity.currentDefaultArmSize.getWidth(), entity.currentDefaultArmSize.getHeight());
        
        this.currentDefaultLegSize = new Dimension((int)entity.currentDefaultLegSize.getWidth(), (int)entity.currentDefaultLegSize.getHeight());
        this.currentDefaultLegSize.setSize(entity.currentDefaultLegSize.getWidth(), entity.currentDefaultLegSize.getHeight());
        
        this.currentDefaultBodySize = new Dimension((int)entity.currentDefaultBodySize.getWidth(), (int)entity.currentDefaultBodySize.getHeight());
        this.currentDefaultBodySize.setSize(entity.currentDefaultBodySize.getWidth(), entity.currentDefaultBodySize.getHeight());
        
        this.currentDefaultHeadPosition = new Point2D.Double(entity.currentDefaultHeadPosition.getX(), entity.currentDefaultHeadPosition.getY());
        this.currentDefaultHeadPivotPosition = new Point2D.Double(entity.currentDefaultHeadPivotPosition.getX(), entity.currentDefaultHeadPivotPosition.getY());
        this.currentDefaultArmPivotPosition = new Point2D.Double(entity.currentDefaultArmPivotPosition.getX(), entity.currentDefaultArmPivotPosition.getY());
        this.currentDefaultArmPosition = new Point2D.Double(entity.currentDefaultArmPosition.getX(), entity.currentDefaultArmPosition.getY());
        this.currentDefaultLegPivotPosition = new Point2D.Double(entity.currentDefaultLegPivotPosition.getX(), entity.currentDefaultLegPivotPosition.getY());
        this.currentDefaultLegPosition = new Point2D.Double(entity.currentDefaultLegPosition.getX(), entity.currentDefaultLegPosition.getY());

        this.anglePoint = new Point2D.Double(entity.anglePoint.getX(), entity.anglePoint.getY());
        this.angle = entity.angle;
        this.size = entity.size;

        this.frontArmAnimation = entity.frontArmAnimation.copy();
        this.backArmAnimation = entity.backArmAnimation.copy();
        this.frontLegAnimation = entity.frontLegAnimation.copy();
        this.backLegAnimation = entity.backLegAnimation.copy();

        this.head = entity.head.copy();
        this.frontArm = entity.frontArm.copy();
        this.backArm = entity.backArm.copy();
        this.frontLeg = entity.frontLeg.copy();
        this.backLeg = entity.backLeg.copy();

        this.animateFrontArm = entity.animateFrontArm;
        this.animateBackArm = entity.animateBackArm;
        this.animateFrontLeg = entity.animateFrontLeg;
        this.animateBackLeg = entity.animateBackLeg;

        this.renderFrontArm = entity.renderFrontArm;
        this.renderBackArm = entity.renderBackArm;
        this.renderFrontLeg = entity.renderFrontLeg;
        this.renderBackLeg = entity.renderBackLeg;

        this.lookingLeft = entity.lookingLeft;
    }
    
    @Override
    public Entity copy(){
        return new HumanLookingEntity(this);
    }

    @Override
    public void resize(double widthToResizeBy, double heightToResizeBy, Dimension dimension) {
        super.resize(widthToResizeBy, heightToResizeBy, dimension);
        
//        size = dimension.width/Config.MINIMUM_FRAME_SIZE.width;
        
        currentDefaultHeadSize.setSize(((currentDefaultHeadSize.getWidth()))*widthToResizeBy, ((currentDefaultHeadSize.getHeight())*heightToResizeBy));
        currentDefaultArmSize.setSize(((currentDefaultArmSize.getWidth()))*widthToResizeBy, ((currentDefaultArmSize.getHeight())*heightToResizeBy));
        currentDefaultLegSize.setSize(((currentDefaultLegSize.getWidth()))*widthToResizeBy, ((currentDefaultLegSize.getHeight())*heightToResizeBy));
        currentDefaultBodySize.setSize(((currentDefaultBodySize.getWidth()))*widthToResizeBy, ((currentDefaultBodySize.getHeight())*heightToResizeBy));
        currentDefaultHeadPosition.setLocation(((currentDefaultHeadPosition.x))*widthToResizeBy, ((currentDefaultHeadPosition.y)*heightToResizeBy));
        currentDefaultHeadPivotPosition.setLocation(((currentDefaultHeadPivotPosition.x))*widthToResizeBy, ((currentDefaultHeadPivotPosition.y)*heightToResizeBy));
        currentDefaultArmPivotPosition.setLocation(((currentDefaultArmPivotPosition.x))*widthToResizeBy, ((currentDefaultArmPivotPosition.y)*heightToResizeBy));
        currentDefaultArmPosition.setLocation(((currentDefaultArmPosition.x))*widthToResizeBy, ((currentDefaultArmPosition.y)*heightToResizeBy));
        currentDefaultLegPivotPosition.setLocation(((currentDefaultLegPivotPosition.x))*widthToResizeBy, ((currentDefaultLegPivotPosition.y)*heightToResizeBy));
        currentDefaultLegPosition.setLocation(((currentDefaultLegPosition.x))*widthToResizeBy, ((currentDefaultLegPosition.y)*heightToResizeBy));
        
        head.setWidth((head.getWidth())*widthToResizeBy);
        head.setHeight((head.getHeight())*heightToResizeBy);
        
        frontArm.setWidth((frontArm.getWidth())*widthToResizeBy);
        frontArm.setHeight((frontArm.getHeight())*heightToResizeBy);
        
        backArm.setWidth((backArm.getWidth())*widthToResizeBy);
        backArm.setHeight((backArm.getHeight())*heightToResizeBy);
        
        frontLeg.setWidth((frontLeg.getWidth())*widthToResizeBy);
        frontLeg.setHeight((frontLeg.getHeight())*heightToResizeBy);
        
        backLeg.setWidth((backLeg.getWidth())*widthToResizeBy);
        backLeg.setHeight((backLeg.getHeight())*heightToResizeBy);
        
        setHealthOffSet((int)(head.getHeight()+10));
    }

    @Override
    public void update(ArrayList<Entity> entitys, int tickSpeed) {
        super.update(entitys, tickSpeed);
        
        head.setX(getX()+currentDefaultHeadPosition.x);
        head.setY(getY()+currentDefaultHeadPosition.y);
        head.setPivot(new Point2D.Double(getX()+currentDefaultHeadPivotPosition.x, getY()+currentDefaultHeadPivotPosition.y));
        
        frontArm.setX(getX()+currentDefaultArmPosition.x);
        frontArm.setY(getY()+currentDefaultArmPosition.y);
        frontArm.setPivot(new Point2D.Double(getX()+currentDefaultArmPivotPosition.x, getY()+currentDefaultArmPivotPosition.y));
        
        backArm.setX(getX()+currentDefaultArmPosition.x);
        backArm.setY(getY()+currentDefaultArmPosition.y);
        backArm.setPivot(new Point2D.Double(getX()+currentDefaultArmPivotPosition.x, getY()+currentDefaultArmPivotPosition.y));
        
        frontLeg.setX(getX()+currentDefaultLegPosition.x);
        frontLeg.setY(getY()+currentDefaultLegPosition.y);
        frontLeg.setPivot(new Point2D.Double(getX()+currentDefaultLegPivotPosition.x, getY()+currentDefaultLegPivotPosition.y));
        
        backLeg.setX(getX()+currentDefaultLegPosition.x);
        backLeg.setY(getY()+currentDefaultLegPosition.y);
        backLeg.setPivot(new Point2D.Double(getX()+currentDefaultLegPivotPosition.x, getY()+currentDefaultLegPivotPosition.y));
        if(isMoving()){
            frontArmAnimation.update(false, (int)(getSpeed()));
            backArmAnimation.update(true, (int)(getSpeed()));
            frontLegAnimation.update(false, (int)(getSpeed()));
            backLegAnimation.update(true, (int)(getSpeed()));
        }
    }

    @Override
    public void render(Graphics2D gd) {
        Graphics2D gd2 = (Graphics2D)gd.create();
        
        if(isLookingLeft()){
            backArm.setInverse(true);
            backLeg.setInverse(true);
            frontArm.setInverse(true);
            frontLeg.setInverse(true);
            setInverse(true);
        }
        if(!isLookingLeft()){
            backArm.setInverse(false);
            backLeg.setInverse(false);
            frontArm.setInverse(false);
            frontLeg.setInverse(false);
            setInverse(false);
        }
        
        if(animateBackArm){
            if(isMoving()){
                backArmAnimation.render(gd2, backArm, true);
            }
        }
        if(renderBackArm){
            backArm.render(gd2);
        }
        
        gd2 = (Graphics2D)gd.create();
        if(animateBackLeg){
            if(isMoving()){
                backLegAnimation.render(gd2, backLeg, true);
            }
        }
        if(renderBackLeg){
            backLeg.render(gd2);
        }
        
        gd2 = (Graphics2D)gd.create();
        if(animateFrontLeg){
            if(isMoving()){
                frontLegAnimation.render(gd2, frontLeg, false);
            }
        }
        if(renderFrontLeg){
            frontLeg.render(gd2);
        }
        
        super.render(gd);
        
        gd2 = (Graphics2D)gd.create();
        if(animateFrontArm){
            if(isMoving()){
                frontArmAnimation.render(gd2, frontArm, false);
            }
        }
        if(renderFrontArm){
            frontArm.render(gd2);
        }
        
        gd2 = (Graphics2D)gd.create();
        gd2.rotate(angle, head.getPivot().x, head.getPivot().y);
        ((Head)(head)).setInverse(false);
        lookingLeft = false;
        double angleToCheck = Math.toDegrees(angle);
        if(angleToCheck < -90 || angleToCheck > 90){
            lookingLeft = true;
            ((Head)(head)).setInverse(true);
        }
        head.render(gd2);        
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Limb getFrontArm() {
        return frontArm;
    }

    public void setFrontArm(Limb frontArm) {
        this.frontArm = frontArm;
    }

    public Limb getBackArm() {
        return backArm;
    }

    public void setBackArm(Limb backArm) {
        this.backArm = backArm;
    }

    public Limb getFrontLeg() {
        return frontLeg;
    }

    public void setFrontLeg(Limb frontLeg) {
        this.frontLeg = frontLeg;
    }

    public Limb getBackLeg() {
        return backLeg;
    }

    public void setBackLeg(Limb backLeg) {
        this.backLeg = backLeg;
    }

    public Limb getHead() {
        return head;
    }

    public void setHead(Limb head) {
        this.head = head;
    }

    public boolean isAnimateFrontArm() {
        return animateFrontArm;
    }

    public void setAnimateFrontArm(boolean animateFrontArm) {
        this.animateFrontArm = animateFrontArm;
    }

    public boolean isAnimateBackArm() {
        return animateBackArm;
    }

    public void setAnimateBackArm(boolean animateBackArm) {
        this.animateBackArm = animateBackArm;
    }

    public boolean isAnimateFrontLeg() {
        return animateFrontLeg;
    }

    public void setAnimateFrontLeg(boolean animateFrontLeg) {
        this.animateFrontLeg = animateFrontLeg;
    }

    public boolean isAnimateBackLeg() {
        return animateBackLeg;
    }

    public void setAnimateBackLeg(boolean animateBackLeg) {
        this.animateBackLeg = animateBackLeg;
    }

    public AbstractAnimation getFrontArmAnimation() {
        return frontArmAnimation;
    }

    public void setFrontArmAnimation(AbstractAnimation frontArmAnimation) {
        this.frontArmAnimation = frontArmAnimation;
    }

    public AbstractAnimation getBackArmAnimation() {
        return backArmAnimation;
    }

    public void setBackArmAnimation(AbstractAnimation backArmAnimation) {
        this.backArmAnimation = backArmAnimation;
    }

    public AbstractAnimation getFrontLegAnimation() {
        return frontLegAnimation;
    }

    public void setFrontLegAnimation(AbstractAnimation frontLegAnimation) {
        this.frontLegAnimation = frontLegAnimation;
    }

    public AbstractAnimation getBackLegAnimation() {
        return backLegAnimation;
    }

    public void setBackLegAnimation(AbstractAnimation backLegAnimation) {
        this.backLegAnimation = backLegAnimation;
    }

    public boolean isLookingLeft() {
        return lookingLeft;
    }

    public void setLookingLeft(boolean lookingLeft) {
        this.lookingLeft = lookingLeft;
    }

    public boolean isRenderFrontArm() {
        return renderFrontArm;
    }

    public void setRenderFrontArm(boolean renderFrontArm) {
        this.renderFrontArm = renderFrontArm;
    }

    public boolean isRenderBackArm() {
        return renderBackArm;
    }

    public void setRenderBackArm(boolean renderBackArm) {
        this.renderBackArm = renderBackArm;
    }

    public boolean isRenderFrontLeg() {
        return renderFrontLeg;
    }

    public void setRenderFrontLeg(boolean renderFrontLeg) {
        this.renderFrontLeg = renderFrontLeg;
    }

    public boolean isRenderBackLeg() {
        return renderBackLeg;
    }

    public void setRenderBackLeg(boolean renderBackLeg) {
        this.renderBackLeg = renderBackLeg;
    }

    public Point2D.Double getAnglePoint() {
        return anglePoint;
    }

    public void setAnglePoint(Point2D.Double anglePoint) {
        this.anglePoint = anglePoint;
    }
    
    
    
}
