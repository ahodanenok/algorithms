package ahodanenok.algs4.ch_1_1;

/**
 * Exercise 1.1.14
 */
public class Lg {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println(compute(n));
    }

    static int compute(int n) {
        int pow = 0;
        // skip the first position because it's already been counted in pow (2^0)
        for (int rn = n >> 1; rn > 0; rn >>= 1) {
            pow++;
        }

        return pow;
    }
}
