package ahodanenok.algs4.ch_1_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/**
 * Book, exercise 1.1.23
 */
public class Whitelist {

    private enum Mode {
        PRESENT,
        MISSING
    }

    public static void main(String[] args) {
        int[] whitelist = new In(args[0]).readAllInts();
        Mode mode = getMode(args);

        Arrays.sort(whitelist);

        // Book, exercise 1.1.28
        whitelist = removeDuplicates(whitelist);

        while (!StdIn.isEmpty()) {
            int n = StdIn.readInt();
            boolean present = BinarySearch.rank(whitelist, n) >= 0;
            if (present && mode == Mode.PRESENT) {
                System.out.println(n);
            } else if (!present && mode == Mode.MISSING) {
                System.out.println(n);
            }
        }
    }

    private static Mode getMode(String[] args) {
        if (args.length < 2) {
            return Mode.MISSING;
        }

        String modeArg = args[1];
        if ("+".equals(modeArg)) {
            return Mode.MISSING;
        } else if ("-".equals(modeArg)) {
            return Mode.PRESENT;
        } else {
            throw new IllegalArgumentException("unknown mode '" + modeArg + "'");
        }
    }

    /**
     * Book, exercise 1.1.28
     */
    public static int[] removeDuplicates(int[] array) {
        if (array.length < 2) {
            return array;
        }

        int pos = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[pos] != array[i]) {
                pos++;
                array[pos] = array[i];
            }
        }

        return Arrays.copyOf(array, pos + 1);
    }
}
