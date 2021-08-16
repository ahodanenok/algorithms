package ahodanenok.algs4.ch_1_3;

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
}
