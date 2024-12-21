package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumValidatorTest {

    private PrimeNumValidator validator;

    @BeforeEach
    void init(){
        validator = new PrimeNumValidator();
    }


    /**
     * These tests are for the calculatePrime() method.
     * They focus on testing different valid and invalid inputs
     */
    @DisplayName("This method checks if isPrime() correctly identifies a prime number as a prime number")
    @Test
    void isPrimeTestActualPrimeNumber() {
        int n = 5;
        boolean actual = validator.isPrime(n);
        assertTrue(actual);
    }

    @DisplayName("This method checks if isPrime() correctly identifies a composite number as a composite number")
    @Test
    void isPrimeTestCompositeNumber() {
        int n = 4;
        boolean actual = validator.isPrime(n);
        assertFalse(actual);
    }

    @DisplayName("This method checks if isPrime() correctly throws error ")
    @Test
    void isPrimeTestIfInvalidRange() {
        int n = 1001;
        assertThrows(IllegalArgumentException.class, () -> {
            validator.calculatePrime(n);
        }, "This should throw error if the start is less than 1 or end is more than 1000");
    }

    @DisplayName("This method tests if calculatePrime can correctly throw error when an invalid range (n) is set")
    @Test
    void calculatePrimeNegativeRange(){
        int n = -1;
        assertThrows(IllegalArgumentException.class, () -> {
            validator.calculatePrime(n);
        }, "This should throw error if the start is less than 1 or end is more than 1000");
    }


    /**
     * These tests are for the countPrimes() method.
     */

    @DisplayName("This method tests if countPrimes can handle 1 ")
    @Test
    void countPrimeTestRangeOne(){
        int n = 1;
        int expected = 0;
        assertEquals(expected, validator.countPrimes(n), "There should be 0 prime nums at range 1");
    }


    @DisplayName("This method tests if calculatePrime can correctly identify a prime num from 2-10")
    @Test
    void countPrimeTestPrimeNumberRangeToTen() {
        int n = 10;
        int expected = 4;
        int primeNums = validator.countPrimes(n);
        assertEquals(expected, primeNums,"there should be 4 prime nums between 1-10");
    }

    @DisplayName("This method tests if calculatePrime can correctly identify a prime num (full range)")
    @Test
    void countPrimeTestPrimeNumberFullRange() {
        int n = 1000;
        int expected = 168;
        int primeNums = validator.countPrimes(n);
        assertEquals(expected, primeNums,"there should be 168 prime nums between 1-1000");
    }

    @DisplayName("This method checks if countPrime() throws error when range is out of bounds")
    @Test
    void countPrimeTestIfInvalidRange() {
        int n = 1001;
        assertThrows(IllegalArgumentException.class, () -> {
            validator.countPrimes(n);
        }, "This should throw error if the start is less than 1 or end is more than 1000");
    }


    /**
     * These tests check if the sumPrimes can correcly add prime numbers in different ranges
     */
    @DisplayName("This method checks if sumPrimes correctly add all values from a range of 2-10")
    @Test
    void sumPrimesRangeToTen() {
        int n = 10;
        int actual = validator.sumPrimes(n);
        int expected = 17;
        assertEquals(expected,actual,"The total sum of the 4 prime nums in 10 is 17");
    }

    @DisplayName("This method checks if sumPrimes correctly add all values from a range of 2-100")
    @Test
    void sumPrimesRangeToHundred() {
        int n = 100;
        int actual = validator.sumPrimes(n);
        int expected = 1060;
        assertEquals(expected,actual,"The total sum of the 4 prime nums in 100 is 1060");
    }

    @DisplayName("This method checks if sumPrimes correctly add all values from a range of 2-1000")
    @Test
    void sumPrimesRangeToThousand() {
        int n = 1000;
        int actual = validator.sumPrimes(n);
        int expected = 76127;
        assertEquals(expected,actual,"The total sum of the 4 prime nums in 1000 is 76127");
    }


    /**
     * These tests are to check error handling for printCount and printSum
     */
    @DisplayName("This method checks if printCountPrime() throws error when range is out of bounds")
    @Test
    void printCountPrimeTestIfInvalidRange() {
        int n = 1001;
        assertThrows(IllegalArgumentException.class, () -> {
            validator.printCountPrimes(n);
        }, "This should throw error if the start is less than 1 or end is more than 1000");
    }

    @DisplayName("This method checks if printSumPrime() throws error when range is out of bounds")
    @Test
    void printSumPrimeTestIfInvalidRange() {
        int n = 1001;
        assertThrows(IllegalArgumentException.class, () -> {
            validator.printSumPrimes(n);
        }, "This should throw error if the start is less than 1 or end is more than 1000");
    }
}



















//    // Tests for checkPrime()
//
//    @DisplayName("This method checks if the method " +
//            "correctly calculates a prime number")
//    @Test
//    void checkPrimeTestPrimeNumber(){
//        int input = 29;
//        boolean result = validator.checkPrime(input);
//        assertTrue(result, "Input is a prime number");
//    }
//
//    @DisplayName("This method checks if the method correctly identfies a non-prime number (composite)")
//    @Test
//    void checkPrimeTestCompositeNumber(){
//        int input = 4;
//        boolean result = validator.checkPrime(input);
//        assertFalse(result, "Input is a composite number");
//    }
//
//
//    // Tests for findPrimeNumbers()
//
//    @DisplayName("This method checks if the method can correctly find prime numbers between 1-10" )
//    @Test
//    void findPrimeNumbersTestRangeOneToTen(){
//        int start = 1;
//        int end = 10;
//        int expected = 4;
//        int actual = validator.findPrimeNumbers(start,end);
//        assertEquals(expected,actual,"It should be 4 numbers between 1-10. The returned sum from method is: " + actual);
//    }
//
//    @DisplayName("This method checks if the method can correctly find prime numbers between 1-10" )
//    @Test
//    void findPrimeNumbersTestFullRange(){
//        int start = 1;
//        int end = 1000;
//        int expected = 168;
//        int actual = validator.findPrimeNumbers(start,end);
//        assertEquals(expected,actual,"It should be 168 numbers between 1-1000. The returned sum from method is: " + actual);
//    }
//
//    @DisplayName("This method checks if the method can correctly throw exception if numbers are out of range (1-1000)" )
//    @Test
//    void findPrimeNumbersTestOutOfRange(){
//        int start = -1;
//        int end = 1001;
//        assertThrows(IllegalArgumentException.class, () -> {
//            validator.findPrimeNumbers(start,end);
//        }, "This should throw error if the start is less than 1 or end is more than 1000");
//    }
//
//    @Test
//    void sumPrimeNumsTestAllPrimeNumbers(){
//
//    }
