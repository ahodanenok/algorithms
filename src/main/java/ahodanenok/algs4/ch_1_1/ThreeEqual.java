package ahodanenok.algs4.ch_1_1;

/**
 * Exercise 1.1.3
 */
public class ThreeEqual {

    public static void main(String[] args) throws Exception {
        impl(args, System.out);
    }

    static void impl(String[] args, Appendable out) throws Exception {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        if (a == b && a == c) {
            out.append("equal");
        } else {
            out.append("not equal");
        }
    }
}
