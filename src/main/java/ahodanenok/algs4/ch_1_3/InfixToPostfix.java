package ahodanenok.algs4.ch_1_3;

import java.util.HashMap;
import java.util.Map;

/**
 * Book, exercise 1.3.10
 *
 * Web, exercise 1.3.15
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class InfixToPostfix {

    private static final Map<Character, Integer> OPERATIONS_PRIORITY = new HashMap<>();
    static {
        OPERATIONS_PRIORITY.put('+', 1);
        OPERATIONS_PRIORITY.put('-', 1);
        OPERATIONS_PRIORITY.put('*', 2);
        OPERATIONS_PRIORITY.put('/', 2);
    }

    public static void main(String[] args) {
        System.out.println(convert(args[0]));
    }

    public static String convert(String expr) {
        if (expr == null) {
            return null;
        }

        if (expr.trim().isEmpty()) {
            return "";
        }

        Stack<Character> operations = new Stack<>();
        Stack<String> arguments = new Stack<>();

        StringBuilder currentArgument = new StringBuilder();
        // allows arguments to start with +, - (or other characters that can be valid operations)
        boolean expectingOperation = false;

        int pos = 0;
        while (pos < expr.length()) {
            char ch = expr.charAt(pos);

            if (Character.isWhitespace(ch)) {
                if (currentArgument.length() > 0) {
                    arguments.push(currentArgument.toString());
                    currentArgument.setLength(0);
                    expectingOperation = true;
                }
            } else if (OPERATIONS_PRIORITY.containsKey(ch) && expectingOperation) {
                if (currentArgument.length() > 0) {
                    arguments.push(currentArgument.toString());
                    currentArgument.setLength(0);
                }

                while (operations.size() > 0 && operations.peek() != '('
                        && OPERATIONS_PRIORITY.get(operations.peek()) >= OPERATIONS_PRIORITY.get(ch)) {
                    convertOperatorToPostfix(operations.pop(), arguments);
                }

                operations.push(ch);
                expectingOperation = false;
            } else if (ch == '(') {
                if (currentArgument.length() > 0) {
                    arguments.push(currentArgument.toString());
                    currentArgument.setLength(0);
                    expectingOperation = true;
                }

                operations.push(ch);
            } else if (ch == ')') {
                if (currentArgument.length() > 0) {
                    arguments.push(currentArgument.toString());
                    currentArgument.setLength(0);
                    expectingOperation = true;
                }

                while (operations.size() > 0 && operations.peek() != '(') {
                    convertOperatorToPostfix(operations.pop(), arguments);
                }

                if (operations.size() == 0) {
                    throw new IllegalArgumentException("Unmatched parenthesis");
                }

                operations.pop();
            } else {
                if (OPERATIONS_PRIORITY.containsKey(ch)) {
                    expectingOperation = true;
                }

                currentArgument.append(ch);
            }

            pos++;
        }

        if (currentArgument.length() > 0) {
            arguments.push(currentArgument.toString());
        }

        while (operations.size() > 0) {
            char op = operations.pop();
            if (op == '(') {
                throw new IllegalArgumentException("Unmatched parenthesis");
            }

            convertOperatorToPostfix(op, arguments);
        }

        if (arguments.size() != 1) {
            throw new IllegalArgumentException("Malformed expression");
        }

        return arguments.peek();
    }

    private static void convertOperatorToPostfix(char op, Stack<String> arguments) {
        if (arguments.size() < 2) {
            throw new IllegalArgumentException("Not enough arguments for " + op);
        }

        String b = arguments.pop();
        String a = arguments.pop();
        arguments.push(a + " " + b + " " + op);
    }
}
