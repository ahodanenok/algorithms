package ahodanenok.algs4.ch_1_3;

import java.util.Scanner;

/**
 * Exercise 1.3.14
 */
public class ResizingArrayQueueOfStrings {

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            queue.enqueue(scanner.nextLine());
        }

        while (queue.size() > 0) {
            System.out.println(queue.dequeue());
        }
    }

    private static final int DEFAULT_INITIAL_CAPACITY = 10;

    private String[] items;
    private int offset;
    private int size;

    public ResizingArrayQueueOfStrings() {
        this.items = new String[DEFAULT_INITIAL_CAPACITY];
    }

    public void enqueue(String item) {
        items[offset + size] = item;
        size++;
    }

    public String dequeue() {
        String item = items[offset];
        items[offset] = null;
        offset++;
        size--;
        return item;
    }

    public int size() {
        return size;
    }
}
