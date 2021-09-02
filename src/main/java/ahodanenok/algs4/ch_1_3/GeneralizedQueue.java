package ahodanenok.algs4.ch_1_3;

/**
 * Book, exercise 1.3.38
 *
 * Web, exercise 1.3.3
 * https://algs4.cs.princeton.edu/13stacks/
 */
public interface GeneralizedQueue<T> {

    void insert(T item);

    T delete(int k);

    boolean isEmpty();
}
