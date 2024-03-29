package ahodanenok.algs4.ch_1_3;

import java.util.*;

public class Stack<T> implements Iterable<T> {

    public static final int INITIAL_CAPACITY = 10;

    /**
     * Web, exercise 1.3.2
     * https://algs4.cs.princeton.edu/13stacks/
     */
    public static <T> Stack<T> bounded(int n) {
        return new Stack<>(n, n);
    }

    private T[] items;
    private int size;
    private final int limit;

    private long changesCount;

    public Stack() {
        this(INITIAL_CAPACITY, -1);
    }

    @SuppressWarnings("unchecked") // items array is updated only through methods accepting objects of type T
    private Stack(int capacity, int limit) {
        this.items = (T[]) new Object[Math.max(capacity, limit)];
        this.limit = limit;
    }

    public void push(T item) {
        if (size == limit) {
            throw new RuntimeException("Stack is full");
        }

        if (size == items.length) {
            resizeItemsArray(items.length * 2);
        }

        items[size++] = item;
        changesCount++;
    }

    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty");
        }

        T item = items[--size];
        items[size] = null;
        changesCount++;

        // 3/4 of items array is empty, shrink in half
        if (size <= items.length / 4) {
            resizeItemsArray(Math.max(items.length / 2, INITIAL_CAPACITY));
        }

        return item;
    }

    /**
     * Web, exercise 1.3.50
     * https://algs4.cs.princeton.edu/13stacks/
     */
    public List<T> multiPop(int count) {
        if (count > size()) {
            throw new IllegalStateException("Not enough items");
        }

        List<T> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(pop());
        }

        return result;
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

    /**
     * Web, exercise 1.3.24
     * https://algs4.cs.princeton.edu/13stacks/
     */
    public void replaceAll(T from, T to) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i], from)) {
                items[i] = to;
            }
        }
    }

    /**
     * Web, exercise 1.3.47
     * https://algs4.cs.princeton.edu/13stacks/
     */
    public void dup() {
        push(peek());
    }

    /**
     * Web, exercise 1.3.48
     * https://algs4.cs.princeton.edu/13stacks/
     */
    public void exch() {
        if (size() < 2) {
            throw new IllegalStateException("Exch requires at least two items in the stack");
        }

        T a = pop();
        T b = pop();
        push(a);
        push(b);
    }

    /**
     * Web, exercise 1.3.49
     * https://algs4.cs.princeton.edu/13stacks/
     */
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
            private final long expectedChangesCount = changesCount;

            @Override
            public boolean hasNext() {
                /*
                 * Book, exercise 1.3.50
                 */
                if (expectedChangesCount != changesCount) {
                    throw new ConcurrentModificationException();
                }

                return idx > -1;
            }

            @Override
            public T next() {
                if (expectedChangesCount != changesCount) {
                    throw new ConcurrentModificationException();
                }

                return items[idx--];
            }
        };
    }
}
