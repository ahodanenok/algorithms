package ahodanenok.algs4.ch_1_3;

import edu.princeton.cs.algs4.Queue;

import java.io.*;

/**
 * Web, exercise 1.3.1
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class Tail {

    public static void main(String[] args) {
        int linesCount = Integer.parseInt(args[0]);
        System.out.println(read(System.in, linesCount));
    }

    public static String read(InputStream in, int linesCount) {
        Queue<String> queue = new Queue<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                queue.enqueue(line);
                if (queue.size() > linesCount) {
                    queue.dequeue();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.dequeue());
            if (queue.size() > 0) {
                sb.append(System.lineSeparator());
            }
        }

        return sb.toString();
    }
}
