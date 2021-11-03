package ahodanenok.algs4.ch_1_3;

import java.util.NoSuchElementException;

/**
 * Book, exercise 1.3.49
 *
 * Web, exercise 1.3.31
 * https://algs4.cs.princeton.edu/13stacks/
 *
 * Book, exercise 1.4.27
 */
public class StacksQueue<T> {

    // The exercise says to implement 'a queue with three stacks' to get O(1) worst case performance,
    // but two stacks already give O(1) (but amortized) performance and i don't know how a third stack here could improve it.
    // But if a deque was meant then three stacks are required to get an amortized O(1) performance.
    private final Stack<T> left = new Stack<>();
    private final Stack<T> right = new Stack<>();

    public void enqueue(T item) {
        right.push(item);
    }

    public T dequeue() {
        if (size() == 0) {
            throw new NoSuchElementException("Queue is empty");
        }

        if (left.size() == 0) {
            while (right.size() != 0) {
                left.push(right.pop());
            }
        }

        return left.pop();
    }

    public int size() {
        return left.size() + right.size();
    }
}
