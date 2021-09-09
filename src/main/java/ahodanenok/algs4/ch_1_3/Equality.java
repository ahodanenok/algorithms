package ahodanenok.algs4.ch_1_3;

import edu.princeton.cs.algs4.Queue;

import java.util.Iterator;
import java.util.Objects;

/**
 * Web, exercise 1.3.18
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class Equality {

    public static boolean bagsEqual(Bag<?> firstBag, Bag<?> secondBag) {
        if (firstBag.size() != secondBag.size()) {
            return false;
        }

        for (Object item : firstBag) {
            int firstQueueItemCount = 0;
            for (Object a : firstBag) {
                if (Objects.equals(item, a)) {
                    firstQueueItemCount++;
                }
            }

            int secondBagItemCount = 0;
            for (Object b : secondBag) {
                if (Objects.equals(item, b)) {
                    secondBagItemCount++;
                }
            }

            if (firstQueueItemCount != secondBagItemCount) {
                return false;
            }
        }

        return true;
    }

    public static boolean queuesEqual(Queue<?> firstQueue, Queue<?> secondQueue) {
        if (firstQueue.size() != secondQueue.size()) {
            return false;
        }

        Iterator<?> firstQueueIterator = firstQueue.iterator();
        Iterator<?> secondQueueIterator = secondQueue.iterator();
        while (firstQueueIterator.hasNext()) {
            if (!Objects.equals(firstQueueIterator.next(), secondQueueIterator.next())) {
                return false;
            }
        }

        return true;
    }
}
