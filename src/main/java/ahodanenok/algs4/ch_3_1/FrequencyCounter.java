package ahodanenok.algs4.ch_3_1;

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

        Map<String, Integer> frequencies = new HashMap<>();
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.length() >= minLength) {
                frequencies.merge(word, 1, Integer::sum);
            }
        }

        String mostFrequent = frequencies.keySet().iterator().next();
        for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
            if (entry.getValue() > frequencies.get(mostFrequent)) {
                mostFrequent = entry.getKey();
            }
        }

        System.out.println(mostFrequent);
    }
}
