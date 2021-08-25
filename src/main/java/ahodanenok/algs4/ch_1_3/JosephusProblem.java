package ahodanenok.algs4.ch_1_3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Book, exercise 1.3.37
 */
public class JosephusProblem {

    public static void main(String[] args) {
        int participantsCount = Integer.parseInt(args[0]);
        int eliminationOffset = Integer.parseInt(args[1]);

        List<Integer> order = determineEliminationOrder(participantsCount, eliminationOffset);
        System.out.println(order.stream().map(s -> Integer.toString(s)).collect(Collectors.joining(" ")));
    }

    public static List<Integer> determineEliminationOrder(int participantsCount, int eliminationOffset) {
        if (eliminationOffset < 1) {
            throw new IllegalArgumentException("Elimination offset must be > 0");
        }

        if (participantsCount < 0) {
            throw new IllegalArgumentException("Participants count must be >= 0");
        }

        // wanted to use one of my implementations from this section
        CircularListQueue<Integer> participants = new CircularListQueue<>();
        for (int n = 0; n < participantsCount; n++) {
            participants.enqueue(n);
        }

        List<Integer> order = new ArrayList<>();
        while (participants.size() > 0) {
            // fast-forward
            int remainingOffset = (eliminationOffset - 1) % participants.size();
            for (int offset = 0; offset < remainingOffset; offset++) {
                participants.enqueue(participants.dequeue());
            }

            order.add(participants.dequeue());
        }

        return order;
    }
}
