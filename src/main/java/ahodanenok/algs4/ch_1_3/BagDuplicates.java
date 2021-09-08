package ahodanenok.algs4.ch_1_3;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Objects;

/**
 * Web, exercise 1.3.16
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class BagDuplicates {

    public static void main(String[] args) {
        int itemsCount = 20;
        int itemsRangeStart = 0;
        int itemsRangeEnd = 200;

        Bag<Integer> bag = new Bag<>();
        for (int i = 0; i < itemsCount; i++) {
            bag.add(StdRandom.uniform(itemsRangeStart, itemsRangeEnd));
        }

        System.out.println(bag);
        System.out.println("Contains duplicates: " + containsDuplicates(bag));
    }

    public static <T> boolean containsDuplicates(Bag<T> bag) {
        int i = 0;
        for (T a : bag) {
            int j = 0;
            for (T b : bag) {
                if (i != j && Objects.equals(a, b)) {
                    return true;
                }

                j++;
            }

            i++;
        }

        return false;
    }
}
