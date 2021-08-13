package ahodanenok.algs4.ch_1_3;

import java.util.Scanner;

/**
 * Book, exercise 1.3.15
 */
public class KthQueueElement {

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]); // 1-based
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            queue.enqueue(scanner.nextLine());
        }

        System.out.println(kth(queue, k));
    }

    public static String kth(ResizingArrayQueueOfStrings queue, int k) {
        if (k > queue.size() || k < 0) {
            throw new IllegalArgumentException(queue.size() + " " + k);
        }

        int skipCount = queue.size() - k;
        for (int i = 0; i < skipCount; i++) {
            queue.dequeue();
        }

        return queue.dequeue();
    }
}
