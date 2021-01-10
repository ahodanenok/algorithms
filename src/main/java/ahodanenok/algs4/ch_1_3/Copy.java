package ahodanenok.algs4.ch_1_3;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Exercise 1.3.12
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
        for (String str : new StringStackIterable(copy)) {
            System.out.println(str);
        }
    }

    public static Stack<String> copy(Stack<String> stack) {
        Stack<String> copy = new Stack<>();
        Stack<String> buf = new Stack<>();

        for (String str : new StringStackIterable(stack)) {
            buf.push(str);
        }

        for (String str : new StringStackIterable(buf)) {
            copy.push(str);
        }

        return copy;
    }

    private static class StringStackIterable implements Iterable<String> {

        private Stack<String> stack;

        public StringStackIterable(Stack<String> stack) {
            this.stack = stack;
        }

        @Override
        public Iterator<String> iterator() {
            return new Iterator<String>() {

                @Override
                public boolean hasNext() {
                    return stack.size() > 0;
                }

                @Override
                public String next() {
                    return stack.pop();
                }
            };
        }
    }
}
