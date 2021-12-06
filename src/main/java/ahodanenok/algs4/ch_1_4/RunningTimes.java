package ahodanenok.algs4.ch_1_4;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.ThreeSumFast;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Book, exercise 1.4.41
 */
public class RunningTimes {

    public static void main(String[] args) {
        DoublingTestClient doublingTest = new DoublingTestClient();
        doublingTest.setTrialsPerInputSize(5);
        doublingTest.addAlgorithm(new DoublingTestClient.Algorithm() {
            @Override
            public String getName() {
                return "ThreeSum";
            }

            @Override
            public long execute(int n) {
                int[] array = getArray(n);
                long t = System.currentTimeMillis();
                ThreeSum.count(array);
                return System.currentTimeMillis() - t;
            }
        });
        doublingTest.addAlgorithm(new DoublingTestClient.Algorithm() {
            @Override
            public String getName() {
                return "ThreeSumFast";
            }

            @Override
            public long execute(int n) {
                int[] array = getArray(n);
                long t = System.currentTimeMillis();
                ThreeSumFast.count(array);
                return System.currentTimeMillis() - t;
            }
        });
        doublingTest.addAlgorithm(new DoublingTestClient.Algorithm() {
            @Override
            public String getName() {
                return "ThreeSumFaster";
            }

            @Override
            public long execute(int n) {
                int[] array = getArray(n);
                long t = System.currentTimeMillis();
                ThreeSumFaster.count(array);
                return System.currentTimeMillis() - t;
            }
        });
        doublingTest.run();
    }

    private static int[] array;
    private static int[] getArray(int n) {
        if (array != null && array.length == n) {
            return Arrays.copyOf(array, array.length);
        }

        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() != n) {
            numbers.add(StdRandom.uniform(-2 *n, 2 *n));
        }

        array = numbers.stream().mapToInt(Integer::intValue).toArray();
        return array;
    }
}
