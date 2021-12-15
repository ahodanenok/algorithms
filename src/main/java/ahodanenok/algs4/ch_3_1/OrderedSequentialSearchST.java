package ahodanenok.algs4.ch_3_1;

import java.util.Objects;

/**
 * Book, exercise 3.1.3
 */
public class OrderedSequentialSearchST<K extends Comparable<K>, V> implements ST<K, V> {

    private Node<K, V> head;
    private int size;

    @Override
    public V get(K key) {
        Objects.requireNonNull(key, "Key is null");

        Node<K, V> node = head;
        while (node != null && node.key.compareTo(key) < 0) {
            node = node.next;
        }

        if (node != null && node.key.compareTo(key) == 0) {
            return node.value;
        } else {
            return null;
        }
    }

    @Override
    public void put(K key, V value) {
        Objects.requireNonNull(key, "Key is null");

        Node<K, V> prev = null;
        Node<K, V> node = head;
        while (node != null && node.key.compareTo(key) < 0) {
            prev = node;
            node = node.next;
        }

        // delete
        if (value == null) {
            if (node != null && node.key.compareTo(key) == 0) {
                if (prev != null) {
                    prev.next = node.next;
                } else {
                    head = node.next;
                }

                size--;
            }
            return;
        }

        // update
        if (node != null && node.key.compareTo(key) == 0) {
            node.value = value;
        } else {
            // insert
            if (prev != null) {
                prev.next = new Node<>(key, value, node);
            } else {
                head = new Node<>(key, value, node);
            }

            size++;
        }
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<K, V> {

        final K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
