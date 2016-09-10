/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.entitys;

import alanutilites.util.random.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Alan Tsui
 */
public class DamagableEntity extends ImageEntity{
    private static ArrayList<Color> healthBarColors;
    private static boolean initialized;
    
    private int healthOffSet;
    
    private boolean damagable;
    
    private double health;
    private double maxHealth;
    private double armor;
    
    /**
     * Creates a DamageableEntity
     * @param x  the initial x position
     * @param y  the initial y position
     * @param width  the width of the entity
     * @param height  the height of the entity
     * @param passable  if other entitys are allow to pass through this entity
     * @param health  the initial health
     * @param maxHealth  the max health
     * @param armor  the armor (0.00 - 1.00) 0 being no armor and 1 being full armor
     * @param image  the image
     */
    public DamagableEntity(String name, int x, int y, int width, int height, boolean passable, double health, double maxHealth, double armor, ImageIcon image) {
        super(name, x, y, width, height, passable, image);
        this.health = health;
        this.maxHealth = maxHealth;
        this.armor = armor < 0 ? 0 : armor > 1 ? 1 : armor;
        healthOffSet = 10;
        damagable = true;
        initColors();
    }
    
    public DamagableEntity(DamagableEntity entity) {
        super(entity);
        this.damagable = entity.damagable;

        this.health = entity.health;
        this.maxHealth = entity.maxHealth;
        this.armor = entity.armor;
        this.healthOffSet = entity.healthOffSet;
        
        initColors();
    }
    
    @Override
    public Entity copy(){
        return new DamagableEntity(this);
    }

    @Override
    public void resize(double widthToResizeBy, double heightToResizeBy, Dimension dimension) {
        super.resize(widthToResizeBy, heightToResizeBy, dimension);
    }    
    
    private static void initColors(){
        if(!initialized){
            initialized = true;
            healthBarColors = new ArrayList<>();
            
            int red = 255;
            int green = 0;
            int stepSize = 15;
            while(green < 255)
            {
                green += stepSize;
                if(green > 255) { green = 255; }
                healthBarColors.add(new Color(red, green, 0));
            }
            while(red > 0)
            {
                red -= stepSize;
                if(red < 0) { red = 0; }
                healthBarColors.add(new Color(red, green, 0));
            }
        }
    }

    @Override
    public void update(ArrayList<Entity> entitys, int tickSpeed) {
        super.update(entitys, tickSpeed);
        if(isDead()){
            setRemove(true);
        }
    }

    @Override
    public void render(Graphics2D gd) {
        super.render(gd);
        if(damagable){
            int healthOffSet = (int) (getY()-this.healthOffSet);
            double maxSize = getWidth();
            int heightOfBar = 3;
            double healthRatio = health/maxHealth;

            double hpBarSize = healthRatio*maxSize;
            
            Color prevColor = gd.getColor();
            gd.setColor(getCurrentHeathColor(health, maxHealth));
            gd.fillRect((int)getX(), (int)healthOffSet, (int)hpBarSize, (int)heightOfBar);
            gd.setColor(prevColor);
        }
    }
    
    public Color getCurrentHeathColor(double currentHealth, double maxHealth){
        int arraySize = healthBarColors.size();
        int index = (int)(arraySize/maxHealth*currentHealth);
        index = index >= arraySize ? arraySize-1 : index < 0 ? 0 : index;
        return healthBarColors.get(index);
    }
    
    /**
     * Tells if the entity is dead or not
     * @return  returns true if the entity is dead, otherwise returns false
     */
    public boolean isDead(){
        return health <= 0;
    }
    
    /**
     * Does a certain amount of damage to the entity
     * if the entity has armor
     * if the health goes below 0 sets health to 0
     * @param damage  the damage the entity has to take
     * @return  returns if the entity is dead or not
     */
    public boolean takeDamage(double damage){
        if(damagable){
            double randomNumber = (double)Random.randomNumber(0, (int)(armor*100.0));
            double damageToTake = randomNumber/100.0;
//            System.out.println(randomNumber+" "+damageToTake);
            health -= damage-(damage*damageToTake);
            if(health < 0){
                health = 0;
            }
        }
        return isDead();
    }
    
    /**
     * Heals the entity to full health
     */
    public void reheal(){
        health = maxHealth;
    }
    
    /**
     * Restores a certain amount of health to the entity
     * @param health  the amount of health to restore
     */
    public void restoreHealth(double health){
        this.health += health;
        if(this.health > maxHealth){
            this.health = maxHealth;
        }
    }
    
    public void setDamagable(boolean damagable){
        this.damagable = damagable;
    }

    public boolean isDamagable() {
        return damagable;
    }

    public int getHealthOffSet() {
        return healthOffSet;
    }

    public void setHealthOffSet(int healthOffSet) {
        this.healthOffSet = healthOffSet;
    }

    public double getHealth() {
        return health;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public double getArmor() {
        return armor;
    }
    
}
