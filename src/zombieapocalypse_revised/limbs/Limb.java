/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.limbs;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import javax.swing.ImageIcon;

/**
 *
 * @author Alan Tsui
 */
public abstract class Limb {
    private double x;
    private double y;
    private double width;
    private double height;
    private ImageIcon image;
    private Point2D.Double pivot;
    private double idleAngle;
    private boolean inverse;

    public Limb(double x, double y, double width, double height, double idleAngle, ImageIcon image, Point2D.Double pivot) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
        this.pivot = pivot;
        this.idleAngle = idleAngle;
    }
    
    public Limb(Limb limb){
        this.x = limb.x;
        this.y = limb.y;
        this.width = limb.width;
        this.height = limb.height;
        this.image = limb.image;
        this.pivot = limb.pivot;
        this.idleAngle = limb.idleAngle;
        this.inverse = limb.inverse;
    }
    
    public abstract Limb copy();
    
    public abstract void render(Graphics2D gd);

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public Point2D.Double getPivot() {
        return pivot;
    }

    public void setPivot(Point2D.Double pivot) {
        this.pivot = pivot;
    }

    public double getIdleAngle() {
        return idleAngle;
    }

    public void setIdleAngle(double idleAngle) {
        this.idleAngle = idleAngle;
    }

    public boolean isInverse() {
        return inverse;
    }

    public void setInverse(boolean inverse) {
        this.inverse = inverse;
    }
}
