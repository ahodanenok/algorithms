package ahodanenok.algs4.ch_1_3;

import java.util.Iterator;

/**
 * Web, exercise 1.3.20
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class Mesh implements Iterable<Double> {

    public static void main(String[] args) {
        double start = Double.parseDouble(args[0]);
        double end = Double.parseDouble(args[1]);
        double delta = Double.parseDouble(args[2]);

        for (double p : new Mesh(start, end, delta)) {
            System.out.println(p);
        }
    }

    private final double start;
    private final double delta;
    private final int pointsCount;

    public Mesh(double start, double end, double delta) {
        if (delta == 0) {
            throw new IllegalArgumentException("Delta is 0");
        }

        double segmentsCount = (end - start) / delta;
        // start > end (delta must be < 0)
        // start =< end (delta must be > 0)
        // in both cases the number of segments will be a positive number
        if (segmentsCount < 0) {
            throw new IllegalArgumentException("Forever Loop!");
        }

        this.start = start;
        this.delta = delta;

        // +1 because end is inclusive
        this.pointsCount = (int) Math.floor(segmentsCount) + 1;
    }

    @Override
    public Iterator<Double> iterator() {
        return new Iterator<Double>() {

            private double point = start;
            private int pointNum = 0;

            @Override
            public boolean hasNext() {
                return pointNum < pointsCount;
            }

            @Override
            public Double next() {
                Double currentPoint = point;
                point += delta;
                pointNum++;

                return currentPoint;
            }
        };
    }
}
