package ahodanenok.algs4.ch_1_3;

import java.util.NoSuchElementException;

/**
 * Book, exercise 1.3.29
 *
 * Web, exercise 1.3.29
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class CircularListQueue<T> {

    private Node<T> lastNode;
    private int size;

    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);

        if (size > 0) {
            newNode.next = lastNode.next;
            lastNode.next = newNode;
        } else {
            newNode.next = newNode;
        }

        lastNode = newNode;
        size++;
    }

    public T dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }

        Node<T> firstNode = lastNode.next;

        size--;
        if (size > 0) {
            lastNode.next = firstNode.next;
        } else {
            lastNode = null;
        }

        return firstNode.value;
    }

    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }

        return lastNode.next.value;
    }

    public int size() {
        return size;
    }
}
