package ahodanenok.algs4.ch_1_3;

import java.util.*;

/**
 * Web, exercise 1.3.38
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class MultiwordSearch {

    public static class Interval {

        final int from;
        final int to;

        public Interval(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return String.format("[%d, %d]", from, to);
        }
    }

    public static Interval search(List<String> documentWords, List<String> searchWords) {
        if (documentWords.isEmpty() || searchWords.isEmpty()) {
            return null;
        }

        @SuppressWarnings("unchecked")
        LinkedList<Integer>[] index = (LinkedList<Integer>[]) new LinkedList[searchWords.size()];
        for (int i = 0; i < documentWords.size(); i++) {
            for (int j = 0; j < searchWords.size(); j++) {
                if (documentWords.get(i).equals(searchWords.get(j))) {
                    LinkedList<Integer> positions = index[j];
                    if (positions == null) {
                        positions = new LinkedList<>();
                        index[j] = positions;
                    }

                    positions.addLast(i);
                }
            }
        }

        for (LinkedList<Integer> positions : index) {
            if (positions == null) {
                return null;
            }
        }

        int intervalMin = -1;
        int intervalMax = documentWords.size();

        LinkedList<Integer> firstPositions = index[0];
        LinkedList<Integer> lastPositions = index[index.length - 1];

        search:
        while (!firstPositions.isEmpty()) {
            int limit = firstPositions.getFirst();
            for (int i = 1; i < index.length; i++) {
                LinkedList<Integer> positions = index[i];
                while (!positions.isEmpty() && positions.peekFirst() < limit) {
                    positions.removeFirst();
                }

                if (positions.isEmpty()) {
                    break search;
                }

                limit = positions.getFirst();
            }

            int from = firstPositions.getFirst();
            int to = lastPositions.getFirst();
            if (to - from < intervalMax - intervalMin) {
                intervalMin = from;
                intervalMax = to;
            }

            firstPositions.removeFirst();
        }

        if (intervalMin == -1) {
            return null;
        }

        return new Interval(intervalMin, intervalMax);
    }
}
