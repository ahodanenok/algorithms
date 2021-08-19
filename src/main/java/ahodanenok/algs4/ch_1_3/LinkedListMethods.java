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

    /**
     * Book, exercise 1.3.24
     */
    public static <T> void removeAfter(Node<T> node) {
        if (node != null && node.next != null) {
            node.next = node.next.next;
        }
    }

    /**
     * Book, exercise 1.3.25
     */
    public static <T> void insertAfter(Node<T> node, Node<T> insertedNode) {
        if (node != null && insertedNode != null) {
            insertedNode.next = node.next;
            node.next = insertedNode;
        }
    }

    /**
     * Book, exercise 1.3.26
     */
    public static Node<String> remove(Node<String> node, String value) {
        Node<String> firstNode = node;
        Node<String> previousNode = null;
        Node<String> currentNode = firstNode;
        while (currentNode != null) {
            if (Objects.equals(currentNode.value, value)) {
                if (previousNode != null) {
                    previousNode.next = currentNode.next;
                } else {
                    // current node is the first
                    firstNode = firstNode.next;
                }
            } else {
                previousNode = currentNode;
            }

            currentNode = currentNode.next;
        }

        return firstNode;
    }

    /**
     * Book, exercise 1.3.27
     */
    public static int max(Node<Integer> node) {
        int max = 0;
        Node<Integer> currentNode = node;
        while (currentNode != null) {
            if (currentNode.value > max) {
                max = currentNode.value;
            }

            currentNode = currentNode.next;
        }

        return max;
    }
}
