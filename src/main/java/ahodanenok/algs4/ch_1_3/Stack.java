package ahodanenok.algs4.ch_1_3;

import java.util.Arrays;

public class Stack<T> {

    public static final int DEFAULT_INITIAL_CAPACITY = 10;

    private T[] items;
    private int size;

    @SuppressWarnings("unchecked") // items array is updated only through methods accepting objects of type T
    public Stack() {
        this.items = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(T item) {
        if (size == items.length) {
            resizeItemsArray(items.length * 2);
        }

        items[size++] = item;
    }

    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }

        T item = items[--size];
        items[size] = null;

        // 3/4 of items array is empty, shrink in half
        if (size <= items.length / 4) {
            resizeItemsArray(items.length / 2);
        }

        return item;
    }

    /**
     * Book, exercise 1.3.7
     */
    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }

        return items[size - 1];
    }

    public int size() {
        return size;
    }

    private void resizeItemsArray(int newLength) {
        if (newLength < 0 && items.length < Integer.MAX_VALUE - 8) {
            newLength = Integer.MAX_VALUE - 8;
        }

        if (newLength < 0) {
            throw new IllegalStateException("Stack is too big to handle");
        }

        this.items = Arrays.copyOf(items, newLength);
    }
}
