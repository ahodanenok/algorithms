package ahodanenok.algs4.ch_3_1;

public interface ST<K, V> {

    V get(K key);

    void put(K key, V value);

    int size();
}
