package ahodanenok.algs4.ch_1_4;

/**
 * Book, exercise 1.4.17
 */
public class FurthestPoint {

    public static Pair find(double[] numbers) {
        if (numbers.length < 2) {
            return null;
        }

        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (double n : numbers) {
            min = Math.min(n, min);
            max = Math.max(n, max);
        }

        return new Pair(min, max);
    }
}
