package ahodanenok.algs4.ch_1_3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Book, exercise 1.3.11
 */
public class EvaluatePostfix {

    private static final Map<String, Consumer<Stack<Integer>>> OPERATIONS = new HashMap<>();
    static {
        OPERATIONS.put("+", EvaluatePostfix::sum);
        OPERATIONS.put("-", EvaluatePostfix::subtract);
        OPERATIONS.put("*", EvaluatePostfix::multiply);
        OPERATIONS.put("/", EvaluatePostfix::divide);
    }

    public static void main(String[] args) {
        System.out.println(evaluate(args[0]));
    }

    public static int evaluate(String expr) {
        if (expr == null || expr.trim().isEmpty()) {
            return 0;
        }

        Stack<Integer> arguments = new Stack<>();
        StringBuilder tokenBuffer = new StringBuilder();

        int pos = 0;
        while (pos < expr.length()) {
            char ch = expr.charAt(pos);

            if (!Character.isWhitespace(ch)) {
                tokenBuffer.append(ch);
                pos++;
                continue;
            }

            String token = tokenBuffer.toString();
            if (OPERATIONS.containsKey(token)) {
                OPERATIONS.get(token).accept(arguments);
            } else {
                try {
                    arguments.push(Integer.parseInt(token));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Unsupported token: " + token);
                }
            }

            tokenBuffer.setLength(0);
            pos++;
        }

        if (tokenBuffer.length() > 0) {
            String token = tokenBuffer.toString();
            if (!OPERATIONS.containsKey(token)) {
                throw new IllegalArgumentException("Last token must be an operation, found '" + token + "'");
            }

            OPERATIONS.get(token).accept(arguments);
        }

        if (arguments.size() != 1) {
            throw new IllegalArgumentException("Illegal expression");
        }

        return arguments.peek();
    }

    private static void sum(Stack<Integer> arguments) {
        if (arguments.size() < 2) {
            throw new IllegalArgumentException(
                    "Not enough arguments for sum: expected 2, found " + arguments.size());
        }

        int b = arguments.pop();
        int a = arguments.pop();

        arguments.push(a + b);
    }

    private static void subtract(Stack<Integer> arguments) {
        if (arguments.size() < 2) {
            throw new IllegalArgumentException(
                    "Not enough arguments for subtraction: expected 2, found 0");
        }

        int b = arguments.pop();
        int a = arguments.pop();

        arguments.push(a - b);
    }

    private static void multiply(Stack<Integer> arguments) {
        if (arguments.size() < 2) {
            throw new IllegalArgumentException(
                    "Not enough arguments for multiplication: expected 2, found " + arguments.size());
        }

        int b = arguments.pop();
        int a = arguments.pop();

        arguments.push(a * b);
    }

    private static void divide(Stack<Integer> arguments) {
        if (arguments.size() < 2) {
            throw new IllegalArgumentException(
                    "Not enough arguments for division: expected 2, found " + arguments.size());
        }

        int b = arguments.pop();
        int a = arguments.pop();

        arguments.push(a / b);
    }
}
