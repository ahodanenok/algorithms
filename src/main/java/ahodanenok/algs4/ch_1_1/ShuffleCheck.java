package ahodanenok.algs4.ch_1_1;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Exercise 1.1.36
 */
public class ShuffleCheck {

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        Consumer<int[]> shuffle;
        if ("bad".equals(System.getProperty("shuffle"))) {
            shuffle = ShuffleCheck::badShuffle;
        } else {
            shuffle = ShuffleCheck::shuffle;
        }

        int[] numbers = new int[m];
        int[][] occurrences = new int[numbers.length][numbers.length];
        for (int i = 0; i < n; i++) {
            // reinitialize numbers before each shuffle
            for (int j = 0; j < numbers.length; j++) {
                numbers[j] = j;
            }

            shuffle.accept(numbers);
            for (int j = 0; j < numbers.length; j++) {
                occurrences[numbers[j]][j]++;
            }
        }

        printOccurrences(occurrences);
    }

    private static void printOccurrences(int[][] occurrences) {
        // +1 to add padding on the left
        int prefixWidth = Integer.toString(occurrences.length).length() + 1;
        int columnWidth = Integer.toString(
            Arrays.stream(occurrences)
                .mapToInt(arr -> Arrays.stream(arr).max().orElse(0))
                .max()
                .orElse(0)
        ).length() + 1;

        // print header
        System.out.printf("%" + prefixWidth + "s", "");
        for (int i = 0; i < occurrences.length; i++) {
            System.out.printf("%" + columnWidth + "d", i);
        }
        System.out.println();

        // print values
        for (int row = 0; row < occurrences.length; row++) {
            System.out.printf("% " + prefixWidth + "d", row);
            for (int i = 0; i < occurrences.length; i++) {
                System.out.printf("%" + columnWidth + "d", occurrences[row][i]);
            }
            System.out.println();
        }
    }

    /**
     * Exercise 1.1.37
     */
    public static void badShuffle(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int j = StdRandom.uniform(n);
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    // provided in the exercise
    public static void shuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++)
        { // Exchange a[i] with random element in a[i..N-1]
            int r = i + StdRandom.uniform(N-i);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
}
