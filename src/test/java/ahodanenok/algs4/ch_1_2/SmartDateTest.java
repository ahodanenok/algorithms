package ahodanenok.algs4.ch_1_2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDateTest {

    @Test
    public void testYearInvalidLow() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            new SmartDate(-1, 12, 1);
        });

        assertEquals("Year must be in range [0, 9999]", e.getMessage());
    }

    @Test
    public void testYearInvalidHigh() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            new SmartDate(10000, 1, 1);
        });

        assertEquals("Year must be in range [0, 9999]", e.getMessage());
    }

    @Test
    public void testMonthInvalidLow() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            new SmartDate(2021, 0, 1);
        });

        assertEquals("Month must be in range [1, 12]", e.getMessage());
    }

    @Test
    public void testMonthInvalidHigh() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            new SmartDate(2021, 13, 1);
        });

        assertEquals("Month must be in range [1, 12]", e.getMessage());
    }

    @Test
    public void testMonthValid(TestReporter reporter) {
        assertDoesNotThrow(() -> {
            for (int m = 1; m <= 12; m++) {
                new SmartDate(2021, m, 1);
            }
        });
    }

    @Test
    public void testDayInvalidLow() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            new SmartDate(2021, 1, 0);
        });

        assertEquals("Day must be in range [1, 31]", e.getMessage());
    }

    @Test
    public void testDayInvalidFebHigh() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            new SmartDate(2021, 2, 29);
        });

        assertEquals("Day must be in range [1, 28]", e.getMessage());
    }

    @Test
    public void testDayValidFeb() {
        assertDoesNotThrow(() -> new SmartDate(2021, 2, 28));
    }

    @Test
    public void testDayInvalidFebLeap() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            new SmartDate(2020, 2, 30);
        });

        assertEquals("Day must be in range [1, 29]", e.getMessage());
    }

    @Test
    public void testDayValidFebLeap() {
        assertDoesNotThrow(() -> new SmartDate(2020, 2, 29));
    }

    @Test
    public void testDayInvalid31(TestReporter reporter) {
        for (int m : Arrays.asList(4, 6, 9, 11)) {
            reporter.publishEntry("month", m + "");

            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
                new SmartDate(2021, m, 31);
            });

            assertEquals("Day must be in range [1, 30]", e.getMessage());
        }
    }

    @Test
    public void testDayValid31(TestReporter reporter) {
        for (int m : Arrays.asList(1, 3, 5, 7, 8, 10, 12)) {
            reporter.publishEntry("month", m + "");
            assertDoesNotThrow(() -> new SmartDate(2021, m, 31));
        }
    }

    @Test
    public void testDayInvalidHigh(TestReporter reporter) {
        for (int m : Arrays.asList(1, 3, 5, 7, 8, 10, 12)) {
            reporter.publishEntry("month", m + "");

            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
                new SmartDate(2021, m, 32);
            });

            assertEquals("Day must be in range [1, 31]", e.getMessage());
        }
    }

}
