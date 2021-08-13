package ahodanenok.algs4.ch_1_3;

import ahodanenok.algs4.ch_1_2.Transaction;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Book, exercise 1.3.17
 */
public class ReadTransactions {

    public static void main(String[] args) throws Exception {
        Transaction[] transactions = read();

        System.out.println("Transactions count: " + transactions.length);
        System.out.println();
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    private static Transaction[] read() throws Exception {
        List<Transaction> dates = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = reader.readLine()) != null) {
            dates.add(Transaction.from(str));
        }

        return dates.toArray(new Transaction[0]);
    }
}
