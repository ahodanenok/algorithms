package ahodanenok.algs4.ch_1_4;

import java.util.ArrayList;
import java.util.List;

/**
 * Book, exercise 1.4.12
 */
public class CommonItems {

    public static List<Integer> count(int[] a, int[] b) {
        List<Integer> common = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                i++;
            } else if (b[j] < a[i]) {
                j++;
            } else {
                common.add(a[i]);
                i++;
                j++;
            }
        }

        return common;
    }
}
