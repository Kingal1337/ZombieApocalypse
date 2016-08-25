/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.entitys.skins;

import javax.swing.ImageIcon;
import zombieapocalypse_revised.entitys.HumanLookingEntity;

/**
 *
 * @author Alan Tsui
 */
public class Skin {
    public static final Skin BEARIE_JUNIOR = new Skin(
            new ImageIcon(Skin.class.getResource("/zombieapocalypse_revised/config/resources/skins/bearie_junior/Bearie_Juniors_Head.png")),
            new ImageIcon(Skin.class.getResource("/zombieapocalypse_revised/config/resources/skins/bearie_junior/Bearie_Juniors_Body.png")),
            new ImageIcon(Skin.class.getResource("/zombieapocalypse_revised/config/resources/skins/bearie_junior/Bearie_Juniors_Arm.png")),
            new ImageIcon(Skin.class.getResource("/zombieapocalypse_revised/config/resources/skins/bearie_junior/Bearie_Juniors_Leg.png")));
    
    public static final Skin GREG = new Skin(
            new ImageIcon(Skin.class.getResource("/zombieapocalypse_revised/config/resources/skins/greg/Greg_Head.png")),
            new ImageIcon(Skin.class.getResource("/zombieapocalypse_revised/config/resources/skins/greg/Greg_Body.png")),
            new ImageIcon(Skin.class.getResource("/zombieapocalypse_revised/config/resources/skins/greg/Greg_Arm.png")),
            new ImageIcon(Skin.class.getResource("/zombieapocalypse_revised/config/resources/skins/greg/Greg_Leg.png")));
    
    public static final Skin CARL = new Skin(
            new ImageIcon(Skin.class.getResource("/zombieapocalypse_revised/config/resources/skins/carl/Carl_Head.png")),
            new ImageIcon(Skin.class.getResource("/zombieapocalypse_revised/config/resources/skins/carl/Carl_Body.png")),
            new ImageIcon(Skin.class.getResource("/zombieapocalypse_revised/config/resources/skins/carl/Carl_Arm.png")),
            new ImageIcon(Skin.class.getResource("/zombieapocalypse_revised/config/resources/skins/carl/Carl_Leg.png")));
    
    private ImageIcon head;
    private ImageIcon body;
    private ImageIcon arm;
    private ImageIcon leg;
    public Skin(ImageIcon head, ImageIcon body, ImageIcon arm, ImageIcon leg){
        this.head = head;
        this.body = body;
        this.arm = arm;
        this.leg = leg;
    }
    
    public void applySkin(HumanLookingEntity player){
        player.getHead().setImage(head);
        
        player.setIcon(body);
        
        player.getFrontArm().setImage(arm);
        player.getBackArm().setImage(arm);
        
        player.getFrontLeg().setImage(leg);
        player.getBackLeg().setImage(leg);
    }

    public ImageIcon getHead() {
        return head;
    }

    public void setHead(ImageIcon head) {
        this.head = head;
    }

    public ImageIcon getBody() {
        return body;
    }

    public void setBody(ImageIcon body) {
        this.body = body;
    }

    public ImageIcon getArm() {
        return arm;
    }

    public void setArm(ImageIcon arm) {
        this.arm = arm;
    }

    public ImageIcon getLeg() {
        return leg;
    }

    public void setLeg(ImageIcon leg) {
        this.leg = leg;
    }
}
