package ahodanenok.algs4.ch_1_3;

import edu.princeton.cs.algs4.Queue;

import java.util.NoSuchElementException;

/**
 * Web, exercise 1.3.33
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class StackWithQueue<T> {

    private final Queue<T> queue = new Queue<>();

    public void push(T item) {
        queue.enqueue(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        int size = queue.size() - 1;
        for (int i = 0; i < size; i++) {
            queue.enqueue(queue.dequeue());
        }

        return queue.dequeue();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
