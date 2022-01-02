package ahodanenok.algs4.ch_3_1;

import java.util.Objects;

/**
 * Book, exercise 3.1.2
 */
public class ArrayST<K, V> implements ST<K, V> {

    private final K[] keys;
    private final V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayST(int capacity) {
        this.keys = (K[]) new Object[capacity];
        this.values = (V[]) new Object[capacity];
    }

    @Override
    public V get(K key) {
        Objects.requireNonNull(key, "Key is null");
        int idx = indexOf(key);

        if (idx == -1) {
            return null;
        }

        V value = values[idx];

        // Book, exercise 3.1.22
        System.arraycopy(keys, 0, keys, 1, idx);
        keys[0] = key;

        System.arraycopy(values, 0, values, 1, idx);
        values[0] = value;

        return value;
    }

    @Override
    public void put(K key, V value) {
        Objects.requireNonNull(key, "Key is null");
        int idx = indexOf(key);

        // delete
        if (value == null) {
            if (idx != -1) {
                for (int i = idx, end = size - 1; i < end; i++) {
                    keys[i] = keys[i + 1];
                    values[i] = values[i + 1];
                }

                size--;
                keys[size] = null;
                values[size] = null;
            }

            return;
        }

        // update
        if (idx != -1) {
            values[idx] = value;
            return;
        }

        // add
        if (size == keys.length) {
            throw new IllegalStateException("ST is full");
        }

        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    private int indexOf(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return i;
            }
        }

        return -1;
    }
}
