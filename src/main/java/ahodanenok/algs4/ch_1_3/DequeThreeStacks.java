package ahodanenok.algs4.ch_1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Web, exercise 1.3.37
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class DequeThreeStacks<T> implements Deque<T> {

    private final Stack<T> left = new Stack<>();
    private final Stack<T> middle = new Stack<>();
    private final Stack<T> right = new Stack<>();

    @Override
    public void pushLeft(T item) {
        left.push(item);
    }

    @Override
    public T popLeft() {
        if (left.size() == 0) {
            int halfSize = middle.size() / 2;
            for (int i = 0; i < halfSize; i++) {
                middle.push(right.pop());
            }

            while (right.size() > 0) {
                left.push(right.pop());
            }

            while (middle.size() > 0) {
                right.push(middle.pop());
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
            int halfSize = left.size() / 2;
            for (int i = 0; i < halfSize; i++) {
                middle.push(left.pop());
            }

            while (left.size() > 0) {
                right.push(left.pop());
            }

            while (middle.size() > 0) {
                left.push(middle.pop());
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
                Stack<T> stack = new Stack<>();
                for (T item : right) {
                    stack.push(item);
                }

                rightIterator = stack.iterator();
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
