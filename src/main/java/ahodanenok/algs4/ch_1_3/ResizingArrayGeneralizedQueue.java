package ahodanenok.algs4.ch_1_3;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Book, exercise 1.3.38
 */
public class ResizingArrayGeneralizedQueue<T> implements GeneralizedQueue<T> {

    private static final int INITIAL_CAPACITY = 10;

    private T[] items;
    private int size;

    @SuppressWarnings("unchecked") // items will contains only T instances
    public ResizingArrayGeneralizedQueue() {
        this.items = (T[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public void insert(T item) {
        if (size == items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }

        items[size] = item;
        size++;
    }

    @Override
    public T delete(int k) {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        if (k >= size) {
            throw new NoSuchElementException("No element at position " + k);
        }

        T item = items[k];
        size--;
        System.arraycopy(items, k + 1, items, k, size - k);
        items[size] = null;

        // shrink if only a quarter of array is filled
        if (size < items.length / 4) {
            int newCapacity = Math.max(items.length / 2, INITIAL_CAPACITY);
            if (items.length != newCapacity) {
                items = Arrays.copyOf(items, items.length / 2);
            }
        }

        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
