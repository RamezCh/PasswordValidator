package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void isValidLength_forNumberGreaterThanEight_returnsTrue() {
        String password = "123456789";
        boolean actual = Main.isValidLength(password);
        assertTrue(actual);
    }

    @Test
    void isValidLength_forNumberEqualToEight_returnsTrue() {
        String password = "12345678";
        boolean actual = Main.isValidLength(password);
        assertTrue(actual);
    }

    @Test
    void isValidLength_forNumberLessThanEight_returnsFalse() {
        String password = "1234567";
        boolean actual = Main.isValidLength(password);
        assertFalse(actual);
    }

    @Test
    void hasDigit_whenNoDigit_returnFalse() {
        String password = "abcdefghiq";
        boolean actual = Main.hasDigit(password);
        assertFalse(actual);
    }

    @Test
    void hasDigit_whenDigitAtStart_returnTrue() {
        String password = "1abcdefghiq";
        boolean actual = Main.hasDigit(password);
        assertTrue(actual);
    }

    @Test
    void hasDigit_whenDigitAtEnd_returnTrue() {
        String password = "abcdefghiq1";
        boolean actual = Main.hasDigit(password);
        assertTrue(actual);
    }

    @Test
    void hasDigit_whenDigitAtMiddle_returnTrue() {
        String password = "abcde1fghiq";
        boolean actual = Main.hasDigit(password);
        assertTrue(actual);
    }

    @Test
    void hasDigit_whenMultipleDigits_returnTrue() {
        String password = "a1bc2de4fgh3iq";
        boolean actual = Main.hasDigit(password);
        assertTrue(actual);
    }

    @Test
    void hasUppercaseAndLowercase() {
    }

    @Test
    void isPasswordCommon() {
    }
}