package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public static boolean isValidLength(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        return password.length() > 7;
    }

    public static boolean hasDigit(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        return password.matches(".*[0-9].*");
    }

    public static boolean hasUppercaseAndLowercase(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;

        for (char letter : password.toCharArray()) {
            if (hasUppercase && hasLowercase) {
                return true;
            }
            if (Character.isUpperCase(letter)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(letter)) {
                hasLowercase = true;
            }
        }

        return false;
    }


    public static boolean isPasswordCommon(String password) {
        return false;
    }
}