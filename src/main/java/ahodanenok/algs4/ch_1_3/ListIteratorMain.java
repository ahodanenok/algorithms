package ahodanenok.algs4.ch_1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ListIterator;
import java.util.StringJoiner;

/**
 * Web, exercise 1.3.21
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class ListIteratorMain {

    public static void main(String[] args) throws IOException {
        ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<>();
        deque.pushRight(1);
        deque.pushRight(2);
        deque.pushRight(3);
        deque.pushRight(4);
        deque.pushRight(5);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            ListIterator<Integer> iterator = deque.listIterator();
            while (true) {
                StringJoiner toStringBuilder = new StringJoiner(", ", "[", "]");
                for (int n : deque) {
                    toStringBuilder.add(n + "");
                }
                System.out.println(toStringBuilder);
                System.out.printf("hasPrevious: %b, at index %d%n", iterator.hasPrevious(), iterator.previousIndex());
                System.out.printf("hasNext: %b, at index %d%n", iterator.hasNext(), iterator.nextIndex());
                System.out.print(">");

                String cmd = reader.readLine();
                if (cmd == null || "x".equals(cmd)) {
                    break;
                }

                if ("n".equals(cmd)) {
                    System.out.println(iterator.next());
                } else if ("p".equals(cmd)) {
                    System.out.println(iterator.previous());
                } else if ("-".equals(cmd)) {
                    iterator.remove();
                } else if (cmd.startsWith("+")) {
                    iterator.add(Integer.parseInt(cmd.substring(1)));
                } else if (cmd.startsWith("~")) {
                    iterator.set(Integer.parseInt(cmd.substring(1)));
                } else {
                    System.out.println("???");
                }

                System.out.println();
            }
        }
    }
}
