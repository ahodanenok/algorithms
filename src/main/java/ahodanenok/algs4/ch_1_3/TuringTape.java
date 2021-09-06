package ahodanenok.algs4.ch_1_3;

/**
 * Web, exercise 1.3.9
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class TuringTape {

    private final Stack<Integer> left = new Stack<>();
    private final Stack<Integer> right = new Stack<>();
    private int position;

    public TuringTape() {
        this.left.push(0);
    }

    void moveLeft() {
        right.push(left.pop());
        if (left.size() == 0) {
            left.push(0);
        }

        position--;
    }

    void moveRight() {
        left.push(right.pop());
        if (right.size() == 0) {
            right.push(0);
        }

        position++;
    }

    int look() {
        return left.peek();
    }

    void write(int n) {
        left.pop();
        left.push(n);
    }

    int position() {
        return position;
    }
}
