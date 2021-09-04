package ahodanenok.algs4.ch_1_3;

import java.io.IOException;
import java.util.Objects;

/**
 * Web, exercise 1.3.6
 */
public class PostScript {

    public static void main(String[] args) {
        new PostScript().execute(args[0]);
    }

    private Appendable out = System.out;
    private boolean terminated = false;

    public void setOut(Appendable out) {
        this.out = out;
    }

    public void terminate() {
        terminated = true;
    }

    public void execute(String expr) {
        execute(new Stack<>(), expr);
    }

    private void execute(Stack<Token> stack, String expr) {
        Parser parser = new Parser(expr);

        Token token;
        while (!terminated && (token = parser.parseNext()) != null) {
            if (token.type == TokenType.OPERATOR) {
                Operator operator = (Operator) token.value;
                operator.execute(stack, this);
            } else {
                stack.push(token);
            }
        }
    }

    private static class Parser {

        private final String expr;
        private int pos;

        public Parser(String expr) {
            this.expr = expr;
        }

        Token parseNext() {
            boolean collectingFunction = false;
            StringBuilder tokenBuffer = new StringBuilder();
            while (pos < expr.length()) {
                char ch = expr.charAt(pos);

                if (ch == '{') {
                    collectingFunction = true;
                    pos++;
                } else if (ch == '}') {
                    pos++;

                    String body = tokenBuffer.toString();
                    tokenBuffer.setLength(0);
                    return new Token(TokenType.FUNCTION, body);
                } else if (Character.isWhitespace(ch) && !collectingFunction) {
                    pos++;
                    if (tokenBuffer.length() > 0) {
                        Token token = createToken(tokenBuffer.toString());
                        tokenBuffer.setLength(0);
                        return token;
                    }
                } else {
                    tokenBuffer.append(ch);
                    pos++;
                }
            }

            if (tokenBuffer.length() > 0) {
                return createToken(tokenBuffer.toString());
            }

            return null;
        }

        private Token createToken(String token) {
            try {
                return new Token(TokenType.NUMBER, Integer.parseInt(token));
            } catch (NumberFormatException e) {
                // not a number - ignoring
            }

            if ("true".equals(token)) {
                return new Token(TokenType.BOOLEAN, true);
            }
            if ("false".equals(token)) {
                return new Token(TokenType.BOOLEAN, false);
            }

            try {
                return new Token(TokenType.OPERATOR, Operator.valueOf(token.toUpperCase()));
            } catch (IllegalArgumentException e) {
                // not an operator - ignore
            }

            throw new IllegalArgumentException(String.format("Unknown token: '%s'", token));
        }
    }

    private enum Operator {

        EXEC {
            @Override
            void execute(Stack<Token> stack, PostScript ps) {
                String function = getFunction(stack);
                ps.execute(stack, function);
            }
        },
        ADD {
            @Override
            void execute(Stack<Token> stack, PostScript ps) {
                int b = getNumber(stack);
                int a = getNumber(stack);
                stack.push(new Token(TokenType.NUMBER, a + b));
            }
        },
        MUL {
            @Override
            void execute(Stack<Token> stack, PostScript ps) {
                int b = getNumber(stack);
                int a = getNumber(stack);
                stack.push(new Token(TokenType.NUMBER, a * b));
            }
        },
        SUB {
            @Override
            void execute(Stack<Token> stack, PostScript ps) {
                int b = getNumber(stack);
                int a = getNumber(stack);
                stack.push(new Token(TokenType.NUMBER, a - b));
            }
        },
        DIV {
            @Override
            void execute(Stack<Token> stack, PostScript ps) {
                int b = getNumber(stack);
                int a = getNumber(stack);
                stack.push(new Token(TokenType.NUMBER, a / b));
            }
        },
        DUP {
            @Override
            void execute(Stack<Token> stack, PostScript ps) {
                stack.push(stack.peek());
            }
        },
        EXCH {
            @Override
            void execute(Stack<Token> stack, PostScript ps) {
                Token b = stack.pop();
                Token a = stack.pop();
                stack.push(b);
                stack.push(a);
            }
        },
        POP {
            @Override
            void execute(Stack<Token> stack, PostScript ps) {
                stack.pop();
            }
        },
        IF {
            @Override
            void execute(Stack<Token> stack, PostScript ps) {
                String trueFunction = getFunction(stack);
                if (getBoolean(stack)) {
                    ps.execute(stack, trueFunction);
                }
            }
        },
        IFELSE {
            @Override
            void execute(Stack<Token> stack, PostScript ps) {
                String falseFunction = getFunction(stack);
                String trueFunction = getFunction(stack);
                if (getBoolean(stack)) {
                    ps.execute(stack, trueFunction);
                } else {
                    ps.execute(stack, falseFunction);
                }
            }
        },
        EQ {
            @Override
            void execute(Stack<Token> stack, PostScript ps) {
                Token b = stack.pop();
                Token a = stack.pop();
                boolean equal = a.type == b.type && Objects.equals(a.value, b.value);
                stack.push(new Token(TokenType.BOOLEAN, equal));
            }
        },
        NE {
            @Override
            void execute(Stack<Token> stack, PostScript ps) {
                Token b = stack.pop();
                Token a = stack.pop();
                boolean equal = a.type == b.type && Objects.equals(a.value, b.value);
                stack.push(new Token(TokenType.BOOLEAN, !equal));
            }
        },
        GT {
            @Override
            void execute(Stack<Token> stack, PostScript ps) {
                int a = getNumber(stack);
                int b = getNumber(stack);
                stack.push(new Token(TokenType.BOOLEAN, a > b));
            }
        },
        LT {
            @Override
            void execute(Stack<Token> stack, PostScript ps) {
                int a = getNumber(stack);
                int b = getNumber(stack);
                stack.push(new Token(TokenType.BOOLEAN, a < b));
            }
        },
        PSTACK {
            @Override
            void execute(Stack<Token> stack, PostScript ps) {
                if (stack.size() == 0) {
                    writeLine(ps.out, "Stack is empty");
                    return;
                }

                for (Token token : stack) {
                    writeLine(ps.out, token.toString());
                }
            }
        },
        CLEAR {
            @Override
            void execute(Stack<Token> stack, PostScript ps) {
                while (stack.size() > 0) {
                    stack.pop();
                }
            }
        },
        QUIT {
            @Override
            void execute(Stack<Token> stack, PostScript ps) {
                ps.terminate();
            }
        };

        abstract void execute(Stack<Token> stack, PostScript ps);

        void writeLine(Appendable out, String str) {
            try {
                out.append(str);
                out.append(System.lineSeparator());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private enum TokenType {

        NUMBER,
        BOOLEAN,
        FUNCTION,
        OPERATOR;
    }

    private static class Token {

        final TokenType type;
        final Object value;

        public Token(TokenType type, Object value) {
            this.type = type;
            this.value = value;
        }

        @Override
        public String toString() {
            // value format could be moved to TokenType
            if (type == TokenType.FUNCTION) {
                return String.format("[%s] '%s'", type, value);
            } else {
                return String.format("[%s] %s", type, value);
            }
        }
    }

    private static boolean getBoolean(Stack<Token> stack) {
        Token token = stack.pop();
        if (token.type != TokenType.BOOLEAN) {
            throw new IllegalStateException(String.format("Expected type %s, got: %s", TokenType.BOOLEAN, token));
        }

        return (boolean) token.value;
    }

    private static int getNumber(Stack<Token> stack) {
        Token token = stack.pop();
        if (token.type != TokenType.NUMBER) {
            throw new IllegalStateException(String.format("Expected type %s, got: %s", TokenType.NUMBER, token));
        }

        return (int) token.value;
    }

    private static String getFunction(Stack<Token> stack) {
        Token token = stack.pop();
        if (token.type != TokenType.FUNCTION) {
            throw new IllegalStateException(String.format("Expected type %s, got: %s", TokenType.FUNCTION, token));
        }

        return (String) token.value;
    }
}
