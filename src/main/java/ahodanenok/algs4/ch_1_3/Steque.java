package ahodanenok.algs4.ch_1_3;

public interface Steque<T> {

    T pop();

    T peek();

    void push(T item);

    void enqueue(T item);

    int size();
}
