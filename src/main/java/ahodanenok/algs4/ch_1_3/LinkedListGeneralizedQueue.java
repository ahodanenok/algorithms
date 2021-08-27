package ahodanenok.algs4.ch_1_3;

import java.util.NoSuchElementException;

/**
 * Book, exercise 1.3.38
 */
public class LinkedListGeneralizedQueue<T> implements GeneralizedQueue<T> {

    private Node<T> first;
    private Node<T> last;

    @Override
    public void insert(T item) {
        Node<T> newNode = new Node<>(item);
        if (last != null) {
            last.next = newNode;
        } else {
            first = newNode;
        }

        last = newNode;
    }

    @Override
    public T delete(int k) {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        int currentIdx = 0;
        Node<T> previousNode = null;
        Node<T> currentNode = first;
        while (currentNode != null && currentIdx < k) {
            previousNode = currentNode;
            currentNode = currentNode.next;
            currentIdx++;
        }

        if (currentNode == null || currentIdx != k) {
            throw new NoSuchElementException("No element at position " + k);
        }

        if (previousNode != null) {
            previousNode.next = currentNode.next;
        } else {
            // first item is removed
            first = currentNode.next;
        }

        // when there are no items or a single item then the last node equals first
        if (first == null || first.next == null) {
            last = first;
        }

        return currentNode.value;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }
}
