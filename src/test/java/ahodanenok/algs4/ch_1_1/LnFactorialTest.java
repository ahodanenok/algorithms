package ahodanenok.algs4.ch_1_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class LnFactorialTest {

    @Test
    public void checkNumbers() throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                LnFactorialTest.class.getResourceAsStream("/ahodanenok/algs4/ch_1_1/factorial.txt")))) {

            int n = 1;
            String line;
            while ((line = reader.readLine()) != null) {
                Assertions.assertEquals(new BigInteger(line), LnFactorial.f(n));
                n++;
            }
        }
    }
}
