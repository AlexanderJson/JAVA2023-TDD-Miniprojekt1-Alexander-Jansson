package org.example;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

public class PrimeNumValidator {

    private BitSet primeNumbers;
    private List<Integer> primes;



    /**
     * This method uses Sieve of Eratosthenes to
     * create a bitset of prime numbers, by removing composite numbers.
     * It will generate a list of prime numbers from 2 -> n and then reuse the values
     */
    public List<Integer> calculatePrime(int n) {
        //Guard clause that checks first so that the input is within range. Else it throws error and interrupts the method completely.
        invalidInput(n);
        //  1 bit is better than boolean 8 bits for the same purpose
        primeNumbers = new BitSet(n + 1);
        // All values are initially set to true
        primeNumbers.set(2, n + 1);
        /* in outer loop I square [i] first, because all numbers
        squared are composite numbers(except 1 obviously), this removes all squared composite until N
         then for each iteration in outer loop, we also take the
         j = (i*i). This squared numbed of each number, then we just add
         i until end of range. This removes all composite numbers.
         Basically if i = 2 then - > 2*2 = 4, 4+2,6+2,8+2 -> 100.
         But we also set all composite as false and with if statements check
         every iteration. So it will very quickly be able to iterate no matter range!
         */
        for (int i = 2; i * i <= n; i++) {
            if (primeNumbers.get(i))
                for (int j = i * i; j <= n; j += i) {
                    primeNumbers.clear(j);
                }
        }

        /* I only convert this to a int list because I needed to return the calculations as integers according to exam specifications.
            Otherwise I would just return the BitSet as both .cardinality and .stream.sum returns integers.
            But the core functionality still works, at all the prime numbers are only calculated once during runtime.
         */
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++){
            if (primeNumbers.get(i)){
                primes.add(i);
            }
        } return primes;
    }

    public Boolean isPrime(int n) {
        invalidInput(n);
        initPrimeList(1000);
        boolean response =  primeNumbers.get(n);
        if (response){
            System.out.println("The number " + n + " is a prime number!");
            return true;
        }else {
            System.out.println("The number " + n + " is not a prime number!");
        }
        return false;
    }

    public int countPrimes(int n) {
        invalidInput(n);
        initPrimeList(n);
        return primeNumbers.cardinality();
    }

    public int sumPrimes(int n){
        invalidInput(n);
        initPrimeList(n);
        return primeNumbers.stream().sum();
    }

    public void printSumPrimes(int n){
        int sum = sumPrimes(n);
        System.out.println("The sum of all prime numbers to " + n + " is: " + sum);
    }

    public void printCountPrimes(int n){
        int sum = countPrimes(n);
        System.out.println("The count of all prime numbers to " + n + " is: " + sum);
    }

    // helper classes

    // lazy init of prime list
    private void initPrimeList(int n){
        if (primes == null || primeNumbers == null){
            primes = calculatePrime(n);
        }
    }

    private void invalidInput(int n){
        if (n < 1 || n > 1000) {
            throw new IllegalArgumentException("Input must be between 1-1000." +
                    " Your input was: " + n);
        }
    }
}




// OLD code, incase of failure. TODO: remove

//    public int findPrimeNumbers(int start, int end) {
//
//        //Guard clause that checks first so that the input is within range. Else it throws error and interrupts the method completely.
//        if (start < 1 || end > 1000) {
//            throw new IllegalArgumentException("Input must be between 1-1000." +
//                    " Your input was: " + start + " to " + end);
//        }
//            int primeNumbers = 0;
//            for (int i = start; i <= end; i++) {
//                if (calculatePrime(i)) {
//                    primeNumbers++;
//                }
//            }
//            System.out.println("There is a total of: " + primeNumbers + " between "
//                    + start + " and " + end);
//            return primeNumbers;
//        }
//    }




//    public boolean checkPrime(int num){
//        // number needs to be 2 or more than 2 to be a prime number
//
//        if (num < 2) {
//        return false;
//        }
//            // gets the square root of number,
//            int sqrtNum = (int) Math.sqrt(num);
//
//            // iterates up to the sqrtNum
//            for (int i = 2; i <= sqrtNum; i++) {
//                // uses modulus to check if there
//                if (num % i == 0){
//                    return false;
//                }
//            }
//        return true;
//    }



