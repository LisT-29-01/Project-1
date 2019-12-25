// 
// Decompiled by Procyon v0.5.36
// 

package map;

public class Mapn
{
    public static final int M = 15;
    public static final int N = 15;
    public static final int SPACE = 0;
    public static final int WALL = 1;
    public static final int GREEN = 2;
    public static final int RED = 3;
    public static final int TEMP = 4;
    private int[][] map;
    public static long dem;
    
    static {
        Mapn.dem = 0L;
    }
    
    public Mapn(final Map ma) {
        this.map = new int[15][15];
        for (int i = 0; i < 15; ++i) {
            for (int j = 0; j < 15; ++j) {
                this.map[i][j] = ma.map[i][j];
            }
        }
        ++Mapn.dem;
    }
    
    public Mapn(final Mapn ma) {
        this.map = new int[15][15];
        for (int i = 0; i < 15; ++i) {
            for (int j = 0; j < 15; ++j) {
                this.map[i][j] = ma.map[i][j];
            }
        }
        ++Mapn.dem;
    }
    
    public boolean hasSpaceAround(final int x, final int y) {
        return this.isSpace(x - 1, y) || this.isSpace(x + 1, y) || this.isSpace(x, y - 1) || this.isSpace(x, y + 1);
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
    
    public int amountSpacesNotTempAround(final int x, final int y) {
        int count = 0;
        if (this.isSpaceAndNotTemp(x - 1, y)) {
            ++count;
        }
        if (this.isSpaceAndNotTemp(x + 1, y)) {
            ++count;
        }
        if (this.isSpaceAndNotTemp(x, y - 1)) {
            ++count;
        }
        if (this.isSpaceAndNotTemp(x, y + 1)) {
            ++count;
        }
        return count;
    }
    
    public void printMap() {
        for (int i = 0; i < 15; ++i) {
            for (int j = 0; j < 15; ++j) {
                System.out.print(this.map[i][j]);
            }
            System.out.println();
        }
    }
    
    public boolean isSpace(final int x, final int y) {
        return x < 15 && y < 15 && x >= 0 && y >= 0 && (this.map[y][x] == 0 || this.map[y][x] == 4);
    }
    
    public boolean isSpaceAndNotTemp(final int x, final int y) {
        return x < 15 && y < 15 && x >= 0 && y >= 0 && this.map[y][x] == 0;
    }
    
    public void setTemp(final int x, final int y) {
        this.map[y][x] = 4;
    }
    
    public boolean isWall(final int x, final int y) {
        return x >= 15 || y >= 15 || x < 0 || y < 0 || this.map[y][x] == 1;
    }
    
    public void setRed(final int x, final int y) {
        this.map[y][x] = 3;
    }
    
    public void setGreen(final int x, final int y) {
        this.map[y][x] = 2;
    }
    
    public void setMap(final int x, final int y) {
        this.map[y][x] = 10;
    }
    
    public boolean isReachable(final int x, final int y) {
        return x < 15 && y < 15 && x >= 0 && y >= 0 && this.map[y][x] == 10;
    }
    
    public void setSpace(final int x, final int y) {
        this.map[y][x] = 0;
    }
}
