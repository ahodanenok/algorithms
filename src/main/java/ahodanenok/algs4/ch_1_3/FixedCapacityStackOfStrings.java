package ahodanenok.algs4.ch_1_3;

public class FixedCapacityStackOfStrings {

    private final String[] stack;
    private int size;

    public FixedCapacityStackOfStrings(int capacity) {
        this.stack = new String[capacity];
    }

    public void push(String s) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }

        stack[size++] = s;
    }

    public String pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }

        String s = stack[--size];
        stack[size] = null;
        return s;
    }

    public int size() {
        return size;
    }

    /**
     * Book, exercise 1.3.1
     */
    public boolean isFull() {
        return size == stack.length;
    }
}
