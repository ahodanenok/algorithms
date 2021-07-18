package ahodanenok.algs4.ch_1_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Web, exercise 1.1.4
 * https://algs4.cs.princeton.edu/11model/
 */
public class BouncingBall {

    private static final double MIN_X = 0;
    private static final double MAX_X = 10;

    private static final double MIN_Y = 0;
    private static final double MAX_Y = 10;

    private static final double RADIUS = 0.5;
    private static final int DELAY = 10; //ms

    private static final double INITIAL_DX = 0.05;
    private static final double INITIAL_DY = 0.05;

    public static void main(String[] args) {
        double x = StdRandom.uniform(MIN_X, MAX_X);
        double y = MIN_Y;

        double dx = INITIAL_DX;
        double dy = INITIAL_DY;

        StdDraw.setXscale(MIN_X - RADIUS, MAX_X + RADIUS);
        StdDraw.setYscale(MIN_Y - RADIUS, MAX_Y + RADIUS);
        while (true) {
            StdDraw.clear();
            StdDraw.filledCircle(x, y, RADIUS);
            StdDraw.pause(DELAY);

            // change directions on each bounce a little bit
            if (x + dx < MIN_X || x + dx > MAX_X) {
                dx = -dx * StdRandom.uniform(0.9, 1.1);
            }
            if (y + dy < MIN_Y || y + dy > MAX_Y) {
                dy = -dy * StdRandom.uniform(0.9, 1.1);
            }

            x += dx;
            y += dy;
        }
    }
}
