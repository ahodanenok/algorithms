package ahodanenok.algs4.ch_1_3;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * Web, exercise 1.3.62
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class StockPrices {

    public static void main(String[] args) {
        int[] prices = new int[StdRandom.uniform(10, 20)];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = StdRandom.uniform(0, 10);
        }
        System.out.println("Prices: " + Arrays.toString(prices));

        int[] days = calculateDays(prices);
        System.out.println("Days:   " + Arrays.toString(days));
    }

    public static int[] calculateDays(int[] prices) {
        int[] days = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int day = 0; day < prices.length; day++) {
            int price = prices[day];
            while (stack.size() > 0 && prices[stack.peek()] < price) {
                int d = stack.pop();
                days[d] = day - d;
            }

            stack.push(day);
        }

        while (stack.size() > 0) {
            days[stack.pop()] = -1;
        }

        return days;
    }
}
