package ahodanenok.algs4.ch_1_4;

/**
 * Book, exercise 1.4.14
 */
public class FourSum {

    public static int count(int[] numbers) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    for (int m = k + 1; m < numbers.length; m++) {
                        if (numbers[i] + numbers[j] + numbers[k] + numbers[m] == 0) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}
