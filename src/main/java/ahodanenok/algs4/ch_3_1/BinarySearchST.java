package ahodanenok.algs4.ch_3_1;

/**
 * Book, exercise 3.1.12
 */
public class BinarySearchST<K extends Comparable<K>, V> implements ST<K, V> {

    private final Item<K, V>[] items;
    private int size;

    @SuppressWarnings("unchecked")
    public BinarySearchST(int capacity) {
        items = new Item[capacity];
    }

    @Override
    public V get(K key) {
        int idx = rank(key);
        if (idx < 0) {
            return null;
        }

        return items[idx].value;
    }

    @Override
    public void put(K key, V value) {
        int idx = rank(key);
        if (value == null && idx < 0) {
            return;
        }

        if (value == null) {
            System.arraycopy(items, idx + 1, items, idx, size - idx - 1);
            size--;
            items[size] = null;
        } else if (idx < 0) {
            if (size == items.length) {
                throw new IllegalStateException("ST is full");
            }

            int insertIdx = Math.abs(idx + 1) ;
            System.arraycopy(items, insertIdx, items, insertIdx + 1, size - insertIdx);
            items[insertIdx] = new Item<>(key, value);
            size++;
        } else {
            items[idx].value = value;
        }
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
