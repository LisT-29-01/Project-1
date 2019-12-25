// 
// Decompiled by Procyon v0.5.36
// 

package gui;

import map.MapS;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.image.ImageObserver;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import player.Player;
import java.util.Random;
import ai.Aiv12;
import ai.Aiv3;
import javax.swing.Timer;
import player.GreenPlayer;
import player.RedPlayer;
import map.Map;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class Board extends JPanel implements KeyListener, ActionListener
{
    public static final int HEIGHT = 720;
    public static final int WIDTH = 700;
    private final int offsetx = 20;
    private final int offsety = 20;
    Map map;
    RedPlayer red;
    GreenPlayer green;
    Timer timer;
    int x;
    int y;
    Aiv12 aiv12;
    Aiv3 aiv3;
    boolean finished;
    
    public Board() throws FileNotFoundException {
        this.x = 0;
        this.y = 0;
        this.aiv12 = new Aiv12();
        //this.aiv3 = new Aiv3();
        this.finished = false;
        this.setFocusable(true);
        this.addKeyListener(this);
        this.map = new Map("/lib/map.txt");
        this.red = new RedPlayer(14, 14, this.map);
        this.green = new GreenPlayer(0, 0, this.map);
        this.map.setGreen(0, 0);
        this.map.setRed(14, 14);
        (this.timer = new Timer(27, this)).start();
        if (new Random().nextInt(2) == 1) {
            this.setFirstTurn(this.red);
        }
        else {
            this.setFirstTurn(this.green);
        }
    }
    
    public Board(final Map m) {
        this.x = 0;
        this.y = 0;
        this.aiv12 = new Aiv12();
        //this.aiv3 = new Aiv3();
        this.finished = false;
        this.setFocusable(true);
        this.addKeyListener(this);
        this.map = m;
        this.red = new RedPlayer(14, 14, this.map);
        this.green = new GreenPlayer(0, 0, this.map);
        this.map.setGreen(0, 0);
        this.map.setRed(14, 14);
        (this.timer = new Timer(27, this)).start();
        if (new Random().nextInt(2) == 1) {
            this.setFirstTurn(this.green);
        }
        else {
            this.setFirstTurn(this.red);
        }
    }
    
    private void setFirstTurn(final Player p) {
        p.setTurn(true);
    }
    
    private void changeTurn() {
        if (this.green.getTurn()) {
            this.green.setTurn(false);
            this.red.setTurn(true);
        }
        else {
            this.green.setTurn(true);
            this.red.setTurn(false);
        }
    }
    
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.map.getImageMap(), 0, 0, this);
        for (int x = 0; x < 15; ++x) {
            for (int y = 0; y < 15; ++y) {
                if (!this.map.isSpace(x, y)) {
                    g.drawImage(this.map.getImage(x, y), x * 50 , y * 50 , this);
                }
            }
        }
        g.drawImage(this.red.getImage(), this.red.xp, this.red.yp, this);
        g.drawImage(this.green.getImage(), this.green.xp, this.green.yp, this);
        if (this.finished) {
            if (this.red.goable(this.map)) {
                g.drawImage(new ImageIcon(this.getClass().getResource("/lib/rw.png")).getImage(), 0, 0, this);
            }
            else {
                g.drawImage(new ImageIcon(this.getClass().getResource("/lib/gw.png")).getImage(), 0, 0, this);
            }
        }
        this.repaint();
    }
  
    @Override
    public void keyTyped(final KeyEvent ke) {
    }
    
    @Override
    public void keyPressed(final KeyEvent ke) {
    }
    
    @Override
    public void keyReleased(final KeyEvent ke) {
        if (this.green.getTurn() && !this.finished) {
            final int k = ke.getKeyCode();
            int dir = -1;
            if (k == 38) {
                dir = 2;
            }
            else if (k == 40) {
                dir = 0;
            }
            else if (k == 37) {
                dir = 1;
            }
            else if (k == 39) {
                dir = 3;
            }
            
            if (this.green.move(dir)) {
                this.map.setGreen(this.green.getX(), this.green.getY());
                this.changeTurn();
            }
            
        }
    }
    
    @Override
    public void actionPerformed(final ActionEvent ae) {
    /*    if (!this.finished)
      if (!this.green.goable(this.map)) {
        System.out.println("Do Thang");
        this.finished = true;
      } else if (this.red.getTurn()) {
        Long T = Long.valueOf(System.nanoTime());
        this.red.move(this.aiv12.findDirection(new MapS(this.map), this.red.getX(), this.red.getY(), 
              this.green.getX(), this.green.getY()));

        
        this.map.setRed(this.red.getX(), this.red.getY());

        
        if (!this.red.goable(this.map)) {
          System.out.println("Xanh Thang");
          this.finished = true;
        } else {
          changeTurn();
        } 
      }*/  
        if (!this.finished) {
            if (this.green.getTurn()){
                final Long L = System.nanoTime();
                this.green.move(this.aiv3.findDirection(new MapS(this.map), this.green.getX(), this.green.getY(), this.red.getX(), this.red.getY()));
                this.map.setGreen(this.green.getX(), this.green.getY());
                if (!this.green.goable(this.map)) {
                    System.out.println("Do Thang");
                    this.finished = true;
                }
                else {
                    this.changeTurn();
                }
            }
            else if (this.red.getTurn()) {
                final Long T = System.nanoTime();
                this.red.move(this.aiv12.findDirection(new MapS(this.map), this.red.getX(), this.red.getY(), this.green.getX(), this.green.getY()));
                this.map.setRed(this.red.getX(), this.red.getY());
                if (!this.red.goable(this.map)) {
                    System.out.println("Xanh Thang");
                    this.finished = true;
                }
                else {
                    this.changeTurn();
                }
            }
        }
    }
}
