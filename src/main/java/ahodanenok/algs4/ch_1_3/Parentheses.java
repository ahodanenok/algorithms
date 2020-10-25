package ahodanenok.algs4.ch_1_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Exercise 1.3.4
 */
public class Parentheses {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(isBalanced(reader.readLine()));
        }
    }

    public static boolean isBalanced(String str) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(' || ch == '<') {
                stack.push(ch);
                continue;
            }

            char expected;
            if (ch == ']') {
                expected = '[';
            } else if (ch == '}') {
                expected = '{';
            } else if (ch == ')') {
                expected = '(';
            } else if (ch == '>') {
                expected = '<';
            } else {
                continue;
            }

            if (stack.isEmpty() || stack.peek() != expected) {
                return false;
            }

            stack.pop();
        }

        return stack.isEmpty();
    }
}
