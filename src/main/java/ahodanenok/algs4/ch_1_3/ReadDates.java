package ahodanenok.algs4.ch_1_3;

import edu.princeton.cs.algs4.Date;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Book, exercise 1.3.16
 */
public class ReadDates {

    public static void main(String[] args) throws Exception {
        Date[] dates = read();

        System.out.println("Dates count: " + dates.length);
        System.out.println();
        for (Date d : dates) {
            System.out.println(d);
        }
    }

    private static Date[] read() throws Exception {
        List<Date> dates = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = reader.readLine()) != null) {
            dates.add(parseDate(str));
        }

        return dates.toArray(new Date[0]);
    }

    private static Date parseDate(String str) {
        String[] dateParts = str.split("/");
        int month = Integer.parseInt(dateParts[0]);
        int day = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);

        return new Date(month, day, year);
    }
}
