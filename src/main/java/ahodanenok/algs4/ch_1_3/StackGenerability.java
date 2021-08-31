package ahodanenok.algs4.ch_1_3;

import java.util.Arrays;

/**
 * Book, exercise 1.3.45
 */
public class StackGenerability {

    public static boolean isUnderflow(String operations) {
        if (operations == null || operations.isEmpty()) {
            return false;
        }

        int allowedPopCount = 0;
        for (String op : operations.trim().split("\\s+")) {
            if ("-".equals(op)) {
                allowedPopCount--;
            } else {
                allowedPopCount++;
            }

            if (allowedPopCount < 0) {
                return true;
            }
        }

        return false;
    }

    public static boolean isValidPermutation(String operations) {
        if (operations == null || operations.isEmpty()) {
            return true;
        }

        String[] parts = operations.trim().split("\\s+");
        int[] permutation = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();

        int n = 0;
        Stack<Integer> stack = new Stack<>();
        // even though there is a nested loop, if i get it right then total complexity is O(2N) -> O(N)
        // because the nested loop is O(N) as it will add every number in range [0, N) only once to a stack
        for (int pn : permutation) {
            while (n <= pn) {
                stack.push(n);
                n++;
            }

            if (stack.peek() > pn) {
                return false;
            }

            stack.pop();
        }

        return true;
    }
}
