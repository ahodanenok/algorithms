package ahodanenok.algs4.ch_1_3;

import edu.princeton.cs.algs4.Queue;

/**
 * Book, exercise 1.3.41
 */
public class CopyQueue {

    public static <T> Queue<T> copy(Queue<T> queue) {
        Queue<T> copy = new Queue<>();
        if (queue.isEmpty()) {
            return copy;
        }

        int size = queue.size();
        for (int i = 0; i < size; i++) {
            T item = queue.dequeue();
            copy.enqueue(item);
            queue.enqueue(item);
        }

        return copy;
    }
}
