package ahodanenok.algs4.ch_1_2;

/**
 * Book, exercise 1.2.6
 */
public class CircularRotation {

    public static void main(String[] args) {
        System.out.println(match(args[0], args[1]));
    }

    public static boolean match(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        if (a.isEmpty()) {
            return true;
        }

        // joining `a` to itself and then checking if `b` is in it is much better
        // but i've read about it after i did the exercise, so leaving my implementation

        next:
        for (int offset = 0, length = a.length(); offset < length; offset++) {
            for (int i = 0; i < length; i++) {
                if (a.charAt((i + offset) % length) != b.charAt(i)) {
                    continue next;
                }
            }

            return true;
        }

        return false;
    }
}
