package ahodanenok.algs4.ch_1_3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**
 * Book, exercise 1.3.35
 *
 * Web, exercise 1.3.61
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class RandomQueue<T> implements Iterable<T> {

    private static final int INITIAL_CAPACITY = 10;
    private static final Random RANDOM = new Random();

    private T[] items;
    private int size;

    @SuppressWarnings("unchecked") // only T instances added to items array
    public RandomQueue() {
        this.items = (T[]) new Object[INITIAL_CAPACITY];
    }

    public void enqueue(T item) {
        resizeIfNeeded();
        items[size] = item;
        size++;
    }

    public T dequeue() {
        int idx = RANDOM.nextInt(size);
        T item = items[idx];
        size--;

        items[idx] = items[size];
        items[size] = null;
        resizeIfNeeded();

        return item;
    }

    public T sample() {
        return items[RANDOM.nextInt(size)];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resizeIfNeeded() {
        int newCapacity = items.length;

        if (size == items.length) {
            newCapacity = items.length * 2; // ignoring overflow
        } else if (size <= items.length / 4) {
            newCapacity = Math.max(items.length / 2, INITIAL_CAPACITY);
        }

        if (newCapacity != items.length) {
            items = Arrays.copyOf(items, newCapacity);
        }
    }

    /**
     * Book, exercise 1.3.36
     */
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private final T[] iteratorItems;
            private int idx;

            {
                iteratorItems = Arrays.copyOf(items, size);
                for (int i = 0, n = iteratorItems.length; i < n; i++) {
                    int idx = i + RANDOM.nextInt(n - i);
                    T tmp = iteratorItems[idx];
                    iteratorItems[idx] = iteratorItems[i];
                    iteratorItems[i] = tmp;
                }
            }

            @Override
            public boolean hasNext() {
                return idx < iteratorItems.length;
            }

            @Override
            public T next() {
                return iteratorItems[idx++];
            }
        };
    }
}
