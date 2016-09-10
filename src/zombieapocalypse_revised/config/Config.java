/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.config;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import zombieapocalypse_revised.APanel;
import zombieapocalypse_revised.viewer.MainFrame;

/**
 *
 * @author Alan Tsui
 */
public class Config {
    public static final String VERSION = Version.getVersion();
            
    public static final Dimension DEFAULT_FRAME_SIZE = new Dimension(1920,1080);
    
    public static final Dimension MINIMUM_FRAME_SIZE = new Dimension(640,360);
    
    public static final String CREATOR = "Alan Tsui";
    
    public static final String COMPANY = "Bearian Inc.";
    
    public static final String YEAR = "2016";
    
    public static final String GAME_TITLE = "Zombie Apocalypse";
    
    private Config(){}
    
    public static Settings getDefaultSettings(){
        return new Settings();
    }
    
    public static void makeFrameFullScreen(MainFrame frame){
            
        GraphicsDevice gd =
            GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();


        if (gd.isFullScreenSupported()) {
            Dimension previousDimensions = frame.getPreviousDimensions();
            APanel currentPanel = frame.getCurrentPanel();

            frame.dispose();
            frame = new MainFrame();
            frame.setPreviousDimensions(previousDimensions);

            frame.setTitle(Config.GAME_TITLE);
            frame.changePanel(currentPanel);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(true);

            frame.setUndecorated(true);
            gd.setFullScreenWindow(frame);
            
            frame.setVisible(true);
        } else {
            System.err.println("Full screen not supported");
        }
        
    }
    
    public static void turnOffFullScreen(MainFrame frame){
            
        GraphicsDevice gd =
            GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();


        if (gd.isFullScreenSupported()) {
            Dimension previousDimensions = frame.getPreviousDimensions();
            APanel currentPanel = frame.getCurrentPanel();

            frame.dispose();
            frame = new MainFrame();
            frame.setPreviousDimensions(previousDimensions);

            gd.setFullScreenWindow(null);
            
            frame.setTitle(Config.GAME_TITLE);
            frame.changePanel(currentPanel);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(true);
            frame.setPreferredSize(frame.getPreviousDimensions());

            frame.pack();
            frame.setLocationRelativeTo(null);

            frame.setVisible(true);
        }
    }
}
