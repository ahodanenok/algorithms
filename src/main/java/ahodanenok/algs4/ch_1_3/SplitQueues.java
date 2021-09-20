package ahodanenok.algs4.ch_1_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Web, exercise 1.3.53
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class SplitQueues {

    public static void main(String[] args) {
        int count = Integer.parseInt(args[0]);

        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < count; i++) {
            queue.enqueue(StdRandom.uniform(0, 100));
        }

        System.out.println("Queue: " + queue);

        Queue<Integer> odd = new Queue<>();
        Queue<Integer> even = new Queue<>();
        while (!queue.isEmpty()) {
            int num = queue.dequeue();
            if (num % 2 == 0) {
                even.enqueue(num);
            } else {
                odd.enqueue(num);
            }
        }

        System.out.println("Odd:   " + odd);
        System.out.println("Even:  " + even);
    }
}
