package ahodanenok.algs4.ch_1_1;

/**
 * Exercise 1.1.24
 */
public class Euclid {

    private static final boolean DEBUG = "true".equals(System.getProperty(Euclid.class.getName() + ".DEBUG"));

    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        int d = p >= q ? gcd(p, q) : gcd(q, p);
        System.out.printf("gcd(%d, %d) = %d", p, q, d);
    }

    public static int gcd(int p, int q) {
        if (DEBUG) {
            System.out.printf("DEBUG: p=%d, q=%d%n", p, q);
        }

        int r = p % q;
        if (r == 0) {
            return q;
        }

        return gcd(q, r);
    }
}
