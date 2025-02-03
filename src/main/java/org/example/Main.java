package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public static boolean isValidLength(String password) {
        return password.length() > 7;
    }

    public static boolean hasDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    public static boolean hasUppercaseAndLowercase(String password) {
        return false;
    }

    public static boolean isPasswordCommon(String password) {
        return false;
    }
}