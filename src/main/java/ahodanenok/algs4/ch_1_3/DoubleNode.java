package ahodanenok.algs4.ch_1_3;

public class DoubleNode<T> {

    public static <T> DoubleNode<T> list(T firstValue, T... otherValues) {
        if (firstValue == null) {
            return null;
        }

        DoubleNode<T> firstNode = new DoubleNode<>(firstValue);
        DoubleNode<T> currentNode = firstNode;
        for (T value : otherValues) {
            DoubleNode<T> node = new DoubleNode<>(value);
            currentNode.next = node;
            node.prev = currentNode;
            currentNode = node;
        }

        return firstNode;
    }

    DoubleNode<T> next;
    DoubleNode<T> prev;
    T value;

    public DoubleNode(T value) {
        this.value = value;
    }
}
