package ahodanenok.algs4.ch_1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * Exercise 1.1.38
 */
public class BruteForceSearch {

    public static void main(String[] args) {
        int[] array = StdIn.readAllInts();
        if (array.length == 0) {
            return;
        }

        Arrays.sort(array);

        System.out.printf("Searching in array of %d elements%n", array.length);
        System.out.println("Brute Force  Binary Search");

        // force java to load the class
        BinarySearch.rank(array, 0);

        int experiments = 100;
        double bruteForceTotal = 0;
        double binarySearchTotal = 0;
        for (int i = 0; i < experiments; i++) {
            int pos = StdRandom.uniform(array.length * 2);
            int n = pos < array.length ? array[pos] : pos;

            long t = System.nanoTime();
            boolean bruteForceFound = BruteForceSearch.rank(array, n) > -1;
            double bruteForceTook = (System.nanoTime() - t) / 1_000_000.0;
            bruteForceTotal += bruteForceTook;

            t = System.nanoTime();
            boolean binarySearchFound = BinarySearch.rank(array, n) > -1;
            double binarySearchTook = (System.nanoTime() - t) / 1_000_000.0;
            binarySearchTotal += binarySearchTook;

            if (bruteForceFound != binarySearchFound) {
                throw new IllegalStateException("Hmm...");
            }

            System.out.printf("%9.4fms    %9.4fms  %s%n",
                    bruteForceTook, binarySearchTook, bruteForceFound ? "" : "not found");
        }

        System.out.println();
        System.out.println("Average:");
        System.out.printf("%9.4fms    %9.4fms%n", bruteForceTotal / experiments, binarySearchTotal / experiments);
    }

    private static int rank(int[] array, int n) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                return i;
            }
        }

        return -1;
    }
}
