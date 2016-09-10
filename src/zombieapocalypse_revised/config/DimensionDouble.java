/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.config;

/**
 *
 * @author Alan Tsui
 */
public class DimensionDouble {
    private double width;
    private double height;
    public DimensionDouble(double width, double height){
        this.width = width;
        this.height = height;
    }
    
    public DimensionDouble(DimensionDouble dimension){
        this.width = dimension.width;
        this.height = dimension.height;
    }
    
    public void setSize(double w, double h){
        width = w;
        height = h;
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
}
