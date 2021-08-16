package ahodanenok.algs4.ch_1_3;

public class Node<T> {

    public static <T> Node<T> list(T firstValue, T... otherValues) {
        if (firstValue == null) {
            return null;
        }

        Node<T> firstNode = new Node<>(firstValue);
        Node<T> currentNode = firstNode;
        for (T value : otherValues) {
            Node<T> node = new Node<>(value);
            currentNode.next = node;
            currentNode = node;
        }

        return firstNode;
    }

    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }
}
