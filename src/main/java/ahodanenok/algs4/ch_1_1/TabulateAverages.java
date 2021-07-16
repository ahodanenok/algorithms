package ahodanenok.algs4.ch_1_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Book, exercise 1.1.21
 */
public class TabulateAverages {

    public static void main(String[] args) throws Exception {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        tabulate(lines.iterator(), System.out);
    }

    public static void tabulate(Iterator<String> lines, Appendable out) throws Exception {
        while (lines.hasNext()) {
            String line = lines.next().trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");

            String name = parts[0];
            int a = Integer.parseInt(parts[1]);
            int b = Integer.parseInt(parts[2]);
            double result = (double) a / b;

            out.append(String.format("%s %d %d %.3f%n", name, a, b, result));
        }
    }
}
