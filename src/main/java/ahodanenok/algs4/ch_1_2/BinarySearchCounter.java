package ahodanenok.algs4.ch_1_2;

import ahodanenok.algs4.ch_1_1.BinarySearch;
import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/**
 * Book, exercise 1.2.9
 */
public class BinarySearchCounter {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] numbers = StdIn.readAllInts();
        Counter counter = new Counter("keys");

        Arrays.sort(numbers);
        System.out.println("Rank: " + BinarySearch.rank(numbers, n, counter));
        System.out.println("Keys examined: " + counter.tally());
    }
}
