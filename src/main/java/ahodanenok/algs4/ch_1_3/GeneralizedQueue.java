package ahodanenok.algs4.ch_1_3;

/**
 * Book, exercise 1.3.38
 */
public interface GeneralizedQueue<T> {

    void insert(T item);

    T delete(int k);

    boolean isEmpty();
}
