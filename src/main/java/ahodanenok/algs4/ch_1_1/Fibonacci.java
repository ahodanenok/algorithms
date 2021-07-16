package ahodanenok.algs4.ch_1_1;

import java.math.BigInteger;

/**
 * Book, exercise 1.1.19
 */
public class Fibonacci {

    private static final int NUMBERS_COUNT = 100;
    private static final BigInteger[] computed = new BigInteger[NUMBERS_COUNT];

    public static void main(String[] args) {
        for (int n = 0; n < NUMBERS_COUNT; n++) {
            System.out.printf("%2s = %d%n", n, f(n));
        }
    }

    public static BigInteger f(int n) {
        if (n < computed.length && computed[n] != null) {
            return computed[n];
        }

        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;

        BigInteger result = f(n - 2).add(f(n - 1));
        if (n < computed.length) {
            computed[n] = result;
        }

        return result;
    }
}
