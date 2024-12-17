package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumValidator {

    public boolean checkPrime(int num){
        // number needs to be 2 or more than 2 to be a prime number

        if (num < 2) {
        return false;
        }
            // gets the square root of number,
            int sqrtNum = (int) Math.sqrt(num);

            // iterates up to the sqrtNum
            for (int i = 2; i <= sqrtNum; i++) {
                // uses modulus to check if there
                if (num % i == 0){
                    return false;
                }
            }
        return true;
    }

    public int findPrimeNumbers(int start, int end) {

        //Guard clause that checks first so that the input is within range. Else it throws error and interrupts the method completely.
        if (start < 1 || end > 1000) {
            throw new IllegalArgumentException("Input must be between 1-1000." +
                    " Your input was: " + start + " to " + end);
        }
            int primeNumbers = 0;
            for (int i = start; i <= end; i++) {
                if (checkPrime(i)) {
                    primeNumbers++;
                }
            }
            System.out.println("There is a total of: " + primeNumbers + " between "
                    + start + " and " + end);
            return primeNumbers;
        }
    }

