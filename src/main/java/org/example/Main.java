package org.example;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static PrimeNumValidator validator = new PrimeNumValidator();

    public static void main(String[] args) {


//        validator.printSumPrimes(10);
//        validator.printCountPrimes(10);
//
//
//        validator.printSumPrimes(1000);
//        validator.printCountPrimes(1000);
//
//        validator.isPrime(5);
//        validator.isPrime(10);


        boolean active = true;
        Scanner s = new Scanner(System.in);
        while (active){
            System.out.println("(1) Is Prime -- (2) Count primes -- (3) Sum primes in range");
            int choice = s.nextInt();
            switch (choice){
                case 1:
                    System.out.println("type: ");
                    int n1 = s.nextInt();
                    validator.isPrime(n1);
                    break;
                case 2:
                    System.out.println("type: ");
                    int n2 = s.nextInt();
                    validator.printCountPrimes(n2);
                    break;
                case 3:
                    System.out.println("type: ");
                    int n3 = s.nextInt();
                    validator.printSumPrimes(n3);
                    break;
                case 4:
                    active = false;
                    break;
            }

        }
    }
}