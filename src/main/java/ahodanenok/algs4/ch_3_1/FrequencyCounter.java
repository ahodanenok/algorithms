package ahodanenok.algs4.ch_3_1;

import ahodanenok.algs4.ch_1_3.Stack;
import edu.princeton.cs.algs4.StdIn;

import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter {

    // Book, exercise 3.1.8: the

    public static void main(String[] args) {
        int minLength;
        if (args.length > 0) {
            minLength = Integer.parseInt(args[0]);
        } else {
            minLength = 1;
        }

        // Book, exercise 3.1.9
        int processedCount = 0;
        String lastPut = null;

        Map<String, Integer> frequencies = new HashMap<>();
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.length() >= minLength) {
                frequencies.merge(word, 1, Integer::sum);
                lastPut = word;
            }

            processedCount++;
        }

        int highestFrequency = Integer.MIN_VALUE;
        for (Integer fq : frequencies.values()) {
            if (fq > highestFrequency) {
                highestFrequency = fq;
            }
        }

        // Book, exercise 3.1.19
        Stack<String> mostFrequent = new Stack<>();
        for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
            if (entry.getValue() == highestFrequency) {
                mostFrequent.push(entry.getKey());
            }
        }

        for (String w : mostFrequent) {
            System.out.println(w);
        }

        System.out.println();
        System.out.println("processed count = " + processedCount);
        System.out.println("last word put = " + lastPut);
    }
}
