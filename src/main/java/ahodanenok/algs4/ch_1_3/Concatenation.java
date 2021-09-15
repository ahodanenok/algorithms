package ahodanenok.algs4.ch_1_3;

import edu.princeton.cs.algs4.Queue;

/**
 * Book, exercise 1.3.47
 */
public class Concatenation {

    @SafeVarargs
    public static <T> Queue<T> concatenateQueues(Queue<T>... queues) {
        Queue<T> result = new Queue<>();
        for (Queue<T> q : queues) {
            while (!q.isEmpty()) {
                result.enqueue(q.dequeue());
            }
        }

        return result;
    }

    @SafeVarargs
    public static <T> Stack<T> concatenateStacks(Stack<T>... stacks) {
        Node<T> lastItem = null;
        for (Stack<T> s : stacks) {
            while (s.size() > 0) {
                Node<T> item = new Node<>(s.pop());
                if (lastItem != null) {
                    item.next = lastItem;
                }

                lastItem = item;
            }
        }

        Stack<T> result = new Stack<>();

        Node<T> currentItem = lastItem;
        while (currentItem != null) {
            result.push(currentItem.value);
            currentItem = currentItem.next;
        }

        return result;
    }

    @SafeVarargs
    public static <T> Steque<T> concatenateSteques(Steque<T>... steques) {
        Steque<T> result = new LinkedListSteque<>();
        for (Steque<T> s : steques) {
            while (s.size() > 0) {
                result.enqueue(s.pop());
            }
        }

        return result;
    }
}
