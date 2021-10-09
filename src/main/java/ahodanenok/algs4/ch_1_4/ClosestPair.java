package ahodanenok.algs4.ch_1_4;

import java.util.Arrays;

import static ahodanenok.algs4.ch_1_4.Pair.INFINITY;

/**
 * Book, exercise 1.4.16
 */
public class ClosestPair {

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
}
