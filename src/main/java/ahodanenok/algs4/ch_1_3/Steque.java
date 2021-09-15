package ahodanenok.algs4.ch_1_3;

import java.util.NoSuchElementException;

/**
 * Book, exercise 1.3.32
 *
 * Web, exercise 1.3.30
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class Steque<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;

    public void push(T item) {
        Node<T> newNode = new Node<>(item);

        if (size == 0) {
            lastNode = newNode;
        } else {
            newNode.next = firstNode;
        }

        firstNode = newNode;
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException("Steque is empty");
        }

        return firstNode.value;
    }

    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException("Steque is empty");
        }

        Node<T> node = firstNode;
        size--;

        if (size == 0) {
            firstNode = null;
            lastNode = null;
        } else {
            firstNode = firstNode.next;
        }

        return node.value;
    }

    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);

        if (size == 0) {
            firstNode = newNode;
        } else {
            lastNode.next = newNode;
        }

        lastNode = newNode;
        size++;
    }

    public int size() {
        return size;
    }
}
