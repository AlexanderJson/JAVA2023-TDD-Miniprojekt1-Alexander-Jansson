package org.example;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final PrimeNumValidator validator = new PrimeNumValidator();

    public static void main(String[] args) {


        validator.printSumPrimes(10);
        validator.printCountPrimes(10);


        validator.printSumPrimes(1000);
        validator.printCountPrimes(1000);

        validator.isPrime(5);
        validator.isPrime(225);
    }
}