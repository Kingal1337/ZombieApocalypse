/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.viewer;

import alanutilites.timer.Timer;
import zombieapocalypse_revised.APanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import zombieapocalypse_revised.config.Config;

/**
 *
 * @author Alan Tsui
 */
public class MainFrame extends JFrame implements ComponentListener, ActionListener{
    private Timer timer;
    private Dimension previousDimensions;
    private APanel currentPanel;
    public MainFrame(){
        currentPanel = null;
        addComponentListener(this);
        init();
    }
    
    public MainFrame(APanel panel){
        currentPanel = panel;
        init();
    }
    
    private void init(){
        addComponentListener(this);
        previousDimensions = Config.MINIMUM_FRAME_SIZE;
    }
    
    public void changePanel(APanel panel){
        if(currentPanel != null){
            remove(currentPanel);
            revalidate();
            repaint();
        }
        currentPanel = panel;
        add(currentPanel);
        revalidate();
        repaint();
    }
    
    @Override
    public void componentResized(ComponentEvent e) {
        if(currentPanel != null){
            Dimension dimensions = getContentPane().getSize();
            currentPanel.resizePanel(previousDimensions, dimensions);
            previousDimensions = new Dimension(dimensions);
        }
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        
    }

    @Override
    public void componentShown(ComponentEvent e) {
        
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        
    }

    public Dimension getPreviousDimensions() {
        return previousDimensions;
    }

    public void setPreviousDimensions(Dimension previousDimensions) {
        this.previousDimensions = previousDimensions;
    }

    public APanel getCurrentPanel() {
        return currentPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}