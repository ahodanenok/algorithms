package ahodanenok.algs4.ch_1_1;

/**
 * Book, exercise 1.1.9
 */
public class ToBinary {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println(convert(n));
    }

    static String convert(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be >= 0");
        }

        String result = "";
        int remaining = n;
        do {
            result = (remaining & 1) + result;
            remaining >>= 1;
        } while (remaining > 0);

        return result;
    }
}
