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
    void hasUppercaseAndLowercase_whenOnlyUppercase_returnFalse() {
        String password = "ABC";
        boolean actual = Main.hasUppercaseAndLowercase(password);
        assertFalse(actual);
    }

    @Test
    void hasUppercaseAndLowercase_whenOnlyLowercase_returnFalse() {
        String password = "abc";
        boolean actual = Main.hasUppercaseAndLowercase(password);
        assertFalse(actual);
    }

    @Test
    void hasUppercaseAndLowercase_whenUpperAndLowerCases_returnTrue() {
        String password = "aBcDeFg";
        boolean actual = Main.hasUppercaseAndLowercase(password);
        assertTrue(actual);
    }

    @Test
    void isPasswordCommon_whenGivenPassword1_returnTrue() {
        String password = "Password1";
        boolean actual = Main.isPasswordCommon(password);
        assertTrue(actual);
    }

    @Test
    void isPasswordCommon_whenGivenAa345678_returnTrue() {
        String password = "Aa345678";
        boolean actual = Main.isPasswordCommon(password);
        assertTrue(actual);
    }

    @Test
    void isPasswordCommon_whenGivenMixPasswordWithOneSpecialCharacter_returnFalse() {
        String password = "!Aa345678";
        boolean actual = Main.isPasswordCommon(password);
        assertFalse(actual);
    }

    @Test
    void generateRandomSecurePassword_shouldReturnSecurePassword_whenCheckedForCommonPassword() {
        String password = Main.generateRandomSecurePassword(8);
        boolean isSecure = Main.isPasswordCommon(password);
        assertFalse(isSecure);
    }

    @Test
    void generateRandomSecurePassword_shouldReturnSecurePassword_whenMaxLengthIsNegative() {
        String password = Main.generateRandomSecurePassword(-8);
        boolean isSecure = Main.isPasswordCommon(password);
        assertFalse(isSecure);
    }

    @Test
    void generateRandomSecurePassword_shouldReturnSecurePassword_whenMaxLengthIsZero() {
        String password = Main.generateRandomSecurePassword(0);
        boolean isSecure = Main.isPasswordCommon(password);
        assertFalse(isSecure);
    }
}