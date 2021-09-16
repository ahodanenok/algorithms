package ahodanenok.algs4.ch_1_3;

import edu.princeton.cs.algs4.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Web, exercise 1.3.36
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class DequeWithStackSteque<T> implements Deque<T> {

    private final Stack<T> left = new Stack<>();
    private final Steque<T> right = new LinkedListSteque<>();

    @Override
    public void pushLeft(T item) {
        left.push(item);
    }

    @Override
    public T popLeft() {
        if (left.size() == 0) {
            int halfSize = right.size() / 2;
            for (int i = 0; i < halfSize; i++) {
                right.enqueue(right.pop());
            }

            int remainingSize = right.size() - halfSize;
            for (int i = 0; i < remainingSize; i++) {
                left.push(right.pop());
            }
        }

        if (left.size() == 0) {
            throw new NoSuchElementException("Queue is empty");
        }

        return left.pop();
    }

    @Override
    public void pushRight(T item) {
        right.push(item);
    }

    @Override
    public T popRight() {
        if (right.size() == 0) {
            while (left.size() > 0) {
                right.push(left.pop());
            }

            int halfSize = (right.size() + 1) / 2;
            for (int i = 0; i < halfSize; i++) {
                right.enqueue(right.pop());
            }

            int remainingSize = right.size() - halfSize;
            for (int i = 0; i < remainingSize; i++) {
                left.push(right.pop());
            }
        }

        if (right.size() == 0) {
            throw new NoSuchElementException("Queue is empty");
        }

        return right.pop();
    }

    @Override
    public int size() {
        return left.size() + right.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private final Iterator<T> leftIterator = left.iterator();
            private final Iterator<T> rightIterator;

            {
                Queue<T> queue = new Queue<>();
                for (int i = 0, size = right.size(); i < size; i++) {
                    queue.enqueue(right.peek());
                    right.enqueue(right.pop());
                }

                rightIterator = queue.iterator();
            }

            @Override
            public boolean hasNext() {
                return leftIterator.hasNext() || rightIterator.hasNext();
            }

            @Override
            public T next() {
                if (leftIterator.hasNext()) {
                    return leftIterator.next();
                }

                if (rightIterator.hasNext()) {
                    return rightIterator.next();
                }

                throw new NoSuchElementException();
            }
        };
    }
}
