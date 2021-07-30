package ahodanenok.algs4.ch_1_2;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

/**
 * Book, exercise 1.2.10
 */
public class VisualCounter {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);

        StdDraw.setXscale(0, n);
        StdDraw.setYscale(-max - max * 0.1, max + max * 0.1);
        StdDraw.setPenColor(Color.RED);

        VisualCounter counter = new VisualCounter(max);
        for (int i = 0; i < n; i++) {
            if (Math.random() < 0.5) {
                counter.increment();
            } else {
                counter.decrement();
            }

            StdDraw.point(i, counter.tally());
        }
    }


    private final int max;
    private int value;

    public VisualCounter(int max) {
        this.max = max;
    }

    public void increment() {
        if (value < max) {
            value++;
        }
    }

    public void decrement() {
        if (value > -max) {
            value--;
        }
    }

    public int tally() {
        return value;
    }
}
