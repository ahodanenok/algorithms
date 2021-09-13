package ahodanenok.algs4.ch_1_3;

import java.util.Iterator;
import java.util.StringJoiner;

public class Bag<T> implements Iterable<T> {

    // being lazy :)
    private final Stack<T> items = new Stack<>();

    public void add(T item) {
        items.push(item);
    }

    /**
     * Web, exercise 1.3.23
     * https://algs4.cs.princeton.edu/13stacks/
     */
    public void addAll(Bag<T> other) {
        for (T item : other) {
            add(item);
        }
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (T n : this) {
            joiner.add(n + "");
        }

        return joiner.toString();
    }
}
