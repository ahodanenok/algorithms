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

    /**
     * Book, exercise 1.2.12
     */
    public String dayOfWeek() {
        // https://en.wikipedia.org/wiki/Determination_of_the_day_of_the_week#Gauss.27s_algorithm
        int[] monthOffsets     = { 0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };
        int[] monthOffsetsLeap = { 0, 3, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6 };
        String[] dayNames = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

        int mo;
        if (LocalDate.of(year, month, day).isLeapYear()) {
            mo = monthOffsetsLeap[month - 1];
        } else {
            mo = monthOffsets[month - 1];
        }

        int y = year - 1;
        int dw = (day + mo + 5 * (y % 4) + 4 * (y % 100) + 6 * (y % 400)) % 7;

        return dayNames[dw];
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
}
