package ahodanenok.algs4.ch_1_1;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

/**
 * Web, exercise 1.1.3
 * https://algs4.cs.princeton.edu/11model/
 */
public class RightTriangle {

    private static final double RADIUS = 10;

    public static void main(String[] args) {
        StdDraw.setScale(-RADIUS - RADIUS * 0.1, RADIUS + RADIUS * 0.1);
        StdDraw.setPenColor(Color.BLUE);
        StdDraw.circle(0, 0, RADIUS);

        double x = RADIUS / 2;
        double y =  Math.sqrt(RADIUS * RADIUS - x * x);

        StdDraw.line(x, y, x, -y);
        StdDraw.line(x, -y, -x, -y);
        StdDraw.line(x, y, -x, -y);
    }
}
