// 
// Decompiled by Procyon v0.5.36
// 

package gui;

import java.io.FileNotFoundException;
import java.awt.Component;

public class Main
{
    public static void main(final String[] args) throws FileNotFoundException {
        final Frame jf = new Frame("AI");
        jf.add(new PN(jf));
        jf.setVisible(true);
        jf.setSize(755, 780);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
        jf.setAlwaysOnTop(false);
        jf.setDefaultCloseOperation(3);
    }
}
