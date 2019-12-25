// 
// Decompiled by Procyon v0.5.36
// 

package ai;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Collection;
import java.util.ArrayList;
import map.MapS;

public class Aiv12
{
    private static final int DEPTH = 7;
    private static final int DEPTH_PATH = 12;
    private static final int MAXIMUM = 80000;
    private static final int MINIMUM = -80000;
    int[] priceofspace;
    int amountnode;
    boolean crack;
    private boolean alphabeta;
    private static final int VAT = 5;
    private static final int VS = 1;
    private static final int KN = 31;
    private static final int KE = 11;
    
    public Aiv12() {
        this.priceofspace = new int[5];
        this.crack = false;
        this.alphabeta = true;
    }
    
    public int findDirection(final MapS map, final int x, final int y, final int xe, final int ye) {
        if (!map.isSpace(x - 1, y) && !map.isSpace(x + 1, y) && !map.isSpace(x, y + 1) && !map.isSpace(x, y - 1)) {
            return -1;
        }
        if (this.crack) {
            return this.findPathV1(map, x, y);
        }
        if (!this.enemyInside(new MapS(map), xe, ye, x, y)) {
            this.crack = true;
            return this.findPathV1(map, x, y);
        }
        final int t = this.minimax(map, x, y, xe, ye);
        if (t < 0) {
            if (map.isSpace(x - 1, y)) {
                return 1;
            }
            if (map.isSpace(x + 1, y)) {
                return 3;
            }
            if (map.isSpace(x, y - 1)) {
                return 2;
            }
            if (map.isSpace(x, y + 1)) {
                return 0;
            }
        }
        return t;
    }
    
    private int findPathV1(final MapS map, final int x, final int y) {
        int max = -1000;
        int dir = -1;
        if (map.isSpace(x - 1, y)) {
            final MapS m = new MapS(map);
            m.setRed(x - 1, y);
            final int temp = this.searchPath(m, x - 1, y, 12);
            if (temp > max) {
                max = temp;
                dir = 1;
            }
        }
        if (map.isSpace(x + 1, y)) {
            final MapS m = new MapS(map);
            m.setRed(x + 1, y);
            final int temp = this.searchPath(m, x + 1, y, 12);
            if (temp > max) {
                max = temp;
                dir = 3;
            }
        }
        if (map.isSpace(x, y - 1)) {
            final MapS m = new MapS(map);
            m.setRed(x, y - 1);
            final int temp = this.searchPath(m, x, y - 1, 12);
            if (temp > max) {
                max = temp;
                dir = 2;
            }
        }
        if (map.isSpace(x, y + 1)) {
            final MapS m = new MapS(map);
            m.setRed(x, y + 1);
            final int temp = this.searchPath(m, x, y + 1, 12);
            if (temp > max) {
                max = temp;
                dir = 0;
            }
        }
        return dir;
    }
    
    private int searchPath(final MapS map, final int x, final int y, final int depth) {
        int t = -999;
        if (depth <= 0) {
            return this.numberofegdes(map, x, y);
        }
        if (map.isSpace(x - 1, y)) {
            final MapS m = new MapS(map);
            m.setRed(x - 1, y);
            final int temp = this.searchPath(m, x - 1, y, depth - 1);
            t = ((t > temp) ? t : temp);
        }
        if (map.isSpace(x + 1, y)) {
            final MapS m = new MapS(map);
            m.setRed(x + 1, y);
            final int temp = this.searchPath(m, x + 1, y, depth - 1);
            t = ((t > temp) ? t : temp);
        }
        if (map.isSpace(x, y - 1)) {
            final MapS m = new MapS(map);
            m.setRed(x, y - 1);
            final int temp = this.searchPath(m, x, y - 1, depth - 1);
            t = ((t > temp) ? t : temp);
        }
        if (map.isSpace(x, y + 1)) {
            final MapS m = new MapS(map);
            m.setRed(x, y + 1);
            final int temp = this.searchPath(m, x, y + 1, depth - 1);
            t = ((t > temp) ? t : temp);
        }
        if (t < -990) {
            return -depth;
        }
        return t;
    }
    
    private int countEdgesAStep(final MapS map, final ArrayList<Point> arp) {
        int count = 0;
        final ArrayList<Point> temp = new ArrayList<Point>();
        while (!arp.isEmpty()) {
            final Point p = arp.remove(0);
            final int x = p.x;
            final int y = p.y;
            if (map.isSpaceAndNotTemp(x + 1, y)) {
                count += map.amountSpacesAround(x + 1, y);
                temp.add(new Point(x + 1, y));
                map.setTemp(x + 1, y);
            }
            if (map.isSpaceAndNotTemp(x - 1, y)) {
                count += map.amountSpacesAround(x - 1, y);
                temp.add(new Point(x - 1, y));
                map.setTemp(x - 1, y);
            }
            if (map.isSpaceAndNotTemp(x, y + 1)) {
                count += map.amountSpacesAround(x, y + 1);
                temp.add(new Point(x, y + 1));
                map.setTemp(x, y + 1);
            }
            if (map.isSpaceAndNotTemp(x, y - 1)) {
                count += map.amountSpacesAround(x, y - 1);
                temp.add(new Point(x, y - 1));
                map.setTemp(x, y - 1);
            }
        }
        arp.addAll(temp);
        return count;
    }
    
    private int luonggiacanh(final MapS map, final int x, final int y, final int xe, final int ye, final boolean myturn) {
        int mysum = 0;
        int hissum = 0;
        final ArrayList<Point> me = new ArrayList<Point>();
        final ArrayList<Point> him = new ArrayList<Point>();
        me.add(new Point(x, y));
        him.add(new Point(xe, ye));
        if (myturn) {
            mysum += this.countEdgesAStep(map, me);
        }
        while (!me.isEmpty() || !him.isEmpty()) {
            hissum += this.countEdgesAStep(map, him);
            mysum += this.countEdgesAStep(map, me);
        }
        return mysum - hissum;
    }
    
    private int numberofegdes(final MapS map, final int x, final int y) {
        int max = 0;
        final ArrayList<Point> arp = new ArrayList<Point>();
        arp.add(new Point(x, y));
        int xs = x;
        int ys = y;
        if (map.isSpaceAndNotTemp(xs + 1, ys)) {
            int t = 0;
            t += map.amountSpacesAround(xs + 1, ys);
            map.setTemp(xs + 1, ys);
            arp.add(new Point(xs + 1, ys));
            while (!arp.isEmpty()) {
                final Point p = arp.remove(0);
                xs = p.x;
                ys = p.y;
                if (map.isSpaceAndNotTemp(xs + 1, ys)) {
                    t += map.amountSpacesAround(xs + 1, ys);
                    map.setTemp(xs + 1, ys);
                    arp.add(new Point(xs + 1, ys));
                }
                if (map.isSpaceAndNotTemp(xs - 1, ys)) {
                    t += map.amountSpacesAround(xs - 1, ys);
                    map.setTemp(xs - 1, ys);
                    arp.add(new Point(xs - 1, ys));
                }
                if (map.isSpaceAndNotTemp(xs, ys + 1)) {
                    t += map.amountSpacesAround(xs, ys + 1);
                    map.setTemp(xs, ys + 1);
                    arp.add(new Point(xs, ys + 1));
                }
                if (map.isSpaceAndNotTemp(xs, ys - 1)) {
                    t += map.amountSpacesAround(xs, ys - 1);
                    map.setTemp(xs, ys - 1);
                    arp.add(new Point(xs, ys - 1));
                }
            }
            if (t > max) {
                max = t;
            }
        }
        if (map.isSpaceAndNotTemp(xs - 1, ys)) {
            int t = 0;
            t += map.amountSpacesAround(xs - 1, ys);
            map.setTemp(xs - 1, ys);
            arp.add(new Point(xs - 1, ys));
            while (!arp.isEmpty()) {
                final Point p = arp.remove(0);
                xs = p.x;
                ys = p.y;
                if (map.isSpaceAndNotTemp(xs + 1, ys)) {
                    t += map.amountSpacesAround(xs + 1, ys);
                    map.setTemp(xs + 1, ys);
                    arp.add(new Point(xs + 1, ys));
                }
                if (map.isSpaceAndNotTemp(xs - 1, ys)) {
                    t += map.amountSpacesAround(xs - 1, ys);
                    map.setTemp(xs - 1, ys);
                    arp.add(new Point(xs - 1, ys));
                }
                if (map.isSpaceAndNotTemp(xs, ys + 1)) {
                    t += map.amountSpacesAround(xs, ys + 1);
                    map.setTemp(xs, ys + 1);
                    arp.add(new Point(xs, ys + 1));
                }
                if (map.isSpaceAndNotTemp(xs, ys - 1)) {
                    t += map.amountSpacesAround(xs, ys - 1);
                    map.setTemp(xs, ys - 1);
                    arp.add(new Point(xs, ys - 1));
                }
            }
            if (t > max) {
                max = t;
            }
        }
        if (map.isSpaceAndNotTemp(xs, ys + 1)) {
            int t = 0;
            t += map.amountSpacesAround(xs, ys + 1);
            map.setTemp(xs, ys + 1);
            arp.add(new Point(xs, ys + 1));
            while (!arp.isEmpty()) {
                final Point p = arp.remove(0);
                xs = p.x;
                ys = p.y;
                if (map.isSpaceAndNotTemp(xs + 1, ys)) {
                    t += map.amountSpacesAround(xs + 1, ys);
                    map.setTemp(xs + 1, ys);
                    arp.add(new Point(xs + 1, ys));
                }
                if (map.isSpaceAndNotTemp(xs - 1, ys)) {
                    t += map.amountSpacesAround(xs - 1, ys);
                    map.setTemp(xs - 1, ys);
                    arp.add(new Point(xs - 1, ys));
                }
                if (map.isSpaceAndNotTemp(xs, ys + 1)) {
                    t += map.amountSpacesAround(xs, ys + 1);
                    map.setTemp(xs, ys + 1);
                    arp.add(new Point(xs, ys + 1));
                }
                if (map.isSpaceAndNotTemp(xs, ys - 1)) {
                    t += map.amountSpacesAround(xs, ys - 1);
                    map.setTemp(xs, ys - 1);
                    arp.add(new Point(xs, ys - 1));
                }
            }
            if (t > max) {
                max = t;
            }
        }
        if (map.isSpaceAndNotTemp(xs, ys - 1)) {
            int t = 0;
            t += map.amountSpacesAround(xs, ys - 1);
            map.setTemp(xs, ys - 1);
            arp.add(new Point(xs, ys - 1));
            while (!arp.isEmpty()) {
                final Point p = arp.remove(0);
                xs = p.x;
                ys = p.y;
                if (map.isSpaceAndNotTemp(xs + 1, ys)) {
                    t += map.amountSpacesAround(xs + 1, ys);
                    map.setTemp(xs + 1, ys);
                    arp.add(new Point(xs + 1, ys));
                }
                if (map.isSpaceAndNotTemp(xs - 1, ys)) {
                    t += map.amountSpacesAround(xs - 1, ys);
                    map.setTemp(xs - 1, ys);
                    arp.add(new Point(xs - 1, ys));
                }
                if (map.isSpaceAndNotTemp(xs, ys + 1)) {
                    t += map.amountSpacesAround(xs, ys + 1);
                    map.setTemp(xs, ys + 1);
                    arp.add(new Point(xs, ys + 1));
                }
                if (map.isSpaceAndNotTemp(xs, ys - 1)) {
                    t += map.amountSpacesAround(xs, ys - 1);
                    map.setTemp(xs, ys - 1);
                    arp.add(new Point(xs, ys - 1));
                }
            }
            if (t > max) {
                max = t;
            }
        }
        return max;
    }
    
    public int minimax(final MapS map, final int x, final int y, final int xe, final int ye) {
        final int depth = 14;
        int direction = -1;
        int value = -80000;
        final int alpha = -80000;
        final int beta = 80000;
        this.amountnode = 0;
        if (map.isSpace(x, y + 1)) {
            final MapS maptemp = new MapS(map);
            maptemp.setRed(x, y + 1);
            final int temp = this.minValue(maptemp, x, y + 1, xe, ye, depth - 1, alpha, beta);
            if (temp > value) {
                value = temp;
                direction = 0;
            }
        }
        if (map.isSpace(x, y - 1)) {
            final MapS maptemp = new MapS(map);
            maptemp.setRed(x, y - 1);
            final int temp = this.minValue(maptemp, x, y - 1, xe, ye, depth - 1, alpha, beta);
            if (temp > value) {
                value = temp;
                direction = 2;
            }
        }
        if (map.isSpace(x + 1, y)) {
            final MapS maptemp = new MapS(map);
            maptemp.setRed(x + 1, y);
            final int temp = this.minValue(maptemp, x + 1, y, xe, ye, depth - 1, alpha, beta);
            if (temp > value) {
                value = temp;
                direction = 3;
            }
        }
        if (map.isSpace(x - 1, y)) {
            final MapS maptemp = new MapS(map);
            maptemp.setRed(x - 1, y);
            final int temp = this.minValue(maptemp, x - 1, y, xe, ye, depth - 1, alpha, beta);
            if (temp > value) {
                value = temp;
                direction = 1;
            }
        }
        System.out.println("V12: " + value);
        return direction;
    }
    
    private int maxValue(final MapS map, final int x, final int y, final int xe, final int ye, final int depth, int alpha, final int beta) {
        ++this.amountnode;
        int max = -80000;
        if (this.crack || this.enemyInside(map, xe, ye, x, y)) {
            if (depth > 0) {
                if (map.isSpace(x + 1, y)) {
                    final MapS maptemp = new MapS(map);
                    maptemp.setRed(x + 1, y);
                    final int temp = this.minValue(maptemp, x + 1, y, xe, ye, depth - 1, alpha, beta);
                    if (temp > max) {
                        max = temp;
                    }
                    if (this.alphabeta) {
                        if (max >= beta) {
                            return max;
                        }
                        if (alpha < max) {
                            alpha = max;
                        }
                    }
                }
                if (map.isSpace(x - 1, y)) {
                    final MapS maptemp = new MapS(map);
                    maptemp.setRed(x - 1, y);
                    final int temp = this.minValue(maptemp, x - 1, y, xe, ye, depth - 1, alpha, beta);
                    if (temp > max) {
                        max = temp;
                    }
                    if (this.alphabeta) {
                        if (max >= beta) {
                            return max;
                        }
                        if (alpha < max) {
                            alpha = max;
                        }
                    }
                }
                if (map.isSpace(x, y + 1)) {
                    final MapS maptemp = new MapS(map);
                    maptemp.setRed(x, y + 1);
                    final int temp = this.minValue(maptemp, x, y + 1, xe, ye, depth - 1, alpha, beta);
                    if (temp > max) {
                        max = temp;
                    }
                    if (this.alphabeta) {
                        if (max >= beta) {
                            return max;
                        }
                        if (alpha < max) {
                            alpha = max;
                        }
                    }
                }
                if (map.isSpace(x, y - 1)) {
                    final MapS maptemp = new MapS(map);
                    maptemp.setRed(x, y - 1);
                    final int temp = this.minValue(maptemp, x, y - 1, xe, ye, depth - 1, alpha, beta);
                    if (temp > max) {
                        max = temp;
                    }
                    if (this.alphabeta) {
                        if (max >= beta) {
                            return max;
                        }
                        if (alpha < max) {
                            alpha = max;
                        }
                    }
                }
            }
            else {
                max = 15 * this.luonggia(new MapS(map), x, y, xe, ye, true) + 11 * this.luonggiacanh(new MapS(map), x, y, xe, ye, true);
            }
            if (max == -80000) {
                max = -40000 - depth;
            }
            return max;
        }
        final int t = 15 * this.luonggiaOutside(new MapS(map), x, y, xe, ye) + 11 * this.luonggiacanh(new MapS(map), x, y, xe, ye, true);
        if (t > 1 || t < -1) {
            return t * 5;
        }
        return t;
    }
    
    private int minValue(final MapS map, final int x, final int y, final int xe, final int ye, final int depth, final int alpha, int beta) {
        ++this.amountnode;
        int min = 80000;
        if (this.crack || this.enemyInside(map, xe, ye, x, y)) {
            if (map.isSpace(xe + 1, ye)) {
                final MapS maptemp = new MapS(map);
                maptemp.setGreen(xe + 1, ye);
                final int temp = this.maxValue(maptemp, x, y, xe + 1, ye, depth - 1, alpha, beta);
                if (temp < min) {
                    min = temp;
                }
                if (this.alphabeta) {
                    if (min <= alpha) {
                        return min;
                    }
                    beta = ((beta < min) ? beta : min);
                }
            }
            if (map.isSpace(xe - 1, ye)) {
                final MapS maptemp = new MapS(map);
                maptemp.setGreen(xe - 1, ye);
                final int temp = this.maxValue(maptemp, x, y, xe - 1, ye, depth - 1, alpha, beta);
                if (temp < min) {
                    min = temp;
                }
                if (this.alphabeta) {
                    if (min <= alpha) {
                        return min;
                    }
                    beta = ((beta < min) ? beta : min);
                }
            }
            if (map.isSpace(xe, ye + 1)) {
                final MapS maptemp = new MapS(map);
                maptemp.setGreen(xe, ye + 1);
                final int temp = this.maxValue(maptemp, x, y, xe, ye + 1, depth - 1, alpha, beta);
                if (temp < min) {
                    min = temp;
                }
                if (this.alphabeta) {
                    if (min <= alpha) {
                        return min;
                    }
                    beta = ((beta < min) ? beta : min);
                }
            }
            if (map.isSpace(xe, ye - 1)) {
                final MapS maptemp = new MapS(map);
                maptemp.setGreen(xe, ye - 1);
                final int temp = this.maxValue(maptemp, x, y, xe, ye - 1, depth - 1, alpha, beta);
                if (temp < min) {
                    min = temp;
                }
                if (this.alphabeta) {
                    if (min <= alpha) {
                        return min;
                    }
                    beta = ((beta < min) ? beta : min);
                }
            }
            if (min == 80000) {
                min = 40000 + depth;
            }
            return min;
        }
        final int t = 15 * this.luonggiaOutside(new MapS(map), x, y, xe, ye) + 11 * this.luonggiacanh(new MapS(map), x, y, xe, ye, false);
        if (t > 1 || t < -1) {
            return t * 5;
        }
        return t;
    }
    
    private int luonggiaOutside(final MapS m, final int x, final int y, final int xe, final int ye) {
        int mysum = 0;
        int hissum = 0;
        int black = 0;
        int white = 0;
        final ArrayList<Point> arp = new ArrayList<Point>();
        arp.add(new Point(x, y));
        boolean blackturn = true;
        while (!arp.isEmpty()) {
            if (blackturn) {
                black += this.redGo(arp, m);
                blackturn = false;
            }
            else {
                white += this.redGo(arp, m);
                blackturn = true;
            }
        }
        mysum = white + black;
        if (white > black) {
            mysum -= white - black;
        }
        else if (white < black - 1) {
            mysum -= black - 1 - white;
        }
        white = (black = 0);
        arp.add(new Point(xe, ye));
        blackturn = true;
        while (!arp.isEmpty()) {
            if (blackturn) {
                black += this.redGo(arp, m);
                blackturn = false;
            }
            else {
                white += this.redGo(arp, m);
                blackturn = true;
            }
        }
        hissum = white + black;
        if (hissum <= 0) {
            if (white > black) {
                hissum -= white - black;
            }
            else if (white < black - 1) {
                hissum -= black - 1 - white;
            }
        }
        return mysum - hissum;
    }
    
    public int luonggia(final MapS map, final int x, final int y, final int xe, final int ye, final boolean ismyturn) {
        final ArrayList<Point> red = new ArrayList<Point>();
        final ArrayList<Point> green = new ArrayList<Point>();
        red.add(new Point(x, y));
        green.add(new Point(xe, ye));
        int sumred = 0;
        int sumgreen = 0;
        if (!this.crack) {
            if (ismyturn) {
                while (!red.isEmpty() || !green.isEmpty()) {
                    sumred += this.redGo(red, map);
                    sumgreen += this.greenGo(green, map);
                }
            }
            else {
                while (!red.isEmpty() || !green.isEmpty()) {
                    sumgreen += this.greenGo(green, map);
                    sumred += this.redGo(red, map);
                }
            }
        }
        else {
            while (!red.isEmpty()) {
                sumred += this.redGo(red, map);
            }
        }
        return sumred - sumgreen;
    }
    
    private int redGo(final ArrayList<Point> red, final MapS map) {
        final ArrayList<Point> redtemp = new ArrayList<Point>();
        int sumred = 0;
        while (!red.isEmpty()) {
            final Point point = red.get(0);
            final int x = point.x;
            final int y = point.y;
            if (map.isSpace(x + 1, y)) {
                sumred += point(map,x+1,y);
                map.setRed(x + 1, y);
                redtemp.add(new Point(x + 1, y));
            }
            if (map.isSpace(x - 1, y)) {
                sumred += point(map,x-1,y);
                map.setRed(x - 1, y);
                redtemp.add(new Point(x - 1, y));
            }
            if (map.isSpace(x, y + 1)) {
                sumred += point(map,x,y+1);
                map.setRed(x, y + 1);
                redtemp.add(new Point(x, y + 1));
            }
            if (map.isSpace(x, y - 1)) {
                sumred += point(map,x,y-1);
                map.setRed(x, y - 1);
                redtemp.add(new Point(x, y - 1));
            }
            red.remove(0);
        }
        for (int i = 0; i < redtemp.size(); ++i) {
            red.add(redtemp.get(i));
        }
        return sumred;
    }
    
    private int greenGo(final ArrayList<Point> green, final MapS map) {
        final ArrayList<Point> greentemp = new ArrayList<Point>();
        int sumgreen = 0;
        while (!green.isEmpty()) {
            final Point point = green.get(0);
            final int x = point.x;
            final int y = point.y;
            if (map.isSpace(x + 1, y)) {
                sumgreen += point(map,x+1,y);
                map.setGreen(x + 1, y);
                greentemp.add(new Point(x + 1, y));
            }
            if (map.isSpace(x - 1, y)) {
                sumgreen += point(map,x-1,y);
                map.setGreen(x - 1, y);
                greentemp.add(new Point(x - 1, y));
            }
            if (map.isSpace(x, y + 1)) {
                sumgreen += point(map,x,y+1);
                map.setGreen(x, y + 1);
                greentemp.add(new Point(x, y + 1));
            }
            if (map.isSpace(x, y - 1)) {
                sumgreen += point(map,x,y-1);
                map.setGreen(x, y - 1);
                greentemp.add(new Point(x, y - 1));
            }
            green.remove(0);
        }
        for (int i = 0; i < greentemp.size(); ++i) {
            green.add(greentemp.get(i));
        }
        return sumgreen;
    }
    
    private boolean enemyInside(final MapS m, final int xg, final int yg, final int xr, final int yr) {
        final MapS map = new MapS(m);
        final Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(xr, yr));
        while (!queue.isEmpty()) {
            final Point element = queue.remove();
            final int x = element.x;
            final int y = element.y;
            if (map.isSpace(x + 1, y)) {
                map.setMap(x + 1, y);
                queue.add(new Point(x + 1, y));
            }
            if (map.isSpace(x - 1, y)) {
                map.setMap(x - 1, y);
                queue.add(new Point(x - 1, y));
            }
            if (map.isSpace(x, y - 1)) {
                map.setMap(x, y - 1);
                queue.add(new Point(x, y - 1));
            }
            if (map.isSpace(x, y + 1)) {
                map.setMap(x, y + 1);
                queue.add(new Point(x, y + 1));
            }
        }
        return map.isReachable(xg + 1, yg) || map.isReachable(xg - 1, yg) || map.isReachable(xg, yg + 1) || map.isReachable(xg, yg - 1);
    }
    private int point(final MapS map,int x, int y){
        switch(map.amountSpacesAround(x, y)){
            case 1: return 0;
            case 2: return 3;
            case 3: return 5;
            case 4: return 6;
            default : return 0;
    }
    }
    private int greenGo1(final ArrayList<Point> green, final MapS map) {
        final ArrayList<Point> greentemp = new ArrayList<Point>();
        int sumgreen = 0;
        while (!green.isEmpty()) {
            final Point point = green.get(0);
            final int x = point.x;
            final int y = point.y;
            if (map.isSpace(x + 1, y)) {
                ++sumgreen;
                map.setGreen(x + 1, y);
                greentemp.add(new Point(x + 1, y));
            }
            if (map.isSpace(x - 1, y)) {
                ++sumgreen;
                map.setGreen(x - 1, y);
                greentemp.add(new Point(x - 1, y));
            }
            if (map.isSpace(x, y + 1)) {
                ++sumgreen;
                map.setGreen(x, y + 1);
                greentemp.add(new Point(x, y + 1));
            }
            if (map.isSpace(x, y - 1)) {
                ++sumgreen;
                map.setGreen(x, y - 1);
                greentemp.add(new Point(x, y - 1));
            }
            green.remove(0);
        }
        for (int i = 0; i < greentemp.size(); ++i) {
            green.add(greentemp.get(i));
        }
        return sumgreen;
    }
    
    private int redGo1(final ArrayList<Point> red, final MapS map) {
        final ArrayList<Point> redtemp = new ArrayList<Point>();
        int sumred = 0;
        while (!red.isEmpty()) {
            final Point point = red.get(0);
            final int x = point.x;
            final int y = point.y;
            if (map.isSpace(x + 1, y)) {
                ++sumred;
                map.setRed(x + 1, y);
                redtemp.add(new Point(x + 1, y));
            }
            if (map.isSpace(x - 1, y)) {
                ++sumred;
                map.setRed(x - 1, y);
                redtemp.add(new Point(x - 1, y));
            }
            if (map.isSpace(x, y + 1)) {
                ++sumred;
                map.setRed(x, y + 1);
                redtemp.add(new Point(x, y + 1));
            }
            if (map.isSpace(x, y - 1)) {
                ++sumred;
                map.setRed(x, y - 1);
                redtemp.add(new Point(x, y - 1));
            }
            red.remove(0);
        }
        for (int i = 0; i < redtemp.size(); ++i) {
            red.add(redtemp.get(i));
        }
        return sumred;
    }
}
