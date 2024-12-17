package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumValidatorTest {

    PrimeNumValidator validator = new PrimeNumValidator();

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

    @DisplayName("")
    @Test
    void findPrimeNumbersTestRange(){}

}