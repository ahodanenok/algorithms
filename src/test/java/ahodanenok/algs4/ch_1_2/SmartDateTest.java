package ahodanenok.algs4.ch_1_2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

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

    @ParameterizedTest
    @MethodSource("getDayOfWeekData")
    public void testDayOfWeek(SmartDate date, String dayOfWeek) {
        assertEquals(dayOfWeek, date.dayOfWeek());
    }

    private static Stream<Arguments> getDayOfWeekData() {
        return Stream.of(
            Arguments.of(new SmartDate(2021, 1, 1), "Friday"),
            Arguments.of(new SmartDate(2020, 2, 10), "Monday"),
            Arguments.of(new SmartDate(2019, 3, 20), "Wednesday"),
            Arguments.of(new SmartDate(2018, 4, 29), "Sunday"),
            Arguments.of(new SmartDate(2017, 5, 2), "Tuesday"),
            Arguments.of(new SmartDate(2016, 6, 10), "Friday"),
            Arguments.of(new SmartDate(2015, 7, 23), "Thursday"),
            Arguments.of(new SmartDate(2014, 8, 30), "Saturday"),
            Arguments.of(new SmartDate(2013, 9, 1), "Sunday"),
            Arguments.of(new SmartDate(2012, 10, 10), "Wednesday"),
            Arguments.of(new SmartDate(2011, 11, 18), "Friday"),
            Arguments.of(new SmartDate(2010, 12, 30), "Thursday"),
            Arguments.of(new SmartDate(2009, 1, 3), "Saturday"),
            Arguments.of(new SmartDate(2008, 2, 29), "Friday"),
            Arguments.of(new SmartDate(2007, 3, 20), "Tuesday"),
            Arguments.of(new SmartDate(2006, 4, 30), "Sunday"),
            Arguments.of(new SmartDate(2005, 5, 2), "Monday"),
            Arguments.of(new SmartDate(2004, 6, 12), "Saturday"),
            Arguments.of(new SmartDate(2003, 7, 22), "Tuesday"),
            Arguments.of(new SmartDate(2002, 8, 30), "Friday"),
            Arguments.of(new SmartDate(2001, 9, 5), "Wednesday"),
            Arguments.of(new SmartDate(2000, 10, 10), "Tuesday"),
            Arguments.of(new SmartDate(1999, 11, 20), "Saturday"),
            Arguments.of(new SmartDate(1953, 12, 31), "Thursday"),
            Arguments.of(new SmartDate(1952, 1, 1), "Tuesday"),
            Arguments.of(new SmartDate(1951, 2, 10), "Saturday"),
            Arguments.of(new SmartDate(1950, 3, 20), "Monday"),
            Arguments.of(new SmartDate(1949, 4, 29), "Friday"),
            Arguments.of(new SmartDate(1948, 5, 6), "Thursday"),
            Arguments.of(new SmartDate(1902, 6, 10), "Tuesday"),
            Arguments.of(new SmartDate(1901, 7, 20), "Saturday"),
            Arguments.of(new SmartDate(1900, 8, 30), "Thursday"),
            Arguments.of(new SmartDate(1899, 9, 1), "Friday"),
            Arguments.of(new SmartDate(1898, 10, 10), "Monday"));
    }
}
