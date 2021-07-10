package ahodanenok.algs4.ch_1_1;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Exercise 1.1.35
 */
public class DiceSimulation {

    // number of sides in a dice
    private static final int SIDES = 6;

    // print current probabilities every ... iterations
    private static final int SIMULATIONS_COUNT_IN_ROW = 10000;

    // width of the first column
    private static final int PREFIX_WIDTH = 12;

    // number of digits to print in probabilities after the decimal point
    private static final int PROBABILITY_DIGITS = 7;

    // stop when results match expected probabilities to the given precision
    private static final double EPSILON = 10e-5;

    public static void main(String[] args) {
        // print all possible sums
        printPrefix("sum");
        for (int s = 2; s <= 2 * SIDES; s++) {
            // two additional spaces because of '0,' prefix in probabilities
            System.out.printf(" %-" + (PROBABILITY_DIGITS + 2) + "d", s);
        }
        System.out.println();

        // print probabilities for each sum
        double[] p = getProbabilities();
        printPrefix("expected");
        printProbabilities(p);
        System.out.println();

        // run simulations
        Random d1 = new Random();
        Random d2 = new Random();
        int[] sumCount = new int[p.length];
        for (int n = 1; ; n++) {
            // +2 because side values start with 1
            sumCount[d1.nextInt(SIDES) + d2.nextInt(SIDES) + 2]++;

            // stop when all probabilities match expected with the given precision
            double[] pc = calculateProbabilities(n, sumCount);
            if (IntStream.range(0, p.length).allMatch(i -> Math.abs(p[i] - pc[i]) < EPSILON)) {
                printSimulationResult(n, sumCount);
                System.out.printf("Matched expected probabilities at N=%d with e=%f%n", n, EPSILON);
                break;
            }

            if (n % SIMULATIONS_COUNT_IN_ROW == 0) {
                printSimulationResult(n, sumCount);
            }
        }
    }

    private static void printPrefix(String str) {
        System.out.printf("%" + PREFIX_WIDTH + "s:", str);
    }

    private static void printProbabilities(double[] p) {
        for (int i = 2; i < p.length; i++) {
            System.out.printf(" %." + PROBABILITY_DIGITS + "f", p[i]);
        }
    }

    private static void printSimulationResult(int n, int[] sumCount) {
        printPrefix(n + "");
        printProbabilities(calculateProbabilities(n, sumCount));
        System.out.println();
    }

    private static double[] calculateProbabilities(int n, int[] sumCount) {
        double[] p = new double[sumCount.length];
        for (int i = 2; i < sumCount.length; i++) {
            p[i] = sumCount[i] / (double) n;
        }

        return p;
    }

    // provided in the exercise
    private static double[] getProbabilities() {
        double[] dist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i + j] += 1.0;
        for (int k = 2; k <= 2 * SIDES; k++)
            dist[k] /= 36.0;

        return dist;
    }
}
