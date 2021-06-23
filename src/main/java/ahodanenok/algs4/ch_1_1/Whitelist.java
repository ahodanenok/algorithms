package ahodanenok.algs4.ch_1_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/**
 * Exercise 1.1.23
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
}
