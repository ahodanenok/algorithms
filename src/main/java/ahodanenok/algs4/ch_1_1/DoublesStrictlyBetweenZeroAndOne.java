package ahodanenok.algs4.ch_1_1;

/**
 * Book, exercise 1.1.5
 */
public class DoublesStrictlyBetweenZeroAndOne {

    public static void main(String[] args) throws Exception {
        impl(args, System.out);
    }

    static void impl(String[] args, Appendable out) throws Exception {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);

        if (x > 0 && x < 1 && y > 0 && y < 1) {
            out.append("true");
        } else {
            out.append("false");
        }
    }
}
