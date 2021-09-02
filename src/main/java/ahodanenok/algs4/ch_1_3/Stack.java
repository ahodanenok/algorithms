package ahodanenok.algs4.ch_1_3;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {

    public static final int INITIAL_CAPACITY = 10;

    private T[] items;
    private int size;

    private long changed;

    @SuppressWarnings("unchecked") // items array is updated only through methods accepting objects of type T
    public Stack() {
        this.items = (T[]) new Object[INITIAL_CAPACITY];
        this.changed = System.currentTimeMillis();
    }

    public void push(T item) {
        if (size == items.length) {
            resizeItemsArray(items.length * 2);
        }

        items[size++] = item;
        changed = System.currentTimeMillis();
    }

    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty");
        }

        T item = items[--size];
        items[size] = null;
        changed = System.currentTimeMillis();

        // 3/4 of items array is empty, shrink in half
        if (size <= items.length / 4) {
            resizeItemsArray(Math.max(items.length / 2, INITIAL_CAPACITY));
        }

        return item;
    }

    /**
     * Book, exercise 1.3.7
     */
    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty");
        }

        return items[size - 1];
    }

    public int size() {
        return size;
    }

    private void resizeItemsArray(int requestedLength) {
        int newLength = requestedLength < 0 ? Integer.MAX_VALUE - 8 : requestedLength;

        // can't resize any longer
        if (requestedLength < 0 && items.length == newLength) {
            throw new IllegalStateException("Stack is too big to handle");
        }

        this.items = Arrays.copyOf(items, newLength);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int idx = size - 1;
            private final long created = changed;

            @Override
            public boolean hasNext() {
                /**
                 * Book, exercise 1.3.50
                 */
                if (created != changed) {
                    throw new ConcurrentModificationException();
                }

                return idx > -1;
            }

            @Override
            public T next() {
                if (created != changed) {
                    throw new ConcurrentModificationException();
                }

                return items[idx--];
            }
        };
    }
}
