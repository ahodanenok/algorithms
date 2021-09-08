package ahodanenok.algs4.ch_1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

/**
 * Web, exercise 1.3.11
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class Streaming {

    public static void main(String[] args) throws IOException  {
        int k = Integer.parseInt(args[0]);

        CircularStack<Integer> buffer = new CircularStack<>(k);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.push(Integer.parseInt(line));
            }
        }

        System.out.printf("Last %d items:%n", k);
        while (!buffer.isEmpty()) {
            System.out.println(buffer.pop());
        }
    }

    public static class CircularStack<T> {

        private final T[] items;
        private int headIdx;
        private int size;

        @SuppressWarnings("unchecked") // items will contain only T instances added through `push` method
        public CircularStack(int capacity) {
            this.items = (T[]) new Object[capacity];
        }

        public void push(T item) {
            headIdx = (headIdx + 1) % items.length;
            items[headIdx] = item;
            if (size < items.length) {
                size++;
            }
        }

        public T pop() {
            if (isEmpty()) {
                throw new NoSuchElementException("Stack is empty");
            }

            T item = items[headIdx];
            items[headIdx] = null;
            headIdx = (items.length + headIdx - 1) % items.length;
            size--;

            return item;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }
}
