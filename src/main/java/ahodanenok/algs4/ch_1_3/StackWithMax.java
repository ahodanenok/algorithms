package ahodanenok.algs4.ch_1_3;

/**
 * Web, exercise 1.3.5
 * Web, exercise 1.3.58
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class StackWithMax<T extends Comparable<T>> {

    private final Stack<T> items = new Stack<>();
    private final Stack<T> maxItems = new Stack<>();

    public void push(T item) {
        items.push(item);
        if (maxItems.size() == 0 || maxItems.peek().compareTo(item) <= 0) {
            maxItems.push(item);
        }
    }

    public T pop() {
        T item = items.pop();
        if (item.compareTo(maxItems.peek()) == 0) {
            maxItems.pop();
        }

        return item;
    }

    public T peek() {
        return items.peek();
    }

    public T max() {
        return maxItems.peek();
    }

    public int size() {
        return items.size();
    }
}
