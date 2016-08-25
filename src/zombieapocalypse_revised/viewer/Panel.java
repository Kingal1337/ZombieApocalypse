///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package zombieapocalypse_revised.viewer;
//
///**
// * RainbowText.java Display text in changing rainbow colors.
// *
// * @author Glenn A. Richard
// * @version 2.0, November 24, 1996 Center for High Pressure Research ESS
// * Building SUNY at Stony Brook Stony Brook, NY 11794
// */
//import java.awt.*;
//
//public class RainbowText extends java.applet.Applet
//        implements Runnable {
//
//    private String textStr = null;
//    private String fontName;
//    private int fontStyle;
//    private int fontSize;
//    private Color bgColor;
//    private int sleepTime;
//    private String paramStr;
//    private int strlen;
//    private Thread runner = null;
//    private char theChars[];
//    private int charOffsets[];
//    private Color colors[];
//    private int yOffset;
//    private int phase = 0;
//    private Image offScreenImage;
//    private Graphics offScreenG;
//    private Font f;
//    private FontMetrics fm;
//    private boolean stopped = false;
//    private String pinfo[][] = {
//        {"text", "String", "Text to display (RainbowText)"},
//        {"bgcolor", "hex rrggbb color", "Background color in rrggbb format (000000)"},
//        {"fontname", "String", "Name of the font (TimesRoman)"},
//        {"fontstyle", "String", "B = bold, I = italic, BI = both ()"},
//        {"fontsize", "int", "Point size to be used (36)"},
//        {"sleeptime", "int", "Milliseconds for sleep time (100)"}
//    };
//
//    public void init() {
//        float h;
//        int xPos = 20;
//        paramStr = getParameter("bgcolor");
//        if (paramStr == null) {
//            bgColor = Color.black;
//        } else {
//            try {
//                bgColor = new Color(Integer.parseInt(paramStr, 16));
//            } catch (NumberFormatException e) {
//                bgColor = Color.black;
//            }
//        }
//        setBackground(bgColor);
//        textStr = getParameter("text");
//        if (textStr == null) {
//            textStr = "RainbowText";
//        }
//        fontName = getParameter("fontname");
//        if (fontName == null) {
//            fontName = "TimesRoman";
//        }
//        paramStr = getParameter("fontstyle");
//        if (paramStr == null) {
//            fontStyle = Font.PLAIN;
//        } else if (paramStr.equals("B")) {
//            fontStyle = Font.BOLD;
//        } else if (paramStr.equals("I")) {
//            fontStyle = Font.ITALIC;
//        } else if (paramStr.equals("BI")) {
//            fontStyle = Font.BOLD | Font.ITALIC;
//        } else {
//            fontStyle = Font.PLAIN;
//        }
//        paramStr = getParameter("fontsize");
//        if (paramStr == null) {
//            fontSize = 36;
//        } else {
//            try {
//                fontSize = Integer.parseInt(paramStr);
//            } catch (Exception e) {
//                fontSize = 36;
//            }
//        }
//        paramStr = getParameter("sleeptime");
//        if (paramStr == null) {
//            sleepTime = 100;
//        } else {
//            try {
//                sleepTime = Integer.parseInt(paramStr);
//            } catch (Exception e) {
//                sleepTime = 100;
//            }
//        }
//        f = new Font(fontName, fontStyle, fontSize);
//        fm = getFontMetrics(f);
//        resize(40 + fm.stringWidth(textStr), 10 + fm.getHeight());
//        yOffset = fm.getAscent() + 5;
//        strlen = textStr.length();
//        theChars = new char[strlen];
//        charOffsets = new int[strlen];
//        textStr.getChars(0, strlen, theChars, 0);
//        colors = new Color[strlen];
//        for (int i = 0; i < strlen; i++) {
//            h = ((float) i) / ((float) strlen);
//            colors[i] = new Color(Color.HSBtoRGB(h, 1.0f, 1.0f));
//            charOffsets[i] = xPos;
//            xPos += fm.charWidth(theChars[i]);
//        }
//        offScreenImage = createImage(this.size().width, this.size().height);
//        offScreenG = offScreenImage.getGraphics();
//        offScreenG.setColor(bgColor);
//        offScreenG.fillRect(0, 0, this.size().width, this.size().height);
//        offScreenG.setFont(f);
//    }
//
//    public void start() {
//        if (runner == null) {
//            runner = new Thread(this);
//            runner.start();
//        }
//    }
//
//    public void stop() {
//        if (runner != null && runner.isAlive()) {
//            runner.stop();
//        }
//        runner = null;
//    }
//
//    public void run() {
//        showStatus("Click to stop " + getClass().getName());
//        while (runner != null) {
//            repaint();
//            try {
//                Thread.sleep(sleepTime);
//            } catch (InterruptedException e) {
//            }
//        }
//    }
//
//    public void update(Graphics g) {
//        int x, y;
//        phase--;
//        if (phase < 0) {
//            phase = strlen - 1;
//        }
//        for (int i = 0; i < strlen; i++) {
//            x = charOffsets[i];
//            offScreenG.setColor(colors[(phase + i) % strlen]);
//            offScreenG.drawChars(theChars, i, 1, x, yOffset);
//        }
//        paint(g);
//    }
//
//    public void paint(Graphics g) {
//        g.drawImage(offScreenImage, 0, 0, this);
//    }
//
//    public boolean handleEvent(Event e) {
//        if (e.id == Event.MOUSE_DOWN) {
//            if (runner != null && runner.isAlive()) {
//                if (stopped) {
//                    showStatus("Click to stop " + getClass().getName());
//                    runner.resume();
//                } else {
//                    showStatus("Click to restart " + getClass().getName());
//                    runner.suspend();
//                }
//                stopped = !stopped;
//            } else {
//                stopped = false;
//                runner = new Thread(this);
//                runner.start();
//            }
//        } else if (e.id == Event.MOUSE_ENTER) {
//            if (stopped) {
//                showStatus("Click to restart " + getClass().getName());
//            } else {
//                showStatus("Click to stop " + getClass().getName());
//            }
//        } else {
//            return super.handleEvent(e);
//        }
//        return true;
//    }
//
//    public String[][] getParameterInfo() {
//        return pinfo;
//    }
//
//    public String getAppletInfo() {
//        return ("Glenn A. Richard, CHiPR, SUNY at Stony Brook");
//    }
//}

import alanutilites.util.text.RainbowText;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener{
    private Timer timer;
    private RainbowText text;
    public Panel() {
        text = new RainbowText("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890 ", new Font("Comic Sans MS", 1, 36));
        timer = new Timer(20, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gd = (Graphics2D) g;
        gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        text.render(gd, 50, 50);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Color fading aniamtion");
        frame.add(new Panel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
