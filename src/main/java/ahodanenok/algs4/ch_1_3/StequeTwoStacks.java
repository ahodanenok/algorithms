package ahodanenok.algs4.ch_1_3;

import java.util.NoSuchElementException;

/**
 * Web, exercise 1.3.35
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class StequeTwoStacks<T> implements Steque<T> {

    private final Stack<T> left = new Stack<>();
    private final Stack<T> right = new Stack<>();

    @Override
    public T pop() {
        rtl();
        if (left.size() == 0) {
            throw new NoSuchElementException("Steque is empty");
        }

        return left.pop();
    }

    @Override
    public T peek() {
        rtl();
        if (left.size() == 0) {
            throw new NoSuchElementException("Steque is empty");
        }

        return left.peek();
    }

    @Override
    public void push(T item) {
        left.push(item);
    }

    @Override
    public void enqueue(T item) {
        right.push(item);
    }

    @Override
    public int size() {
        return left.size() + right.size();
    }

    private void rtl() {
        if (left.size() > 0) {
            return;
        }

        while (right.size() > 0) {
            left.push(right.pop());
        }
    }
}
