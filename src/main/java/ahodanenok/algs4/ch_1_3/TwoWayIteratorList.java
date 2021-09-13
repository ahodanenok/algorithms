package ahodanenok.algs4.ch_1_3;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Web, exercise 1.3.22
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class TwoWayIteratorList<T> {

    private final DoubleNode<T> firstNode;

    @SafeVarargs
    public TwoWayIteratorList(T... items) {
        firstNode = items.length > 0 ? DoubleNode.list(items[0], Arrays.copyOfRange(items, 1, items.length)) : null;
    }

    public TwoWayIterator iterator() {
        return new TwoWayIterator();
    }

    public class TwoWayIterator {

        private DoubleNode<T> currentNode = firstNode;
        private DoubleNode<T> previousNode;

        public boolean hasNext() {
            return currentNode != null;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("next");
            }

            T item = currentNode.value;
            previousNode = currentNode;
            currentNode = currentNode.next;

            return item;
        }

        public boolean hasPrevious() {
            return previousNode != null;
        }

        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException("previous");
            }

            currentNode = previousNode;
            previousNode = currentNode.prev;

            return currentNode.value;
        }
    }
}
