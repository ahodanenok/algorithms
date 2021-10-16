package ahodanenok.algs4.ch_1_4;

/**
 * Book, exercise 1.4.22
 */
public class BinarySearchAddSub {

    public static int find(int[] numbers, int n) {
        int fp = 1; // f(k-1)
        int fc = 1; // f(k)

        int i = 0;
        while (true) {
            int fm = fc - fp; // f(k-2)
            if (fm < 0) {
                break;
            }

            int j = i + fm;
            if (j >= numbers.length || n < numbers[j]) {
                fc = fm;  // f(k)   = f(k-2)
                fp -= fm; // f(k-1) = f(k-3)
            } else if (n > numbers[j]) {
                i += fm;
                fc += fp;     // f(k)   = f(k+1)
                fp = fc - fp; // f(k-1) = f(k)
            } else {
                return j;
            }
        }

        return -1;
    }
}
