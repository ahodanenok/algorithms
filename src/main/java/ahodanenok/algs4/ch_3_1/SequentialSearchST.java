package ahodanenok.algs4.ch_3_1;

import java.util.Iterator;

public class SequentialSearchST<K, V> implements ST<K, V> {

    private Node<K, V> head;
    private int size;

    @Override
    public V get(K key) {
        Node<K, V> node = getNode(key);
        if (node != null) {
            return node.value;
        } else {
            return null;
        }
    }

    @Override
    public void put(K key, V value) {
        if (value == null) {
            delete(key);
            return;
        }

        Node<K, V> node = getNode(key);
        if (node != null) {
            node.value = value;
        } else {
            head = new Node<>(key, value, head);
            size++;
        }
    }

    /**
     * Book, exercise 3.1.5
     */
    public void delete(K key) {
        Node<K, V> prev = null;
        Node<K, V> node = head;
        while (node != null && !node.key.equals(key)) {
            prev = node;
            node = node.next;
        }

        if (node != null && node.key.equals(key)) {
            if (prev != null) {
                prev.next = node.next;
            } else {
                head = node.next;
            }

            size--;
        }
    }

    private Node<K, V> getNode(K key) {
        Node<K, V> node = head;
        while (node != null) {
            if (node.key.equals(key)) {
                return node;
            }

            node = node.next;
        }

        return null;
    }

    /**
     * Book, exercise 3.1.5
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Book, exercise 3.1.5
     */
    public Iterator<K> keys() {
        return new Iterator<K>() {

            Node<K, V> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public K next() {
                K key = node.key;
                node = node.next;
                return key;
            }
        };
    }

    private static class Node<K, V> {

        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
