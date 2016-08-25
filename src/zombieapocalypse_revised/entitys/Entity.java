/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.entitys;

import alanutilites.util.collision.CollisionBox2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import zombieapocalypse_revised.Renderer;
import zombieapocalypse_revised.Resizer;
import zombieapocalypse_revised.Updater;

/**
 *
 * @author Alan Tsui
 */
public class Entity extends CollisionBox2D implements Updater, Renderer, Resizer{
    private final Color DEFAULT_COLOR = Color.GRAY;
        
    private double hitBoxHeight;
    
    private Color color;
    
    private boolean inverse;
    
    /**
     * if true then this entity will be removed in the next tick
     * else nothing happens;
     */
    private boolean remove;
    
    /**
     * Creates an Entity
     * @param x  the initial x position
     * @param y  the initial y position
     * @param width  the width of the entity
     * @param height  the height of the entity
     * @param passable  if other entitys are allow to pass through this entity
     */
    public Entity(int x, int y, int width, int height, boolean passable) {
        super(x, y, width, height, passable);
        hitBoxHeight = height;
        color = DEFAULT_COLOR;
        remove = false;
    }
    
    public Entity(Entity entity){
        super(entity);
        hitBoxHeight = entity.hitBoxHeight;
        color = entity.color;
        remove = entity.remove;
        inverse = entity.inverse;
    }
    
    @Override
    public Entity copy(){
        return new Entity(this);
    }
    
    @Override
    public void update(ArrayList<Entity> entitys, int tickSpeed){
        
    }
    
    @Override
    public void render(Graphics2D gd){
        Color ogColor = gd.getColor();
        gd.setColor(color);
        gd.fillRect(getX2D(), (int)getY(), getWidth2D(), (int)getHitBoxHeight());
        gd.drawRect(getX2D(), getY2D(), getWidth2D(), getHeight2D());
        gd.setColor(ogColor);
    }
    
    @Override
    public void resize(double widthToResizeBy, double heightToResizeBy, Dimension dimension){
        setX(getX()*widthToResizeBy);
        setY(getY()*heightToResizeBy);
        setWidth(getWidth()*widthToResizeBy);
        setHeight(getHeight()*heightToResizeBy);
        setHitBoxHeight(getHitBoxHeight()*heightToResizeBy);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isRemove() {
        return remove;
    }

    public void setRemove(boolean remove) {
        this.remove = remove;
    }

    public boolean isInverse() {
        return inverse;
    }

    public void setInverse(boolean inverse) {
        this.inverse = inverse;
    }

    public double getHitBoxHeight() {
        return hitBoxHeight;
    }

    public void setHitBoxHeight(double hitBoxHeight) {
        this.hitBoxHeight = hitBoxHeight;
    }
}
