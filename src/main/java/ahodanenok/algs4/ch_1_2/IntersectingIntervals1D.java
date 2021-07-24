package ahodanenok.algs4.ch_1_2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/**
 * Book, exercise 1.2.2
 */
public class IntersectingIntervals1D {

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(args[0]);

        Interval1D[] intervals = new Interval1D[n];
        for (int i = 0; i < intervals.length; i++) {
            String[] parts = StdIn.readLine().split(" ");
            intervals[i] = new Interval1D(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
        }

        IntersectingIntervals1D.print(intervals, System.out);
    }

    public static void print(Interval1D[] intervals, Appendable out) throws Exception {
        Arrays.sort(intervals, Interval1D.MAX_ENDPOINT_ORDER);
        for (int i = 0; i < intervals.length; i++) {
            Interval1D a = intervals[i];
            // if there are multiple intervals intersecting the current,
            // they will be printed in max-endpoint descending order within a group
            for (int j = i - 1; j >= 0; j--) {
                Interval1D b = intervals[j];
                if (a.intersects(b)) {
                    out.append(String.format("%s %s%n", b, a));
                } else {
                    break;
                }
            }
        }
    }
}
