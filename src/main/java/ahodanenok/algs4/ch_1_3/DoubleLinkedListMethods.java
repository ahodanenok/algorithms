package ahodanenok.algs4.ch_1_3;

/**
 * Book, exercise 1.3.31
 */
public class DoubleLinkedListMethods {

    public static <T> DoubleNode<T> insertFirst(DoubleNode<T> firstNode, T value) {
        // return insertBefore(firstNode, value);

        DoubleNode<T> newNode = new DoubleNode<>(value);
        if (firstNode != null) {
            newNode.next = firstNode;
            firstNode.prev = newNode;
        }

        return newNode;
    }

    public static <T> DoubleNode<T> insertLast(DoubleNode<T> firstNode, T value) {
        DoubleNode<T> newNode = new DoubleNode<>(value);
        if (firstNode == null) {
            return newNode;
        }

        DoubleNode<T> lastNode = firstNode;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        lastNode.next = newNode;
        newNode.prev = lastNode;

        return firstNode;
    }

    public static <T> DoubleNode<T> removeFirst(DoubleNode<T> firstNode) {
        if (firstNode == null || firstNode.next == null) {
            return null;
        }

        DoubleNode<T> secondNode = firstNode.next;
        secondNode.prev = null;

        return secondNode;
    }

    public static <T> DoubleNode<T> removeLast(DoubleNode<T> firstNode) {
        if (firstNode == null || firstNode.next == null) {
            return null;
        }

        DoubleNode<T> lastNode = firstNode;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        lastNode.prev.next = null;

        return firstNode;
    }

    public static <T> DoubleNode<T> insertBefore(DoubleNode<T> node, T value) {
        DoubleNode<T> newNode = new DoubleNode<>(value);
        if (node == null) {
            return newNode;
        }

        if (node.prev != null) {
            newNode.prev = node.prev;
            node.prev.next = newNode;
        }

        newNode.next = node;
        node.prev = newNode;

        return newNode;
    }

    public static <T> DoubleNode<T> insertAfter(DoubleNode<T> node, T value) {
        DoubleNode<T> newNode = new DoubleNode<>(value);
        if (node == null) {
            return newNode;
        }

        if (node.next != null) {
            newNode.next = node.next;
            node.next.prev = newNode;
        }

        newNode.prev = node;
        node.next = newNode;

        return newNode;
    }

    public static <T> DoubleNode<T> removeNode(DoubleNode<T> node) {
        if (node == null) {
            return null;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        return node.prev != null ? node.prev : node.next;
    }
}
