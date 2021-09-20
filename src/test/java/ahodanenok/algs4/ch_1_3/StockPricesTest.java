package ahodanenok.algs4.ch_1_3;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class StockPricesTest {

    @Test
    public void testEmpty() {
        assertArrayEquals(new int[0], StockPrices.calculateDays(new int[0]));
    }

    @Test
    public void testSingleDay() {
        assertArrayEquals(new int[] { -1 }, StockPrices.calculateDays(new int[] { 5 }));
    }

    @Test
    public void testEqual() {
        assertArrayEquals(new int[] { -1, -1, -1, -1 }, StockPrices.calculateDays(new int[] { 2, 2, 2, 2 }));
    }

    @Test
    public void testIncreasing() {
        assertArrayEquals(new int[] { 1, 1, 1, 1, -1 }, StockPrices.calculateDays(new int[] { 1, 2, 3, 4, 5 }));
    }

    @Test
    public void testDecreasing() {
        assertArrayEquals(new int[] { -1, -1, -1, -1, -1 }, StockPrices.calculateDays(new int[] { 5, 4, 3, 2, 1 }));
    }

    @Test
    public void testWave() {
        assertArrayEquals(
            new int[] { 6, 4, 2, 1, 1, 1, 1, 3, 1, 1, -1, 2, 1, -1 },
            StockPrices.calculateDays(new int[] { 4, 3, 2, 2, 3, 4, 5, 6, 2, 3, 7, 1, 0, 3 }));
    }

    @RepeatedTest(1000)
    public void testRandom() {
        int[] prices = new int[StdRandom.uniform(10, 50)];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = StdRandom.uniform(1, 20);
        }

        int[] days = StockPrices.calculateDays(prices);
        for (int i = 0; i < days.length; i++) {
            int to = days[i] == -1 ? days.length : i + days[i];
            for (int j = i + 1; j < to; j++) {
                assertTrue(prices[i] >= prices[j], () -> Arrays.toString(prices) + " -> " + Arrays.toString(days));
            }

            if (days[i] != -1) {
                assertTrue(prices[i] < prices[to], () -> Arrays.toString(prices) + " -> " + Arrays.toString(days));
            }
        }
    }
}
