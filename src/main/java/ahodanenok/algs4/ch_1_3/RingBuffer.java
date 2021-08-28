package ahodanenok.algs4.ch_1_3;

import java.util.NoSuchElementException;

/**
 * Book, exercise 1.3.39
 */
public class RingBuffer<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private final T[] items;

    // index of the first item
    private int startIdx;

    // index where a new item goes
    private int nextIdx;

    // number of filled slots in items array
    private int count;

    public RingBuffer() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked") // items will contain only T instances
    public RingBuffer(int capacity) {
        this.items = (T[]) new Object[capacity];
    }

    public void push(T item) {
        if (!isEmpty() && startIdx == nextIdx) {
            // need to shift start index to the next one because
            // when buffer overflows the last added item takes place of the first item
            startIdx = (startIdx + 1) % capacity();
        }

        items[nextIdx] = item;
        count = Math.min(count + 1, capacity());
        nextIdx = (nextIdx + 1) % capacity();
    }

    public T poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Buffer is empty");
        }

        T item = items[startIdx];
        startIdx = (startIdx + 1) % capacity();
        count--;

        return item;
    }

    public int capacity() {
        return items.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
