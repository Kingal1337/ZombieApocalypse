/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.entitys.accessories;

import java.util.ArrayList;
import zombieapocalypse_revised.weapons.Weapon;

/**
 *
 * @author Alan Tsui
 */
public class WeaponSack {
    private ArrayList<Weapon> weapons;
    private int currentWeapon;
    
    public WeaponSack(){
        weapons = new ArrayList<>();
        weapons.add(Weapon.FIST.copy());
        currentWeapon = 0;
    }
    
    public WeaponSack(ArrayList<Weapon> weapons){
        this.weapons = new ArrayList<>();
        for(int i=0;i<weapons.size();i++){
            this.weapons.add(weapons.get(i).copy());
        }
        if(!this.weapons.contains(Weapon.FIST)){
            this.weapons.add(0, Weapon.FIST.copy());
        }
        currentWeapon = 0;
    }
    
    public WeaponSack(WeaponSack sack){
        weapons = new ArrayList<>();
        for(int i=0;i<sack.weapons.size();i++){
            weapons.add(sack.weapons.get(i).copy());
        }
        this.currentWeapon = sack.currentWeapon;
    }
    
    public WeaponSack copy(){
        return new WeaponSack(this);
    }
    
    public Weapon changeAndGetNextWeapon(){
        if(weapons.isEmpty()){
            return null;
        }
        changeToNextWeapon();
        return weapons.get(currentWeapon);
    }
    
    public Weapon changeAndGetPreviousWeapon(){
        if(weapons.isEmpty()){
            return null;
        }
        changeToPreviousWeapon();
        return weapons.get(currentWeapon);
    }
    
    public void changeToNextWeapon(){
        if(weapons.isEmpty()){
            return;
        }
        currentWeapon++;
        if(currentWeapon >= weapons.size()){
            currentWeapon = 0;
        }
    }
    
    public void changeToPreviousWeapon(){
        if(weapons.isEmpty()){
            return;
        }
        currentWeapon--;
        if(currentWeapon < 0){
            currentWeapon = weapons.size()-1;
        }
    }
    
    public Weapon getNextWeapon(){
        if(weapons.isEmpty()){
            return null;
        }
        int tempWeapon = currentWeapon;
        tempWeapon++;
        if(tempWeapon >= weapons.size()){
            tempWeapon = 0;
        }
        return weapons.get(tempWeapon);
    }
    
    public Weapon getPreviousWeapon(){
        if(weapons.isEmpty()){
            return null;
        }
        int tempWeapon = currentWeapon;
        tempWeapon--;
        if(tempWeapon < 0){
            tempWeapon = weapons.size()-1;
        }
        return weapons.get(tempWeapon);
    }
    
    public Weapon getCurrentWeapon(){
        return weapons.get(currentWeapon);
    }
    
    public Weapon getWeapon(int weaponIndex){
       return weaponIndex >= 0 && weaponIndex < weapons.size() ? weapons.get(currentWeapon = weaponIndex) : null; 
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }
    
    public int size(){
        return weapons.size();
    }
}
