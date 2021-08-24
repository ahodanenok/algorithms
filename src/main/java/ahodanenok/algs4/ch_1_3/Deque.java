package ahodanenok.algs4.ch_1_3;

/**
 * Book, exercise 1.3.33
 */
public interface Deque<T> extends Iterable<T> {

    void pushLeft(T item);

    T popLeft();

    void pushRight(T item);

    T popRight();

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }
}
