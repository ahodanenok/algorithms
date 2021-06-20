package ahodanenok.algs4.ch_1_1;

import java.math.BigInteger;

/**
 * Exercise 1.1.20
 */
public class LnFactorial {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.printf("ln(%d!) = %f%n", n, ln(n));
        System.out.printf(" f(%d)  = %d%n", n, f(n));
    }

    public static double ln(int n) {
        return Math.log(f(n).doubleValue());
    }

    public static BigInteger f(int n) {
        if (n == 1) return BigInteger.ONE;
        return f(n - 1).multiply(BigInteger.valueOf(n));
    }
}
