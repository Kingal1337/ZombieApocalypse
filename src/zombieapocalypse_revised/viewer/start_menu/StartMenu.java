/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombieapocalypse_revised.viewer.start_menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import zombieapocalypse_revised.APanel;
import zombieapocalypse_revised.config.Config;
import zombieapocalypse_revised.config.DimensionDouble;

/**
 *
 * @author Alan Tsui
 */
public class StartMenu extends APanel{
    private double intervalBetweenButtons;
    
    private double versionAndCreditsFontSize;
    private Font buttonAndLabelFonts;
    
    private JLabel version;
    private DimensionDouble versionDimensions;
    
    private JLabel credits;
    private DimensionDouble creditsDimensions;
    
    private DimensionDouble buttonSize;
    private double buttonFontSize;
    
    private JLabel title;
    private DimensionDouble titleDimension;
    private double titleFontSize;
    private Font titleFont;
    
    private JButton start;
    
    private JButton options;
    
    private JButton exit;
    
    public StartMenu(){
        setLayout(null);
        intervalBetweenButtons = 5;
        titleDimension = new DimensionDouble(500, 100);
        buttonSize = new DimensionDouble(100, 30);
        versionDimensions = new DimensionDouble(100,20);
        creditsDimensions = new DimensionDouble(200,20);
        
        title = new JLabel(Config.GAME_TITLE);
        start = new JButton("Start");
        options = new JButton("Options");
        exit = new JButton("Quit");
        version = new JLabel(Config.VERSION+" Beta");
        credits = new JLabel("Copyright "+Config.COMPANY+" "+Config.YEAR);
        
        buttonFontSize = 12;
        versionAndCreditsFontSize = 8;
        titleFontSize = 36;
        try {
            titleFont = Font.createFont(Font.TRUETYPE_FONT, StartMenu.class.getResourceAsStream("/zombieapocalypse_revised/config/resources/fonts/zombie.ttf"));
            buttonAndLabelFonts = Font.createFont(Font.TRUETYPE_FONT, StartMenu.class.getResourceAsStream("/zombieapocalypse_revised/config/resources/fonts/casual_softcore.ttf"));
        } catch (FontFormatException ex) {
            Logger.getLogger(StartMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StartMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(titleFont.deriveFont(1, (int)titleFontSize));
        title.setBounds((int)((getSize().getWidth()/2)-(titleDimension.getWidth()/2)), (int)(getSize().getHeight()), (int)titleDimension.getWidth(), (int)titleDimension.getHeight());
        
        start.setBounds((int)((getSize().getWidth()/2)-(buttonSize.getWidth()/2)), (int)(((getSize().getHeight()/2)-(buttonSize.getHeight()))-(buttonSize.getHeight()/2)-intervalBetweenButtons), (int)buttonSize.getWidth(), (int)buttonSize.getHeight());
        
        options.setBounds((int)((getSize().getWidth()/2)-(buttonSize.getWidth()/2)), (int)((getSize().getHeight()/2)-(buttonSize.getHeight()/2)), (int)buttonSize.getWidth(), (int)buttonSize.getHeight());
        
        exit.setBounds((int)((getSize().getWidth()/2)-(buttonSize.getWidth()/2)), (int)(((getSize().getHeight()/2)-(buttonSize.getHeight()))+(buttonSize.getHeight()/2)+intervalBetweenButtons), (int)buttonSize.getWidth(), (int)buttonSize.getHeight());
        
        version.setBounds(0, (int)(getSize().getHeight()-versionDimensions.getHeight()), (int)versionDimensions.getWidth(), (int)versionDimensions.getHeight());
        version.setHorizontalAlignment(JLabel.LEFT);
        
        credits.setBounds((int)(getSize().getWidth()-creditsDimensions.getWidth()), (int)(getSize().getHeight()-creditsDimensions.getHeight()), (int)creditsDimensions.getWidth(), (int)creditsDimensions.getHeight());
        credits.setHorizontalAlignment(JLabel.RIGHT);
        
        MouseListener listener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                ((JButton)e.getSource()).setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ((JButton)e.getSource()).setBackground(Color.GRAY);
            }
        };
        
        start.setContentAreaFilled(true);
        start.setBackground(Color.GRAY);
        start.setFocusPainted(false);
        start.setBorder(BorderFactory.createEmptyBorder());
        start.addMouseListener(listener);
        
        options.setContentAreaFilled(true);
        options.setBackground(Color.GRAY);
        options.setFocusPainted(false);
        options.setBorder(BorderFactory.createEmptyBorder());
        options.addMouseListener(listener);
        
        exit.setContentAreaFilled(true);
        exit.setBackground(Color.GRAY);
        exit.setFocusPainted(false);
        exit.setBorder(BorderFactory.createEmptyBorder());
        exit.addMouseListener(listener);
        
        
        start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                AllFrames.createMainPanel(getSize());
                AllFrames.frame.changePanel(AllFrames.panel);
            }
        });
        
        options.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                AllFrames.frame.changePanel(AllFrames.options);                
            }
        });
        
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        
        add(title);
        add(start);
        add(options);
        add(exit);
        add(credits);
        add(version);
    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.drawLine(0,(int)getSize().getHeight()/2,1920,(int)getSize().getHeight()/2);
//    }

    
    
    @Override
    public void resizeComponents(Dimension previousSize, Dimension dimensions) {
        super.resizeComponents(previousSize, dimensions);
        double widthToResizeBy = dimensions.getWidth()/previousSize.getWidth();
        double heightToResizeBy = dimensions.getHeight()/previousSize.getHeight();
        
        intervalBetweenButtons = intervalBetweenButtons*heightToResizeBy;
        
        titleDimension.setSize(titleDimension.getWidth()*widthToResizeBy, titleDimension.getHeight()*heightToResizeBy);
        
        versionDimensions.setSize(versionDimensions.getWidth()*widthToResizeBy, versionDimensions.getHeight()*heightToResizeBy);
        
        creditsDimensions.setSize(creditsDimensions.getWidth()*widthToResizeBy, creditsDimensions.getHeight()*heightToResizeBy);
        
        buttonSize.setSize(buttonSize.getWidth()*widthToResizeBy, buttonSize.getHeight()*heightToResizeBy);
        
        titleFontSize = titleFontSize*widthToResizeBy;
        buttonFontSize = buttonFontSize*widthToResizeBy;
        
        versionAndCreditsFontSize = versionAndCreditsFontSize*widthToResizeBy;
        
        title.setBounds((int)((getSize().getWidth()/2)-(titleDimension.getWidth()/2)), (int)(getSize().getHeight()/15), (int)titleDimension.getWidth(), (int)titleDimension.getHeight());
        title.setFont(titleFont.deriveFont(1, (int)titleFontSize));
        
        start.setBounds((int)((getSize().getWidth()/2)-(buttonSize.getWidth()/2)), (int)(((getSize().getHeight()/2)-(buttonSize.getHeight())-(buttonSize.getHeight()/2)-intervalBetweenButtons)), (int)buttonSize.getWidth(), (int)buttonSize.getHeight());
        start.setFont(buttonAndLabelFonts.deriveFont(1, (int)buttonFontSize));
        
        options.setBounds((int)((getSize().getWidth()/2)-(buttonSize.getWidth()/2)), (int)((getSize().getHeight()/2)-(buttonSize.getHeight()/2)), (int)buttonSize.getWidth(), (int)buttonSize.getHeight());
        options.setFont(buttonAndLabelFonts.deriveFont(1, (int)buttonFontSize));
        
        exit.setBounds((int)((getSize().getWidth()/2)-(buttonSize.getWidth()/2)), (int)(((getSize().getHeight()/2)-(buttonSize.getHeight()/2)+(buttonSize.getHeight())+intervalBetweenButtons)), (int)buttonSize.getWidth(), (int)buttonSize.getHeight());
        exit.setFont(buttonAndLabelFonts.deriveFont(1, (int)buttonFontSize));
        
        version.setFont(buttonAndLabelFonts.deriveFont(Font.BOLD, (int)versionAndCreditsFontSize));
        version.setBounds(0, (int)(getSize().getHeight()-versionDimensions.getHeight()), (int)versionDimensions.getWidth(), (int)versionDimensions.getHeight());

        credits.setFont(buttonAndLabelFonts.deriveFont(Font.BOLD, (int)versionAndCreditsFontSize));
        credits.setBounds((int)(getSize().getWidth()-creditsDimensions.getWidth()), (int)(getSize().getHeight()-creditsDimensions.getHeight()), (int)creditsDimensions.getWidth(), (int)creditsDimensions.getHeight());
    }
}
