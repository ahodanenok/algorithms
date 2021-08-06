package ahodanenok.algs4.ch_1_2;

import edu.princeton.cs.algs4.Date;

import java.util.*;

/**
 * Book, exercise 1.2.13
 */
public final class Transaction implements Comparable<Transaction> {

    public static void main(String[] args) {
        Transaction t1 = new Transaction("A", new Date(8, 4, 2021), 1);
        Transaction t2 = new Transaction("A", new Date(8, 4, 2021), 1);
        Transaction t3 = new Transaction("B", new Date(8, 3, 2021), 3);
        Transaction t4 = new Transaction("C", new Date(8, 1, 2021), 4);
        Transaction t5 = new Transaction("D", new Date(8, 2, 2021), 5);
        Transaction t6 = new Transaction("E", new Date(8, 5, 2021), 6);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(t6);
        transactions.add(t5);
        transactions.add(t4);
        transactions.add(t3);
        transactions.add(t2);
        transactions.add(t1);

        System.out.println("Transactions in order:");
        Collections.sort(transactions);
        for (Transaction t : transactions) {
            System.out.println(t);
        }

        System.out.println();

        System.out.println("Unique transactions:");
        Set<Transaction> unique = new HashSet<>(transactions);
        for (Transaction t : unique) {
            System.out.println(t);
        }
    }

    private final String who;
    private final Date when;
    private final double amount;

    public Transaction(String who, Date when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public String who() {
        return who;
    }

    public Date when() {
        return when;
    }

    public double amount() {
        return amount;
    }

    @Override
    public int compareTo(Transaction other) {
        return when.compareTo(other.when);
    }

    @Override
    public String toString() {
        return String.format("Transaction { who='%s', when='%s', amount=%f", who, when, amount);
    }

    @Override
    public int hashCode() {
        return 31 * 31 * who.hashCode() + 31 * when.hashCode() + Double.hashCode(amount);
    }

    /**
     * Book, exercise 1.2.14
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Transaction other = (Transaction) obj;
        return who.equals(other.who) && when.equals(other.when) && Double.compare(amount, other.amount) == 0;
    }
}
