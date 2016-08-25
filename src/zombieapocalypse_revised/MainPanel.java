/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised;

import alanutilites.timer.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import zombieapocalypse_revised.config.Config;
import zombieapocalypse_revised.config.Controls;
import zombieapocalypse_revised.entitys.Entity;
import zombieapocalypse_revised.entitys.Player;
import zombieapocalypse_revised.entitys.skins.Skin;

/**
 *
 * @author Alan Tsui
 */
public class MainPanel extends APanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener{
    private Timer timer;
    private Player player;
    private Controls controls;
    private ArrayList<Entity> entitys;
    
    private boolean changedWeapons;
    
    private boolean shoot;
    
    /*
        for fps
    */
    private int counter;
    private long ticks;
    private double fps;
    private long lastTime;
    private double fakeFPS;
    
    public ArrayList<Light> lights = new ArrayList<>();
    
    public MainPanel(Player player, Controls controls, ArrayList<Entity> entitys){
        this.player = player;
        this.entitys = entitys;
        this.controls = controls;
        
        changedWeapons = false;
        
        timer = new Timer(16, this);
        timer.start();
        counter = 1000;
        
        setBackground(Color.LIGHT_GRAY);
        
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        setFocusable(true);
        resizeComponents(new Dimension(1920,1080), Config.MINIMUM_FRAME_SIZE);
    }
    
    @Override
    public void resizeComponents(Dimension previousSize, Dimension newDimensions){
        double widthToResizeBy = (double)newDimensions.width/(double)previousSize.width;
        double heightToResizeBy = (double)newDimensions.height/(double)previousSize.height;
        
//        double widthToResizeBy = (double)newDimensions.width/(double)Config.MINIMUM_FRAME_SIZE.width;
//        double heightToResizeBy = (double)newDimensions.height/(double)Config.MINIMUM_FRAME_SIZE.height;

//        double widthToResizeBy = (double)Config.MINIMUM_FRAME_SIZE.width/(double)newDimensions.width;
//        double heightToResizeBy = (double)Config.MINIMUM_FRAME_SIZE.height/(double)newDimensions.height;

//        double widthToResizeBy = (double)previousSize.width/(double)newDimensions.width;
//        double heightToResizeBy = (double)previousSize.height/(double)newDimensions.height;
        
        for(int i=0;i<entitys.size();i++){
            entitys.get(i).resize(widthToResizeBy, heightToResizeBy, newDimensions);
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D gd = (Graphics2D)g;
        
        gd.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        gd.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
        for(int i=0;i<entitys.size();i++){
            entitys.get(i).render(gd);
        }
        player.render(gd);
        
        if(Config.showFPS){
            gd.setFont(new Font("Comic Sans MC", 1, 24));
            gd.drawString("FPS : "+(fps+"").substring(0, (fps+"").indexOf("."))+"; FPS set at : "+(1000/timer.getDelay()), 5, 30);
        }
//        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
//        Point point = pointerInfo.getLocation();
//        SwingUtilities.convertPointFromScreen(point, this);
//        double x = point.getX();
//        double y = point.getY();
//        gd.drawString("Mouse : "+point,5,60);
//        gd.drawString("Bullet : "+player.getHead().getPivot(),5,90);
//        gd.drawString("Angle : "+Math.toDegrees(Math.atan2(y - player.getHead().getPivot().getY() , x - player.getHead().getPivot().getX())), 5, 120);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ticks++;
        counter+=timer.getDelay();
        
        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        Point point = pointerInfo.getLocation();
        SwingUtilities.convertPointFromScreen(point, this);
        double x = point.getX();
        double y = point.getY();
        
        player.setAngle(Math.atan2(y - player.getHead().getPivot().getY(), x - player.getHead().getPivot().getX()));
        player.getAnglePoint().setLocation(point.x, point.y);
        
        for(int i=0;i<entitys.size();i++){
            entitys.get(i).update(entitys, timer.getDelay());
        }
        if(shoot){
            player.hit(entitys, timer.getDelay());
        }
        for(int i=entitys.size()-1;i>=0;i--){
            if(entitys.get(i).isRemove()){
                entitys.remove(i);
            }
        }
        
        repaint();
        
        fakeFPS = 1000000000.0 / (System.nanoTime() - lastTime);
        lastTime = System.nanoTime();
        if(counter >= 1000){
            counter = 0;
            fps = fakeFPS;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == controls.up){
            player.up = true;
        }
        if(key == controls.down){
            player.down = true;
        }
        if(key == controls.left){
            player.left = true;
        }
        if(key == controls.right){
            player.right = true;
        }
        if(key == controls.reload){
            player.reload();
        }
        if(key == controls.changeWeapons){
            if(!changedWeapons){
                changedWeapons = true;
                player.getWeaponSack().changeAndGetNextWeapon();
            }
        }
        if(key == controls.jump){
            player.jump = true;
        }
        if(key == controls.exit){
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == controls.up){
            player.up = false;
        }
        if(key == controls.down){
            player.down = false;
        }
        if(key == controls.left){
            player.left = false;
        }
        if(key == controls.right){
            player.right = false;
        }
        //remove if needed
//        if(key == controls.reload){
//            
//        }
        if(key == controls.changeWeapons){
            changedWeapons = false;
        }
        if(key == controls.jump){
            player.jump = false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        player.hit(entitys, timer.getDelay());
shoot = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        shoot = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }

    public long getTicks() {
        return ticks;
    }

    public double getFps() {
        return fps;
    }
}
