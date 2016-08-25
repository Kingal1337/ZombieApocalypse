/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.viewer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Alan Tsui
 */
public class Test extends JPanel implements ActionListener{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Test test = new Test();
        
        frame.add(test);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800,600));
        frame.setResizable(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private Timer timer;
    private ArrayList<Color> colors;
    private int max = 100;
    private int current = 0;
    private int counter = 1;
    
    public Test(){
        setBackground(Color.BLACK);
            colors = new ArrayList<>();
            
            int red = 255;
            int green = 0;
            int stepSize = 15;
            while(green < 255)
            {
                green += stepSize;
                if(green > 255) { green = 255; }
                colors.add(new Color(red, green, 0));
            }
            while(red > 0)
            {
                red -= stepSize;
                if(red < 0) { red = 0; }
                colors.add(new Color(red, green, 0));
            }
        timer = new Timer(20, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gd = (Graphics2D)g;
        int healthOffSet = (int) (100-10);
        
        double maxSize = 100.0;
        int heightOfBar = 6;
        double healthRatio = (double)current/(double)max;
        
        double hpBarSize = healthRatio*maxSize;
        
        gd.setColor(getColor(current, max));
        gd.fill(new Rectangle2D.Double(100, 100, hpBarSize, heightOfBar));
    }
    
    private Color getColor(double currentHealth, double maxHealth){
        int arraySize = colors.size();
        int index = (int)(arraySize/maxHealth*currentHealth);
        index = index >= arraySize ? arraySize-1 : index < 0 ? 0 : index;
        return colors.get(index);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        current+=counter;
        if(current < 0){
            counter = 1;
        }
        if(current > 100){
            counter = -1;
        }
        repaint();
    }
    
}
