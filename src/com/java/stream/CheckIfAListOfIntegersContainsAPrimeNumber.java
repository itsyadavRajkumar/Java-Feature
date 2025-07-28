package com.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CheckIfAListOfIntegersContainsAPrimeNumber {

    public static boolean isPrime(int number) {
        if (number <= 1) return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> prime = Arrays.asList(0, 2, 3, 4, 6, 8, 11, 13);
        boolean num = prime.stream()
                .anyMatch(CheckIfAListOfIntegersContainsAPrimeNumber::isPrime);
        System.out.println(num);

        List<Integer> listPrime = prime.stream()
                .filter(CheckIfAListOfIntegersContainsAPrimeNumber::isPrime)
                .toList();

        System.out.println(listPrime);


        List<Integer> rangedPrime = IntStream.rangeClosed(1, 100)
                .filter(CheckIfAListOfIntegersContainsAPrimeNumber::isPrime)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(rangedPrime);
    }
}
