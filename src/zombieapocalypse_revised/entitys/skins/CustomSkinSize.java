/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.entitys.skins;

import java.awt.Dimension;
import java.awt.Point;

/**
 *
 * @author Alan Tsui
 */
public class CustomSkinSize {    
    public Dimension defaultHeadSize;
    public Dimension defaultArmSize;
    public Dimension defaultLegSize;
    public Dimension defaultBodySize;
    public Point defaultHeadPosition;
    public Point defaultHeadPivotPosition;
    public Point defaultArmPivotPosition;
    public Point defaultArmPosition;
    public Point defaultLegPivotPosition;
    public Point defaultLegPosition;

    public CustomSkinSize(Dimension defaultHeadSize, Dimension defaultArmSize, Dimension defaultLegSize, Dimension defaultBodySize, Point defaultHeadPosition, Point defaultHeadPivotPosition, Point defaultArmPivotPosition, Point defaultArmPosition, Point defaultLegPivotPosition, Point defaultLegPosition) {
        this.defaultHeadSize = defaultHeadSize;
        this.defaultArmSize = defaultArmSize;
        this.defaultLegSize = defaultLegSize;
        this.defaultBodySize = defaultBodySize;
        this.defaultHeadPosition = defaultHeadPosition;
        this.defaultHeadPivotPosition = defaultHeadPivotPosition;
        this.defaultArmPivotPosition = defaultArmPivotPosition;
        this.defaultArmPosition = defaultArmPosition;
        this.defaultLegPivotPosition = defaultLegPivotPosition;
        this.defaultLegPosition = defaultLegPosition;
    }
    
}
