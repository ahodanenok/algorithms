package ahodanenok.algs4.ch_1_3;

import java.util.HashSet;
import java.util.Set;

/**
 * Web, exercise 1.3.8
 */
public class TagSystem {

    public static void execute(String initialSymbols, Observer observer) {
        StacksQueue<Character> queue = new StacksQueue<>();
        for (char ch : initialSymbols.toCharArray()) {
            queue.enqueue(ch);
        }

        Set<String> seen = new HashSet<>();
        seen.add(initialSymbols);

        while (queue.size() > 2) {
            char head = queue.dequeue();
            queue.dequeue();
            queue.dequeue();

            if (head == '0') {
                queue.enqueue('0');
                queue.enqueue('0');
            } else if (head == '1') {
                queue.enqueue('1');
                queue.enqueue('1');
                queue.enqueue('0');
                queue.enqueue('1');
            }

            String symbols = queueToString(queue);
            if (!seen.contains(symbols)) {
                observer.onTransition(symbols);
            } else {
                observer.onInfiniteLoop(symbols);
                return;
            }

            seen.add(symbols);
        }

        observer.onHalt(queueToString(queue));
    }

    private static <T> String queueToString(StacksQueue<T> queue) {
        StringBuilder sb = new StringBuilder();

        int remainingCount = queue.size();
        while (remainingCount > 0) {
            T item = queue.dequeue();
            sb.append(item);
            queue.enqueue(item);

            remainingCount--;
        }

        return sb.toString();
    }

    interface Observer {

        void onTransition(String symbols);

        void onHalt(String symbols);

        void onInfiniteLoop(String symbols);
    }
}
