package ahodanenok.algs4.ch_1_2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * Book, exercise 1.2.1
 */
public class ClosestPoints {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        Point2D[] points = new Point2D[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point2D(StdRandom.uniform(), StdRandom.uniform());
        }

        System.out.println("Points:");
        for (Point2D p : points) {
            System.out.println("  " + p);
        }

        System.out.println();
        System.out.println("Distance: " + distance(points));
    }

    public static double distance(Point2D[] points) {
        if (points.length < 2) {
            return 0;
        }

        Arrays.sort(points, Point2D.X_ORDER);
        return distanceInternal(points, new Point2D[points.length], 0, points.length);
    }

    private static double distanceInternal(Point2D[] points, Point2D[] scratchpad, int from, int to) {
        if (to - from < 2) {
            return Double.MAX_VALUE;
        }

        if (to - from == 2) {
            return points[from].distanceTo(points[to - 1]);
        }

        int mid = from + (to - from) / 2;
        double distance = Math.min( // divide & conquer
                distanceInternal(points, scratchpad, from, mid),
                distanceInternal(points, scratchpad, mid, to));

        int stripLeft = mid;
        while (stripLeft >= 0 && points[mid].x() - points[stripLeft].x() < distance) {
            scratchpad[stripLeft] = points[stripLeft];
            stripLeft--;
        }

        int stripRight = mid;
        while (stripRight < points.length && points[stripRight].x() - points[mid].x() < distance) {
            scratchpad[stripRight] = points[stripRight];
            stripRight++;
        }

        // if slab contains only one point there is nothing to check
        if (stripRight - stripLeft < 2) {
            return distance;
        }

        int stripFrom = stripLeft + 1;
        int stripTo = stripRight;

        Arrays.sort(scratchpad, stripFrom, stripTo, Point2D.Y_ORDER);
        for (int i = stripFrom; i < stripTo; i++) {
            // don't check all points as it will be n^2 then
            // instead check only the points which are near in the array
            // https://www.cs.cmu.edu/~ckingsf/bioinfo-lectures/closepoints.pdf
            for (int j = Math.max(stripFrom, i - 15); j < i; j++) {
                distance = Math.min(distance, scratchpad[i].distanceTo(scratchpad[j]));
            }
        }

        return distance;
    }

    // see ahodanenok.algs4.ch_1_2.ClosestPointsTest.testRandomPoints
    public static double bruteForceDistance(Point2D[] points) {
        if (points.length < 2) {
            return 0;
        }

        double distance = Double.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < i; j++) {
                distance = Math.min(distance, points[i].distanceTo(points[j]));
            }
        }

        return distance;
    }
}
