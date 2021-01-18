package ahodanenok.algs4.ch_1_3;

import java.util.Scanner;

/**
 * Exercise 1.3.15
 */
public class KthQueueElement {

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            queue.enqueue(scanner.nextLine());
        }

        System.out.println(kth(queue, k));
    }

    public static String kth(ResizingArrayQueueOfStrings queue, int k) {
        if (queue.size() <= k || k < 0) {
            throw new IllegalArgumentException(queue.size() + " " + k);
        }

        int targetIdx = queue.size() - k - 1;
        for (int i = 0; i < targetIdx; i++) queue.dequeue();
        return queue.dequeue();
    }
}
