package ahodanenok.algs4.ch_1_1;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * Exercise 1.1.39
 */
public class RandomMatches {

    public static void main(String[] args) {
        int t = Integer.parseInt(args[0]);
        runAndPrintExperiment(1_000, t);
        runAndPrintExperiment(10_000, t);
        runAndPrintExperiment(100_000, t);
        runAndPrintExperiment(1_000_000, t);
    }

    private static void runAndPrintExperiment(int n, int t) {
        long matches = 0;
        for (int i = 0; i < t; i++) {
            matches += runSingleExperiment(n);
        }

        long avgMatches = matches / t;
        System.out.printf("N=%-9d  %d%n", n, avgMatches);
    }

    private static int runSingleExperiment(int n) {
        int[] a = createSortedArray(n);
        int[] b = createSortedArray(n);

        int matches = 0;
        for (int item : a) {
            if (BinarySearch.rank(b, item) >= 0) {
                matches++;
            }
        }

        return matches;
    }

    private static int[] createSortedArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = StdRandom.uniform(1_000_000);
        }

        Arrays.sort(array);
        return array;
    }
}
