package ahodanenok.algs4.ch_1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Book, exercise 1.3.33
 */
public class DoubleLinkedListDeque<T> implements Deque<T> {

    private DoubleNode<T> startNode;
    private DoubleNode<T> lastNode;
    private int size;

    @Override
    public void pushLeft(T item) {
        DoubleNode<T> newNode = new DoubleNode<>(item);
        newNode.next = startNode;

        if (startNode != null) {
            startNode.prev = newNode;
        }

        if (lastNode == null) {
            lastNode = newNode;
        }

        startNode = newNode;
        size++;
    }

    @Override
    public T popLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        DoubleNode<T> node = startNode;

        startNode = startNode.next;
        size--;

        if (startNode != null) {
            startNode.prev = null;
        } else {
            lastNode = null;
        }

        return node.value;
    }

    @Override
    public void pushRight(T item) {
        DoubleNode<T> newNode = new DoubleNode<>(item);
        newNode.prev = lastNode;

        if (lastNode != null) {
            lastNode.next = newNode;
        }

        if (startNode == null) {
            startNode = newNode;
        }

        lastNode = newNode;
        size++;
    }

    @Override
    public T popRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        DoubleNode<T> node = lastNode;

        lastNode = lastNode.prev;
        size--;

        if (lastNode != null) {
            lastNode.next = null;
        } else {
            startNode = null;
        }

        return node.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private DoubleNode<T> currentNode = startNode;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                T value = currentNode.value;
                currentNode = currentNode.next;
                return value;
            }
        };
    }
}
