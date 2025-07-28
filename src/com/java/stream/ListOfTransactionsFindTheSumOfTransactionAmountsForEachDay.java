package com.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListOfTransactionsFindTheSumOfTransactionAmountsForEachDay {

    public static class Transaction {
        String date;
        double amt;

        public Transaction(String date, double amt) {
            this.date = date;
            this.amt = amt;
        }
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 200),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 400),
                new Transaction("2022-01-03", 500)
        );

        List<Map.Entry<String, Double>> sumOfAmt = transactions.stream()
                .collect(Collectors.groupingBy(x -> x.date, Collectors.summingDouble(x -> x.amt)))
                .entrySet().stream().toList();

        for (Map.Entry<String, Double> it:sumOfAmt) {
            System.out.println(it.getKey() + "->" + it.getValue());
        }
    }
}
