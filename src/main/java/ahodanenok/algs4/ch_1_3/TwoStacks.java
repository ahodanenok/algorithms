package ahodanenok.algs4.ch_1_3;

import java.util.NoSuchElementException;

/**
 * Book, exercise 1.3.48
 */
public class TwoStacks<T> {

    // A - left, B - right
    private final Deque<T> deque = new DoubleLinkedListDeque<>();
    private int sizeA;
    private int sizeB;

    public void pushA(T item) {
        sizeA++;
        deque.pushLeft(item);
    }

    public T popA() {
        if (sizeA == 0) {
            throw new NoSuchElementException("Stack A is empty");
        }

        sizeA--;
        return deque.popLeft();
    }

    public int sizeA() {
        return sizeA;
    }

    public void pushB(T item) {
        sizeB++;
        deque.pushRight(item);
    }

    public T popB() {
        if (sizeB == 0) {
            throw new NoSuchElementException("Stack B is empty");
        }

        sizeB--;
        return deque.popRight();
    }

    public int sizeB() {
        return sizeB;
    }
}
