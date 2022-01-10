package ahodanenok.algs4.ch_3_1;

import ahodanenok.algs4.ch_1_3.Stack;
import edu.princeton.cs.algs4.StdIn;

import java.io.FileReader;
import java.util.*;

public class FrequencyCounter {

    // Book, exercise 3.1.8: the

    public static void main(String[] args) throws Exception {
        String file = args[0];

        int minLength;
        if (args.length > 1) {
            minLength = Integer.parseInt(args[1]);
        } else {
            minLength = 1;
        }

        List<String> countFrequencies = new ArrayList<>();
        while (!StdIn.isEmpty()) {
            countFrequencies.add(StdIn.readLine().toLowerCase());
        }

        // Book, exercise 3.1.9
        int processedCount = 0;
        String lastPut = null;

        Map<String, Integer> frequencies = new HashMap<>();
        try (Scanner reader = new Scanner(new FileReader(file))) {
            while (reader.hasNext()) {
                String word = reader.next().toLowerCase();
                if (word.length() >= minLength) {
                    frequencies.merge(word, 1, Integer::sum);
                    lastPut = word;
                }

                processedCount++;
            }
        }

        int highestFrequency = frequencies.values().stream().mapToInt(Integer::intValue).max().orElse(0);

        // Book, exercise 3.1.19
        Stack<String> mostFrequent = new Stack<>();
        for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
            if (entry.getValue() == highestFrequency) {
                mostFrequent.push(entry.getKey());
            }
        }

        System.out.printf("The most frequent words (%d times):%n", highestFrequency);
        for (String w : mostFrequent) {
            System.out.println(w);
        }

        System.out.println();
        System.out.println("processed count = " + processedCount);
        System.out.println("last word put = " + lastPut);

        // Book, exercise 3.1.26
        if (!countFrequencies.isEmpty()) {
            int width = countFrequencies.stream().mapToInt(String::length).max().orElse(15);
            countFrequencies.sort(Comparator.comparingInt(w -> frequencies.getOrDefault(w, 0)).reversed());

            System.out.println();
            System.out.println("Word frequencies:");
            for (String w : countFrequencies) {
                System.out.printf("%" + width + "s %d%n", w, frequencies.getOrDefault(w, 0));
            }
        }
    }
}
