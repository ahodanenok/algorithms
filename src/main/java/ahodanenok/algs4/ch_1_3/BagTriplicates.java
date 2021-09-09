package ahodanenok.algs4.ch_1_3;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Objects;

/**
 * Web, exercise 1.3.17
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class BagTriplicates {

    public static void main(String[] args) {
        int itemsCount = 20;
        int itemsRangeStart = 0;
        int itemsRangeEnd = 100;

        Bag<Integer> bag = new Bag<>();
        for (int i = 0; i < itemsCount; i++) {
            bag.add(StdRandom.uniform(itemsRangeStart, itemsRangeEnd));
        }

        System.out.println(bag);
        System.out.println("Contains triplicates: " + containsTriplicates(bag));
    }

    public static <T> boolean containsTriplicates(Bag<T> bag) {
        int i = 0;
        for (T a : bag) {
            int j = 0;
            for (T b : bag) {
                int k = 0;
                for (T c : bag) {
                    if (i != j && j != k && i != k && Objects.equals(a, b) && Objects.equals(b, c)) {
                        return true;
                    }

                    k++;
                }

                j++;
            }

            i++;
        }

        return false;
    }
}
