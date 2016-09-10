/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.viewer.huds;

import alanutilites.util.text.Text;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import zombieapocalypse_revised.entitys.Wielder;
import zombieapocalypse_revised.entitys.accessories.WeaponSack;
import zombieapocalypse_revised.weapons.ShootableWeapon;
import zombieapocalypse_revised.weapons.Weapon;

/**
 *
 * @author Alan Tsui
 */
public class DefaultHud extends Hud{    
    private Font font;
    
    private double currentHealthFontSize;
    private Rectangle2D.Double healthBarSize;
    private double borderThickness;
    
    private Rectangle2D.Double weaponBar;
    private Color selectedWeaponColor;
    private double currentWeaponNameFontSize;
    private double currentWeaponAmmoFontSize;
    
    public DefaultHud(){
        font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, DefaultHud.class.getResourceAsStream("/zombieapocalypse_revised/config/resources/fonts/casual_softcore.ttf"));
        } catch (FontFormatException ex) {
            Logger.getLogger(DefaultHud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DefaultHud.class.getName()).log(Level.SEVERE, null, ex);
        }
        healthBarSize = new Rectangle2D.Double(0, 0,640,30);        
        currentHealthFontSize = 25;
        
        borderThickness = 2;
        
        currentWeaponNameFontSize = 20;
        currentWeaponAmmoFontSize = 25;
        weaponBar = new Rectangle2D.Double(1280,0,640,60);
        selectedWeaponColor = Color.decode("#FFE986");
    }
    
    @Override
    public void resize(double widthToResizeBy, double heightToResizeBy, Dimension dimension) {
        healthBarSize.setRect(healthBarSize.getX()*widthToResizeBy, healthBarSize.getY()*heightToResizeBy, healthBarSize.getWidth()*widthToResizeBy, healthBarSize.getHeight()*heightToResizeBy);
        borderThickness = borderThickness*widthToResizeBy;
        currentHealthFontSize = currentHealthFontSize*widthToResizeBy;
        
        weaponBar.setRect(weaponBar.getX()*widthToResizeBy, weaponBar.getY()*heightToResizeBy, weaponBar.getWidth()*widthToResizeBy, weaponBar.getHeight()*heightToResizeBy);
        currentWeaponNameFontSize = currentWeaponNameFontSize*widthToResizeBy;
        currentWeaponAmmoFontSize = currentWeaponAmmoFontSize*widthToResizeBy;
    }

    @Override
    public void drawFPS(Graphics2D gd, double fps, double fpsSetAt, Dimension screenSize) {
        
    }

    @Override
    public void drawHealth(Graphics2D gd, Wielder wielder, Dimension screenSize) {
        gd.setColor(wielder.getCurrentHeathColor(wielder.getHealth(), wielder.getMaxHealth()));        
        double healthRatio = wielder.getHealth()/wielder.getMaxHealth();
        double hpBarSize = healthRatio*healthBarSize.width;
        gd.fillRect((int)healthBarSize.getX(), (int)healthBarSize.getY(), (int)hpBarSize, (int)healthBarSize.getHeight());
        
        gd.setColor(Color.BLACK);
        gd.setFont(font.deriveFont(0, (int)currentHealthFontSize));
        Text.drawCenteredString((""+wielder.getHealth()).substring(0,(wielder.getHealth()+"").indexOf(".")), (int)healthBarSize.getX(), (int)healthBarSize.getY(), (int)healthBarSize.getWidth(), (int)healthBarSize.getHeight(), gd);
        gd.setStroke(new BasicStroke((float)borderThickness));
        gd.draw(healthBarSize);
    }

    @Override
    public void drawWeapons(Graphics2D gd, WeaponSack sack, Dimension screenSize) {
        ArrayList<Weapon> weapons = sack.getWeapons();
        double x = weaponBar.getX();
        int currentWeaponIndex = sack.getCurrentWeaponIndex();
        double interval = weaponBar.getWidth()/weapons.size();
        for(int i=0;i<weapons.size();i++){
            Weapon weapon = weapons.get(i);
            if(currentWeaponIndex == i){
                gd.setColor(selectedWeaponColor);
                gd.fillRect((int)x, (int)weaponBar.getY(), (int)interval, (int)weaponBar.getHeight());
            }
            else{
                gd.setColor(Color.LIGHT_GRAY);
                gd.fillRect((int)x, (int)weaponBar.getY(), (int)interval, (int)weaponBar.getHeight());                
            }
            
            gd.setColor(Color.BLACK);
            gd.setFont(font.deriveFont(0, (int)currentWeaponNameFontSize));
            Text.drawCenteredString(weapon.getName(), (int)x, (int)(weaponBar.getY()+borderThickness), (int)interval, (int)(weaponBar.getHeight()/3), gd);
            
            if(weapon instanceof ShootableWeapon){
                ShootableWeapon shootableWeapon = (ShootableWeapon)weapon;
                gd.setFont(font.deriveFont(0, (int)currentWeaponAmmoFontSize));
                Text.drawCenteredString(shootableWeapon.getMag()+"/"+shootableWeapon.getClip(), (int)x, (int)(weaponBar.getY()+borderThickness+(weaponBar.getHeight()-(weaponBar.getHeight()/2))), (int)interval, (int)(weaponBar.getHeight()/3), gd);
            }
            
            gd.setColor(Color.BLACK);
            gd.setStroke(new BasicStroke((float)borderThickness));
            gd.drawRect((int)x, (int)weaponBar.getY(), (int)interval, (int)weaponBar.getHeight());
            x+=interval;
        }
        gd.setColor(Color.BLACK);
        gd.setStroke(new BasicStroke((float)borderThickness));
        gd.draw(weaponBar);
    }

    @Override
    public void drawAmmo(Graphics2D gd, Weapon currentWeapon, Dimension screenSize) {
        
    }
}
