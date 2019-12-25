// 
// Decompiled by Procyon v0.5.36
// 

package map;

public class MyMap
{
    public static final int SPACE = 0;
    public static final int WALL = 1;
    public static final int GREEN = 2;
    public static final int RED = 3;
    public static final int TEMP = 4;
    public static final int N = 15;
    public int[] map;
    
    public MyMap(final Map mm) { 
        this.map = new int[225];
        final int[][] m = mm.map;
        for (int i = 0; i < 15; ++i) {
            for (int j = 0; j < 15; ++j) {
                this.map[i * 15 + j] = m[i][j];
            }
        }
    }
    
    public MyMap(final MyMap mm) {
        this.map = new int[225];
        final int[] m = mm.map;
        for (int i = 0; i < 225; ++i) {
            this.map[i] = m[i];
        }
    }
    
    public boolean isSpace(final int x, final int y) {
        return x < 15 && y < 15 && x >= 0 && y >= 0 && (this.map[y * 15 + x] == 0 || this.map[y * 15 + x] == 4);
    }
    
    public int amountSpacesAround(final int x, final int y) {
        int count = 0;
        if (this.isSpace(x - 1, y)) {
            ++count;
        }
        if (this.isSpace(x + 1, y)) {
            ++count;
        }
        if (this.isSpace(x, y - 1)) {
            ++count;
        }
        if (this.isSpace(x, y + 1)) {
            ++count;
        }
        return count;
    }
    
    public boolean isSpaceAndNotTemp(final int x, final int y) {
        return x < 15 && y < 15 && x >= 0 && y >= 0 && this.map[y * 15 + x] == 0;
    }
    
    public void setTemp(final int x, final int y) {
        this.map[y * 15 + x] = 4;
    }
    
    public void setRed(final int x, final int y) {
        this.map[y * 15 + x] = 3;
    }
    
    public void setGreen(final int x, final int y) {
        this.map[y * 15 + x] = 2;
    }
    
    public void setMap(final int x, final int y) {
        this.map[y * 15 + x] = 10;
    }
    
    public boolean isReachable(final int x, final int y) {
        return x < 15 && y < 15 && x >= 0 && y >= 0 && this.map[y * 15 + x] == 10;
    }
    
    public void setSpace(final int x, final int y) {
        this.map[y * 15 + x] = 0;
    }
}
