package ahodanenok.algs4.ch_1_3;

import java.util.Scanner;

/**
 * Book, exercise 1.3.12
 */
public class Copy {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            stack.push(scanner.nextLine());
        }

        Stack<String> copy = copy(stack);

        System.out.println();
        for (String str : copy) {
            System.out.println(str);
        }
    }

    public static Stack<String> copy(Stack<String> stack) {
        Stack<String> copy = new Stack<>();
        Stack<String> buf = new Stack<>();

        for (String str : stack) {
            buf.push(str);
        }

        for (String str : buf) {
            copy.push(str);
        }

        return copy;
    }
}
