/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Alan Tsui
 */
public class AnimationTest extends JPanel implements ActionListener, KeyListener{
    public static void main(String[] args){
        AnimationTest test = new AnimationTest();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,500));
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.add(test);
        frame.setVisible(true);
    }
    
    private Rectangle arm;
    private Point pivot;
    private int from;
    private int to;
    private int interval;
    private int current;
    private int idleState;
    private boolean idle;
    
    private boolean left;
    private boolean right;
    
    private Timer timer;
    public AnimationTest(){
        arm = new Rectangle(150+10,150+15,30, 70);
        pivot = new Point(150+25, 150+15);
        from = 150;
        to = 360;
        interval = 15;
        current = from;
        
        timer = new Timer(20, this);
        timer.start();
        
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gd = (Graphics2D)g;
        
        gd.setColor(Color.BLACK);
        gd.fillRect(150, 150, 50, 100);
        
        gd.setColor(Color.GREEN);
        gd.drawRect(140, 150-55, 70, 70);
        
        gd.setColor(Color.PINK);
        gd.fillRect(150+10, 150+80, 30,70);
//        gd.fillRect(pivot.x, pivot.y,1,1);
        gd.rotate(Math.toRadians(-current),pivot.x, pivot.y);
        gd.setColor(Color.BLUE);
        gd.fill(arm);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        current += interval;
        if(current > to || current < from){
            interval = -interval;
        }
        System.out.println("Current : "+current+" Interval : "+interval);
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_D){
            right = true;
        }
        if(key == KeyEvent.VK_A){
            left = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_D){
            right = false;
        }
        if(key == KeyEvent.VK_A){
            left = false;
        }
    }
}
