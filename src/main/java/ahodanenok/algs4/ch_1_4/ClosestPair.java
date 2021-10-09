package ahodanenok.algs4.ch_1_4;

import java.util.Arrays;

/**
 * Book, exercise 1.4.16
 */
public class ClosestPair {

    private static final Pair INFINITY = new Pair(0, Double.POSITIVE_INFINITY);

    public static Pair find(double[] numbers) {
        Arrays.sort(numbers);
        return find(numbers, 0, numbers.length - 1);
    }

    public static Pair find(double[] numbers, int from, int to) {
        if (to - from < 1) {
            return null;
        }

        if (to - from == 1) {
            return new Pair(numbers[from], numbers[from + 1]);
        }

        int mid = from + (to - from) / 2;

        Pair left = find(numbers, from, mid);
        if (left == null) {
            left = INFINITY;
        }

        Pair right = find(numbers, mid, to);
        if (right == null) {
            right = INFINITY;
        }

        if (left.distance() <= right.distance()) {
            return left;
        } else {
            return right;
        }
    }

    public static class Pair {

        final double a;
        final double b;

        public Pair(double a, double b) {
            this.a = a;
            this.b = b;
        }

        public double distance() {
            return Math.abs(a - b);
        }

        @Override
        // hashCode not needed here
        public boolean equals(Object obj) {
            Pair other = (Pair) obj;
            return a == other.a && b == other.b;
        }

        @Override
        public String toString() {
            return "(" + a + ", " + b + ")";
        }
    }
}
