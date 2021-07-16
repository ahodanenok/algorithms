package ahodanenok.algs4.ch_1_1;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/**
 * Web, exercise 1.1.1
 * https://algs4.cs.princeton.edu/11model/
 */
public class Sattolo {

    public static void main(String[] args) {
        int[] array = StdIn.readAllInts();
        cycle(array);
        System.out.println(Arrays.toString(array));
    }

    public static void cycle(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            int j = (int) (Math.random() * i);
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }
}
