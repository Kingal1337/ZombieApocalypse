/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.animations;

import java.awt.Graphics2D;
import zombieapocalypse_revised.limbs.Limb;

/**
 *
 * @author Alan Tsui
 */
public interface Animation {
    public void update(boolean invert, int speed);
    public void render(Graphics2D gd, Limb limb, boolean invert);
}
