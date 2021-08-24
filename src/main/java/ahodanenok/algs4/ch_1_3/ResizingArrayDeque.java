package ahodanenok.algs4.ch_1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Book, exercise 1.3.33
 */
public class ResizingArrayDeque<T> implements Deque<T> {

    private static final int INITIAL_CAPACITY = 16;
    private static final int INITIAL_OFFSET = 8;

    private T[] items;
    private int offset;
    private int size;

    @SuppressWarnings("unchecked") // all access to array will be through methods operating on T instances
    public ResizingArrayDeque() {
        this.items = (T[]) new Object[INITIAL_CAPACITY];
        this.offset = INITIAL_OFFSET;
    }

    @Override
    public void pushLeft(T item) {
        resizeArrayIfNeeded();

        offset--;
        items[offset] = item;
        size++;
    }

    @Override
    public T popLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        T item = items[offset];
        items[offset] = null;
        offset++;
        size--;

        resizeArrayIfNeeded();

        return item;
    }

    @Override
    public void pushRight(T item) {
        resizeArrayIfNeeded();

        items[offset + size] = item;
        size++;
    }

    @Override
    public T popRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        T item = items[offset + size - 1];
        items[offset + size - 1] = null;
        size--;

        resizeArrayIfNeeded();

        return item;
    }

    @SuppressWarnings("unchecked") // new array will contain only T items
    private void resizeArrayIfNeeded() {
        T[] oldItems = items;

        // no room for new items
        if (offset == 0 || offset + size == items.length) {
            items = (T[]) new Object[oldItems.length * 2];
        }
        // a lot of free space
        else if (size <= items.length / 4 && oldItems.length / 2 >= INITIAL_CAPACITY) {
            items = (T[]) new Object[oldItems.length / 2];
        } else {
            return;
        }

        int newOffset = items.length / 3;
        System.arraycopy(oldItems, offset, items, newOffset, size);
        offset = newOffset;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int idx = offset;
            private final int length = offset + size;

            @Override
            public boolean hasNext() {
                return idx < length;
            }

            @Override
            public T next() {
                return items[idx++];
            }
        };
    }

    @Override
    public int size() {
        return size;
    }
}
