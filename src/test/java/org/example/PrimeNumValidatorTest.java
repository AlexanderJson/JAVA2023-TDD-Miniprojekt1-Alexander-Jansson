package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumValidatorTest {

    private PrimeNumValidator validator;

    @BeforeEach
    void init(){
        validator = new PrimeNumValidator();
    }

    @DisplayName("This method checks if the method " +
            "correctly calculates a prime number")
    @Test
    void checkPrimeTestPrimeNumber(){
        int input = 29;
        boolean result = validator.checkPrime(input);
        assertTrue(result, "Input is a prime number");
    }

    @DisplayName("This method checks if the method correctly identfies a non-prime number (composite)")
    @Test
    void checkPrimeTestCompositeNumber(){
        int input = 4;
        boolean result = validator.checkPrime(input);
        assertFalse(result, "Input is a composite number");
    }


    @DisplayName("This method checks if the method can correctly find prime numbers between 1-10" )
    @Test
    void findPrimeNumbersTestRangeOneToTen(){
        int start = 1;
        int end = 10;
        int expected = 4;
        int actual = validator.findPrimeNumbers(start,end);
        assertEquals(expected,actual,"It should be 4 numbers between 1-10");
    }

    @DisplayName("This method checks if the method can correctly find prime numbers between 1-10" )
    @Test
    void findPrimeNumbersTestFullRange(){
        int start = 1;
        int end = 1000;
        int expected = 168;
        int actual = validator.findPrimeNumbers(start,end);
        assertEquals(expected,actual,"It should be 168 numbers between 1-1000");
    }

//    @DisplayName("This method checks if the method can correctly throw exception if numbers are out of range (1-1000)" )
//    @Test
//    void findPrimeNumbersTestOutOfRange(){
//        int start = 1;
//        int end = 1001;
//        assertThrows(IllegalArgumentException.class, () -> {
//            validator.findPrimeNumbers(start,end);
//        }, "Input is out of range! Only numbers between 1-1000!!!");
//    }

}