package ahodanenok.algs4.ch_3_1;

import edu.princeton.cs.algs4.StdIn;

import java.util.HashMap;
import java.util.Map;

/**
 * Book, exercise 3.1.1
 */
public class GPA {

    public static void main(String[] args) {
        Map<String, Float> grades = new HashMap<>();
        grades.put("A+", 4.33f);
        grades.put("A",  4.00f);
        grades.put("A-", 3.67f);
        grades.put("B+", 3.33f);
        grades.put("B",  3.00f);
        grades.put("B-", 2.67f);
        grades.put("C+", 2.33f);
        grades.put("C",  2.00f);
        grades.put("C-", 1.67f);
        grades.put("D",  1.00f);
        grades.put("F",  0.00f);

        float score = 0;
        int count = 0;
        while (StdIn.hasNextLine()) {
            String grade = StdIn.readLine().trim().toUpperCase();
            if (!grades.containsKey(grade)) {
                System.out.printf("Unknown grade: '%s'%n", grade);
                continue;
            }

            score += grades.get(grade);
            count++;
        }

        if (count == 0) {
            System.out.println("No scores provided");
            return;
        }

        System.out.printf("GPA: %.2f%n", score / count);
    }
}
