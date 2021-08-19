package ahodanenok.algs4.ch_1_3;

import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedListMethods {

    /**
     * Book, exercise 1.3.19
     */
    public static <T> Node<T> removeLast(Node<T> first) {
        if (first == null) {
            return null;
        }

        Node<T> prev = null;
        for (Node<T> current = first; current.next != null; current = current.next) {
            prev = current;
        }

        if (prev != null) {
            prev.next = null;
            return first;
        } else {
            return null;
        }
    }

    /**
     * Book, exercise 1.3.20
     */
    public static <T> Node<T> delete(Node<T> first, int idx) {
        if (idx < 0) {
            throw new IllegalArgumentException("Index must be >= 0");
        }

        if (first == null) {
            throw new NoSuchElementException("No element at index " + idx);
        }

        Node<T> prev = null;
        Node<T> current = first;
        int currentIdx = 0;
        while (current.next != null && currentIdx < idx) {
            prev = current;
            current = current.next;
            currentIdx++;
        }

        if (currentIdx != idx) {
            throw new NoSuchElementException("No element at index " + idx);
        }

        if (prev != null) {
            prev.next = current.next;
            return first;
        } else {
            // first or single element
            return current.next;
        }
    }

    /**
     * Book, exercise 1.3.21
     */
    public static boolean find(Node<String> first, String value) {
        Node<String> current = first;
        while (current != null) {
            if (Objects.equals(current.value, value)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }
}
