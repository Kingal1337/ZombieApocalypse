/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised;

import java.util.ArrayList;
import zombieapocalypse_revised.entitys.Entity;

/**
 *
 * @author Alan Tsui
 */
public interface Updater {
    public void update(ArrayList<Entity> entitys, int tickSpeed);
}
