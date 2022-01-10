package ahodanenok.algs4.ch_3_1;

/**
 * Book, exercise 3.1.12
 */
public class BinarySearchST<K extends Comparable<K>, V> implements ST<K, V> {

    private final Item<K, V>[] items;
    private int size;

    /**
     * Book, exercise 3.1.25
     */
    private Item<K, V> lastAccessed;

    @SuppressWarnings("unchecked")
    public BinarySearchST(int capacity) {
        items = new Item[capacity];
    }

    @Override
    public V get(K key) {
        if (lastAccessed != null && lastAccessed.key.compareTo(key) == 0) {
            return lastAccessed.value;
        }

        int idx = rank(key);
        if (idx < 0) {
            return null;
        }

        Item<K, V> item = items[idx];
        lastAccessed = item;

        return item.value;
    }

    /**
     * Book, exercise 3.1.17
     */
    public V floor(K key) {
        int idx = Math.abs(rank(key) + 1) - 1;
        if (idx < 0) {
            return null;
        }

        return items[idx].value;
    }

    @Override
    public void put(K key, V value) {
        if (value == null) {
            delete(key);
            return;
        }

        // Book, exercise 3.1.28
        if (size == 0 || items[size - 1].key.compareTo(key) < 0) {
            insert(size, new Item<>(key, value));
            return;
        }

        int idx = rank(key);
        if (idx < 0) {
            insert(idx, new Item<>(key, value));
        } else {
            items[idx].value = value;
        }
    }

    private void insert(int idx, Item<K, V> item) {
        if (size == items.length) {
            throw new IllegalStateException("ST is full");
        }

        int insertIdx;
        if (idx < 0) {
            insertIdx = Math.abs(idx + 1) ;
        } else {
            insertIdx = idx;
        }

        if (size - insertIdx > 0) {
            System.arraycopy(items, insertIdx, items, insertIdx + 1, size - insertIdx);
        }

        items[insertIdx] = item;
        size++;
    }

    /**
     * Book, exercise 3.1.16
     */
    private void delete(K key) {
        int idx = rank(key);
        if (idx < 0) {
            return;
        }

        if (lastAccessed == items[idx]) {
            lastAccessed = null;
        }

        System.arraycopy(items, idx + 1, items, idx, size - idx - 1);
        size--;
        items[size] = null;
    }

    private int rank(K key) {
        int lo = 0;
        int hi = size - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = items[mid].key.compareTo(key);

            if (cmp > 0) {
                hi = mid - 1;
            } else if (cmp < 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -lo - 1;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Item<K, V> {

        final K key;
        V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
