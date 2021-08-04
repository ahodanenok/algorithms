package ahodanenok.algs4.ch_1_2;

import java.time.LocalDate;

/**
 * Book, exercise 1.2.11
 */
public class SmartDate {

    private final int month;
    private final int day;
    private final int year;

    public SmartDate(int year, int month, int day) {
        validate(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private void validate(int year, int month, int day) {
        if (year < 0 || year > 9999) {
            throw new IllegalArgumentException("Year must be in range [0, 9999]");
        }

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be in range [1, 12]");
        }

        // oh no, not again this check (leap year) :)
        LocalDate date = LocalDate.of(year, month, 1);
        if (day < 1 || day > date.lengthOfMonth()) {
            throw new IllegalArgumentException("Day must be in range [1, " + date.lengthOfMonth() + "]");
        }
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
}
