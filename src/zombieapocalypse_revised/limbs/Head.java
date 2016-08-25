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
public class Head extends Limb{
    public Head(double x, double y, double width, double height, double idleAngle, ImageIcon image, Point2D.Double pivot) {
        super(x, y, width, height, idleAngle, image, pivot);
    }
    
    public Head(Head head){
        super(head);
    }
    
    @Override
    public Limb copy(){
        return new Head(this);
    }


    @Override
    public void render(Graphics2D gd) {
        if(getImage() != null){
            if(isInverse()){
                gd.drawImage(getImage().getImage(), (int)(getX()), (int)(getY() + getHeight()), (int)(getWidth()), (int)(-getHeight()), null);
            }
            else{
                gd.drawImage(getImage().getImage(), (int)(getX()), (int)(getY()), (int)(getWidth()), (int)(getHeight()), null);
            }
        }
        else{
            gd.fillRect((int)(getX()), (int)(getY()), (int)(getWidth()), (int)(getHeight()));
        }
        
    }

}
