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
public class Arm extends Limb{

    public Arm(double x, double y, double width, double height, double idleAngle, ImageIcon image, Point2D.Double pivot) {
        super(x, y, width, height, idleAngle, image, pivot);
    }
    
    public Arm(Arm arm){
        super(arm);
    }
    
    @Override
    public Limb copy(){
        return new Arm(this);
    }

    @Override
    public void render(Graphics2D gd) {
        Graphics2D g2d = (Graphics2D)gd.create();
        g2d.rotate(Math.toRadians(getIdleAngle()), getPivot().x, getPivot().y);
        if(getImage() != null){
            if(isInverse()){
                g2d.drawImage(getImage().getImage(), (int)(getX()+getWidth()), (int)(getY()), (int)(-getWidth()), (int)(getHeight()), null);
            }
            else{                
                g2d.drawImage(getImage().getImage(), (int)(getX()), (int)(getY()), (int)(getWidth()), (int)(getHeight()), null);
            }
        }
        else{
            g2d.fillRect((int)(getX()), (int)(getY()), (int)(getWidth()), (int)(getHeight()));
        }
    }

}
