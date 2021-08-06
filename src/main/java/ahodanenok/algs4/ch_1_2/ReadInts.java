package ahodanenok.algs4.ch_1_2;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/**
 * Book, exercise 1.2.15
 */
public class ReadInts {

    public static void main(String[] args) {
        String file = args[0];
        int[] numbers = read(file);

        System.out.println("Numbers count: " + numbers.length);
        if (numbers.length < 51) {
            System.out.println();
            for (int n : numbers) {
                System.out.println(n);
            }
        }
    }

    public static int[] read(String file) {
        int[] numbers = new int[10];
        int length = 0;
        // maximum array length is a bit lower than Integer.MAX_VALUE,
        // but don't remember exactly how much
        int maxLength = Integer.MAX_VALUE - 8;

        In in = new In(file);
        try {
            while (in.hasNextLine() && length < maxLength) {
                int n = Integer.parseInt(in.readLine().trim());
                if (length == numbers.length) {
                    int[] oldNumbers = numbers;

                    numbers = new int[Math.min(length * 2, maxLength)];
                    System.arraycopy(oldNumbers, 0, numbers, 0, length);
                }

                numbers[length] = n;
                length++;
            }
        } finally {
            in.close();
        }

        return Arrays.copyOf(numbers, length);
    }
}
