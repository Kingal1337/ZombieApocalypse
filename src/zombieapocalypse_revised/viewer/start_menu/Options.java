/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.viewer.start_menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import zombieapocalypse_revised.APanel;

/**
 *
 * @author Alan Tsui
 */
public class Options extends APanel{
    private JButton back;
    private JButton sound;
    private JButton graphics;
    private JButton controls;
    public Options(){
        back = new JButton("Back");
        sound = new JButton("Sound");
        graphics = new JButton("Graphics");
        controls = new JButton("Controls");
        
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });
        
        sound.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });
        
        graphics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });
        
        controls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });
        
        add(sound);
        add(graphics);
        add(controls);
    }
}
