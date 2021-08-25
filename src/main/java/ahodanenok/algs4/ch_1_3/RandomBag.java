package ahodanenok.algs4.ch_1_3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**
 * Book, exercise 1.3.34
 */
public class RandomBag<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final Random RANDOM = new Random();

    private final T[] items;
    private int size;

    public RandomBag() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked") // items will contain only T instances
    public RandomBag(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Initial capacity must be > 0");
        }

        this.items = (T[]) new Object[capacity];
    }

    public void add(T item) {
        if (size == items.length) {
            // didn't find an appropriate exception in the java library
            throw new RuntimeException("Bag is full");
        }

        items[size] = item;
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private final T[] iteratorItems;
            private int idx;

            {
                iteratorItems = Arrays.copyOf(items, size);
                System.arraycopy(items, 0, iteratorItems, 0, size);

                for (int i = iteratorItems.length - 1; i > 0; i--) {
                    int idx = RANDOM.nextInt(i);
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
