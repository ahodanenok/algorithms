package ahodanenok.algs4.ch_1_4;

import edu.princeton.cs.algs4.StdIn;

/**
 * Book, exercise 1.4.2
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] numbers = StdIn.readAllInts();
        System.out.println(count(numbers));
    }

    public static int count(int[] numbers) {
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            long a = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                long b = numbers[j];
                for (int k = j + 1; k < numbers.length; k++) {
                    long c = numbers[k];
                    if (a + b + c == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
