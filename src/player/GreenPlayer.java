// 
// Decompiled by Procyon v0.5.36
// 

package player;

import javax.swing.ImageIcon;
import map.Map;

public class GreenPlayer extends Player
{
    public GreenPlayer(final int x, final int y, final Map map) {
        super(x, y, map);
        this.arrImage[0] = new ImageIcon(this.getClass().getResource("/lib/xex_4.png")).getImage();
        this.arrImage[1] = new ImageIcon(this.getClass().getResource("/lib/xex_2.png")).getImage();
        this.arrImage[2] = new ImageIcon(this.getClass().getResource("/lib/xex.png")).getImage();
        this.arrImage[3] = new ImageIcon(this.getClass().getResource("/lib/xex_3.png")).getImage();
        this.image = this.arrImage[0];
    }
}
