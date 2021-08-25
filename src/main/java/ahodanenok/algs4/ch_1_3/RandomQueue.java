package ahodanenok.algs4.ch_1_3;

import java.util.Arrays;
import java.util.Random;

/**
 * Book, exercise 1.3.35
 */
public class RandomQueue<T> {

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
}
