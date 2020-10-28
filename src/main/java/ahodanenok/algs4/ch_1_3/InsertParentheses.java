package ahodanenok.algs4.ch_1_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Exercise 1.3.9
 */
public class InsertParentheses {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(insert(reader.readLine()));
    }

    public static String insert(String expr) {
        Stack<Character> buf = new Stack<>();
        Stack<Character> out = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch == ')') {
                int pCount = 0;
                boolean opSeen = false;
                boolean skipping = false;
                while (buf.size() > 0) {
                    char bufCh = buf.pop();

                    // if there is a closing parenthesis, then there should be an opening parenthesis
                    // somewhere before as it has been inserted for this closing parenthesis earlier
                    if (bufCh == ')') {
                        skipping = true;
                        pCount++;
                    } else if (bufCh == '(') {
                        pCount--;
                        if (pCount == 0) {
                            skipping = false;
                        }
                    }

                    // skipping everything between parentheses (...)
                    if (skipping) {
                        out.push(bufCh);
                        continue;
                    }

                    // when closing parenthesis is encountered, we need to go left until we've seen
                    // expression <expr1> <op> <expr2>, where expr1, expr2 maybe complex expressions with
                    // parentheses involved (closing parenthesis here is like a postfix operator)
                    if (isOperator(bufCh) && opSeen) {
                        out.push('(');
                        out.push(bufCh);
                        break;
                    } else if (isOperator(bufCh)) {
                        opSeen = true;
                    }

                    out.push(bufCh);
                }

                if (buf.size() == 0) {
                    out.push('(');
                }

                while (out.size() > 0) {
                    buf.push(out.pop());
                }
            }

            if (!Character.isWhitespace(ch)) {
                buf.push(ch);
            }
        }

        while (buf.size() > 0) {
            out.push(buf.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (out.size() > 0) {
            sb.append(out.pop());
            if (out.size() > 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
}
