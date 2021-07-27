package ahodanenok.algs4.ch_1_2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Book, exercise 1.2.3
 */
public class IntersectingIntervals2D {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);

        Interval2DExt[] intervals = new Interval2DExt[n];
        for (int i = 0; i < intervals.length; i++) {
            double xMin = StdRandom.uniform(min, max);
            double xMax = StdRandom.uniform(xMin, max);
            double yMin = StdRandom.uniform(min, max);
            double yMax = StdRandom.uniform(yMin, max);

            intervals[i] = new Interval2DExt(new Interval1D(xMin, xMax),new Interval1D(yMin, yMax));
        }

        StdDraw.setScale(min - min * 0.1, max + max * 0.1);
        for (Interval2DExt interval : intervals) {
            // don't want white color to appear
            StdDraw.setPenColor(StdRandom.uniform(128), StdRandom.uniform(256), StdRandom.uniform(256));
            interval.draw();
        }

        Result result = count(intervals);
        System.out.println("Intersections: " + result.intersectCount);
        System.out.println("Contained:     " + result.containedCount);
    }

    private static Result count(Interval2DExt[] intervals) {
        int intersectCount = 0;
        int containedCount = 0;

        // being simple here
        for (int i = 0; i < intervals.length; i++) {
            Interval2DExt a = intervals[i];
            for (int j = 0; j < i; j++) {
                Interval2DExt b = intervals[j];
                if (a.intersects(b)) {
                    intersectCount++;

                    // for some interval to contain another they must intersect at first
                    if (a.contains(b) || b.contains(a)) {
                        containedCount++;
                    }
                }
            }
        }

        return new Result(intersectCount, containedCount);
    }

    // Subclass is needed to get x, y coordinates as Interval2D doesn't expose them
    private static class Interval2DExt extends Interval2D {

        private final Interval1D x;
        private final Interval1D y;

        public Interval2DExt(Interval1D x, Interval1D y) {
            super(x, y);
            this.x = x;
            this.y = y;
        }

        public boolean contains(Interval2DExt other) {
            return other.x.min() >= x.min()
                    && other.x.max() <= x.max()
                    && other.y.min() >= y.min()
                    && other.y.max() <= y.max();
        }
    }

    private static class Result {

        final int intersectCount;
        final int containedCount;

        public Result(int intersectCount, int containedCount) {
            this.intersectCount = intersectCount;
            this.containedCount = containedCount;
        }
    }
}
