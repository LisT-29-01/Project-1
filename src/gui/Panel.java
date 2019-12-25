// 
// Decompiled by Procyon v0.5.36
// 

package gui;

import map.Map;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import javax.swing.border.Border;
import java.awt.Cursor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JPanel;

public class Panel extends JPanel implements MouseListener
{
    Button[][] buttons;
    JButton butok;
    Frame jf;
    Font font;
    
    public Panel(final Frame jf) {
        this.buttons = new Button[15][15];
        this.butok = new JButton("OK");
        this.font = new Font("MV Boli", 1, 18);
        this.jf = jf;
        this.butok.setBackground(Color.decode("#f1f1f1"));
        this.butok.setFont(this.font);
        this.butok.setIcon(new ImageIcon(this.getClass().getResource("/lib/ok.png")));
        this.butok.setText(null);
        this.butok.setCursor(new Cursor(12));
        this.butok.setBorder(null);
        this.addMouseListener(this);
        this.setFocusable(true);
        for (int i = 0; i < 15; ++i) {
            for (int j = 0; j < 15; ++j) {
                this.buttons[i][j] = new Button();
            }
        }
        this.setLayout(new GridLayout(15, 15));
        for (int i = 0; i < 15; ++i) {
            for (int j = 0; j < 15; ++j) {
                if (i == 7 && j == 7) {
                    this.add(this.butok);
                    this.butok.addMouseListener(this);
                }
                else {
                    this.add(this.buttons[i][j]);
                    this.buttons[i][j].addMouseListener(this);
                }
            }
        }
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
    }
    
    @Override
    public void mouseEntered(final MouseEvent arg0) {
    }
    
    @Override
    public void mouseExited(final MouseEvent arg0) {
    }
    
    @Override
    public void mousePressed(final MouseEvent arg0) {
        if (arg0.getSource() == this.butok) {
            final Map map = new Map(this.getMap());
            this.jf.play(map);
        }
    }
    
    @Override
    public void mouseReleased(final MouseEvent arg0) {
        for (int i = 0; i < 15; ++i) {
            for (int j = 0; j < 15; ++j) {
                if (arg0.getSource() == this.buttons[i][j]) {
                    this.buttons[i][j].click();
                    this.buttons[14 - i][14 - j].setClick();
                }
            }
        }
    }
    
    public Map getMap() {
        final int[][] map = new int[15][15];
        /*for (int i = 0; i < 15; ++i) {
            for (int j = 0; j < 15; ++j) {
                if (this.buttons[i][j].isSelected()) {
                    map[i][j] = 1;
                }
                else {
                    map[i][j] = 0;
                }
            }
        }
        */
        Random rd = new Random();
        int S = rd.nextInt(13) + 1;
        for (int i = 0; i < 15; ++i) {
            for (int j = 0; j < 15; ++j){
                map[i][j] = 0;
            }
        }
        for (int n=0; n<S;){
            int i = rd.nextInt(15);
            int j = rd.nextInt(15);
            if ((i != 7) || (j != 7)){
                map[i][j] = 1;
                map[14 - i][14 - j] = 1;
                n++;
            }
        }
        return new Map(map);
    }
    
    public void check() {
        for (int i = 0; i < 15; ++i) {
            for (int j = 0; j < 15; ++j) {
                if (this.buttons[i][j].isSelected() && !this.buttons[14 - i][14 - j].isSelected()) {
                    this.buttons[i][j].reset();
                    this.buttons[14 - i][14 - j].reset();
                }
            }
        }
    }
}
