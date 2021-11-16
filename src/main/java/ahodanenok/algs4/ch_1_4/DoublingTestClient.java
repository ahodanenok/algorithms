package ahodanenok.algs4.ch_1_4;

import java.util.ArrayList;
import java.util.List;

public class DoublingTestClient {

    public interface Algorithm {

        String getName();

        long execute(int n);
    }

    private final List<Algorithm> algorithms;

    public DoublingTestClient() {
        this.algorithms = new ArrayList<>();
    }

    public void addAlgorithm(Algorithm algorithm) {
        this.algorithms.add(algorithm);
    }

    public void run() {
        int doublingCount = 30;
        int inputSize = 1;
        long[] prevTime = new long[algorithms.size()];

        System.out.printf("%10s", " ");
        for (Algorithm alg : algorithms) {
            System.out.printf(" | %15s", alg.getName());
        }
        System.out.println();

        for (int n = 0; n < doublingCount; n++) {
            System.out.printf("%10d", inputSize);
            for (int i = 0; i < algorithms.size(); i++) {
                Algorithm alg = algorithms.get(i);
                long time = alg.execute(inputSize);

                double ratio = prevTime[i] > 0 ? (double) time / prevTime[i] : 1;
                System.out.printf(" | %15s", String.format("%5d (%.1f)", time, ratio));

                prevTime[i] = time;
            }

            inputSize *= 2;
            System.out.println();
        }
    }
}
