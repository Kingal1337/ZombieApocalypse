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
public class Settings {
    public static final boolean SHOW_FPS = true;
    public static final boolean ENABLE_ANTI_ALIASING = true;
    public static final boolean ENABLE_FULLSCREEN = false;
    private static final Controls CONTROLS = new Controls();
    
    public boolean showFPS;
    public boolean enableAntiAliasing;
    public boolean enableFullScreen;
    public Controls controls;
    public Settings(){
        reset();
    }
    
    public Settings(Settings settings){
        this.showFPS = settings.showFPS;
        this.enableAntiAliasing = settings.enableAntiAliasing;
        this.enableFullScreen = settings.enableFullScreen;
        this.controls = new Controls(settings.controls);
    }
    
    public Settings copy(){
        return new Settings(this);
    }
    
    public void reset(){
        showFPS = SHOW_FPS;
        enableAntiAliasing = ENABLE_ANTI_ALIASING;
        enableFullScreen = ENABLE_FULLSCREEN;
        controls = CONTROLS.copy();
    }
}
