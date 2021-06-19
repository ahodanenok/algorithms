package ahodanenok.algs4.ch_1_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class FibonacciTest {

    @Test
    public void checkNumbers() throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                FibonacciTest.class.getResourceAsStream("/ahodanenok/algs4/ch_1_1/fibonacci.txt")))) {

            int n = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                Assertions.assertEquals(new BigInteger(line), Fibonacci.f(n));
                n++;
            }
        }
    }
}
