package ahodanenok.algs4.ch_1_4;

/**
 * Book, exercise 1.4.34
 */
public class HotOrCold {

    public static void main(String[] args) {
        guess(100, 98);
    }

    // ~ 2 * log(N) implementation
    public static int guess(int n, int secret) {
        int lo = 1;
        int hi = n;
        int guessCount = 0;
        int guessNumber = -1;

        while (lo <= hi) {
            guessCount++;
            int mid = lo + (hi - lo) / 2;
            if (mid == secret) {
                guessNumber = mid;
                break;
            }

            int distanceLeft;
            if (mid > lo) {
                guessCount++;
                distanceLeft = Math.abs(mid - 1 - secret);
            } else {
                distanceLeft = Integer.MAX_VALUE;
            }

            int distanceRight = Math.abs(mid - secret);
            if (distanceLeft < distanceRight) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (guessNumber != secret) {
            return -1;
        }

        return guessCount;
    }
}
