package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumValidator {

    public boolean checkPrime(int num){
        // number needs to be 2 or more than 2 to be a prime number
        if (num >= 2){
            // gets the square root of number
            int sqrtNum = (int) Math.sqrt(num);

            // iterates up to the sqrtNum
            for (int i = 2; i <= sqrtNum; i++) {
                // uses modulus to check if there
                if (num % i == 0){
                    return false;
                }
            }
        }
        return true;
    }



}
