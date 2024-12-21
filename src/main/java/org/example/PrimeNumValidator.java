package org.example;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PrimeNumValidator {

    private BitSet primeNumbers;
    private List<Integer> primes;



    /**
     * This algorithm will create a bitset of prime numbers, by removing composite numbers.
     * It will generate a list of prime numbers from 2 -> n and then reuse the values
     */
    public List<Integer> calculatePrime(int n) {
        //Guard clause that checks first so that the input is within range. Else it throws error and interrupts the method completely.
        invalidInput(n);
        //  1 bit is better than boolean 8 bits for the same purpose
        primeNumbers = new BitSet(n + 1);
        // All values are initially set to true
        primeNumbers.set(2, n + 1);


        /*
          from 2, I take the square of each iteration (to eliminate all smaller multiples)
         */
        for (int i = 2; i * i <= n; i++) {
            // since each iteration will set composite values as false, we recheck here
            if (primeNumbers.get(i))
                // then this  inner loop now takes the multiple of i and adds i to find
                // the next multiple (ex. i = 2, 2*2 = 4 + 2 = 6, 6+2=8 etc), then clears all the multiples.
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


    // lazy init of prime list
    private void initPrimeList(){
        if (primes == null || primeNumbers == null){
//            System.out.println("Init activating!");
            primes = calculatePrime(1000);
         }
//        System.out.println("Init already done");
    }

    public Boolean isPrime(int n) {
        invalidInput(n);
        initPrimeList();
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
        initPrimeList();
        return (int) primes.stream().filter(p -> p <= n).count();
    }

    public int sumPrimes(int n){
        invalidInput(n);
        initPrimeList();
        return primeNumbers.stream().filter(p -> p <= n).sum();
    }

    public void printSumPrimes(int n){
        int sum = sumPrimes(n);
        System.out.println( "Och den totala summan av dessa primtal är " + sum);
    }

    public void printCountPrimes(int n){
        int sum = countPrimes(n);
        System.out.println("Hej, det finns " + sum + " primtal mellan 0 och 1000");
    }



    private void invalidInput(int n){
        if (n < 1 || n > 1000) {
            throw new IllegalArgumentException("Hoppsan, fel intervall angivet!");
        }
    }
}







