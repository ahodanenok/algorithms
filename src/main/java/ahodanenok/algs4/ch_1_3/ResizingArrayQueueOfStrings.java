package ahodanenok.algs4.ch_1_3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    public static final int DEFAULT_INITIAL_CAPACITY = 10;

    private String[] items;
    private int offset;
    private int size;

    public ResizingArrayQueueOfStrings() {
        this.items = new String[DEFAULT_INITIAL_CAPACITY];
    }

    public void enqueue(String item) {
        // offset could change in resize, so offset+size is not stored in a variable
        if (offset + size == items.length) {
            if (size > items.length / 2) {
                resize(items.length * 2);
            } else {
                // move elements to the start of items array
                resize(items.length);
            }
        }

        items[offset + size] = item;
        size++;
    }

    public String dequeue() {
        String item = items[offset];
        items[offset] = null;
        offset++;
        size--;

        if (size < items.length / 4) {
            resize(items.length / 2);
        }

        return item;
    }

    public int size() {
        return size;
    }

    private void resize(int newLength) {
        String[] data = items;
        items = new String[newLength];
        System.arraycopy(data, offset, items, 0, size);
        offset = 0;
    }

    @Override
    public String toString() {
        return Arrays.stream(items, offset, offset + size)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
