/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.entitys;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Alan Tsui
 */
public class ImageEntity extends Entity{
    private ImageIcon icon;
    public ImageEntity(int x, int y, int width, int height, boolean passable, ImageIcon icon) {
        super(x, y, width, height, passable);
        this.icon = icon;
    }
    
    public ImageEntity(ImageEntity entity){
        super(entity);
        this.icon = entity.icon;
    }
    
    @Override
    public Entity copy(){
        return new ImageEntity(this);
    }
    
    @Override
    public void update(ArrayList<Entity> entitys, int tickSpeed){
        super.update(entitys, tickSpeed);
    }  

    @Override
    public void resize(double widthToResizeBy, double heightToResizeBy, Dimension dimension) {
        super.resize(widthToResizeBy, heightToResizeBy, dimension);
    }
    
    @Override
    public void render(Graphics2D gd){
        if(icon != null){
            if(isInverse()){
                gd.drawImage(icon.getImage(), (int)(getX()+getWidth()), (int)(getY()), (int)(-getWidth()), (int)(getHitBoxHeight()), null);
            }
            else{
                gd.drawImage(icon.getImage(), (int)(getX()), (int)(getY()), (int)(getWidth()), (int)(getHitBoxHeight()), null);
            }
        }
        else{
            super.render(gd);
        }
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

}
