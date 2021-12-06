package ahodanenok.algs4.ch_1_4;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Book, exercise 1.4.38
 */
public class NaiveThreeSum {

    public static void main(String[] args) {
        DoublingTestClient doublingTest = new DoublingTestClient();
        doublingTest.addAlgorithm(new DoublingTestClient.Algorithm() {
            @Override
            public String getName() {
                return "NaiveThreeSum";
            }

            @Override
            public long execute(int n) {
                int[] array = getArray(n);
                long t = System.currentTimeMillis();
                NaiveThreeSum.count(array);
                return System.currentTimeMillis() - t;
            }
        });
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
        doublingTest.run();
    }

    private static int[] array;
    private static int[] getArray(int n) {
        if (array != null && array.length == n) {
            return array;
        }

        array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = StdRandom.uniform(0, n);
        }

        return array;
    }

    // taken from the exercise
    public static int count(int[] a) {
        int cnt = 0;
        int N = a.length;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                for (int k = 0; k < N; k++)
                    if (i < j && j < k)
                        if (a[i] + a[j] + a[k] == 0)
                            cnt++;

        return cnt;
    }
}
