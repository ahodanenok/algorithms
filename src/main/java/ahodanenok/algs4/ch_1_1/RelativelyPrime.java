package ahodanenok.algs4.ch_1_1;

/**
 * Exercise 1.1.30
 */
public class RelativelyPrime {

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(args[0]);
        boolean[][] s = sieve(n);
        PrintBooleanArray.print(s, System.out);
    }

    public static boolean[][] sieve(int n) {
        boolean[][] s = new boolean[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                s[row][col] = Euclid.gcd(row + 1, col + 1) == 1;
            }
        }

        return s;
    }
}
