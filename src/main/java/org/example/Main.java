package org.example;

import java.util.Random;

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

    public static boolean hasSpecialCharacters(String password) {
        // * means zero or more occurrences
        // + means one or more occurrences
        return password != null && !password.matches("[a-zA-Z0-9]+");
    }


    public static boolean isPasswordCommon(String password) {
        if(!isValidLength(password)) {
            return true;
        }

        if(!hasDigit(password)) {
            return true;
        }

        if(!hasUppercaseAndLowercase(password)) {
            return true;
        }

        if(!hasSpecialCharacters(password)) {
            return true;
        }

        return false;
    }

    public static String generateRandomSecurePassword(int maxPasswordLength) {
        String specialCharacters = "!@#$%^&*()_][;.,=-";
        String letters = "qwertyuiopasdfghjklzxcvbnm";
        String numbers = "1234567890";

        Random random = new Random();

        if (maxPasswordLength < 0) {
            maxPasswordLength = -maxPasswordLength;
        }

        // We start at 0 till maxPasswordLength (exclusive)
        // We add 1 to maxPasswordLength so it becomes inclusive
        // We subtract - 8 from .nextInt and add it afterward
        // This makes minimum 8 and maintains maximum maxPasswordLength
        int passwordLength = maxPasswordLength > 8 ? random.nextInt(maxPasswordLength + 1 - 8) + 8 : 8;
        // int passwordLength = (int)(Math.random() * maxPasswordLength + 8);

        char[] password = new char[passwordLength];

        int specialCharIndex = random.nextInt(passwordLength);
        int numberIndex = random.nextInt(passwordLength);
        int uppercaseIndex = random.nextInt(passwordLength);
        int lowercaseIndex = random.nextInt(passwordLength);

        while (specialCharIndex == numberIndex || specialCharIndex == uppercaseIndex || specialCharIndex == lowercaseIndex ||
                numberIndex == uppercaseIndex || numberIndex == lowercaseIndex || uppercaseIndex == lowercaseIndex) {
            specialCharIndex = random.nextInt(passwordLength);
            numberIndex = random.nextInt(passwordLength);
            uppercaseIndex = random.nextInt(passwordLength);
            lowercaseIndex = random.nextInt(passwordLength);
        }

        password[specialCharIndex] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[numberIndex] = numbers.charAt((random.nextInt(numbers.length())));
        password[uppercaseIndex] = letters.toUpperCase().charAt((random.nextInt(letters.length())));
        password[lowercaseIndex] = letters.charAt((random.nextInt(letters.length())));

        for (int i = 0; i < passwordLength; i++) {
            if (password[i] == 0) {
                int randomType = random.nextInt(3);
                if (randomType == 0) {
                    password[i] = numbers.charAt((random.nextInt(numbers.length())));
                } else if (randomType == 1) {
                    if (Math.random() >= 0.5) {
                        password[i] = letters.toUpperCase().charAt((random.nextInt(letters.length())));
                    } else {
                        password[i] = letters.charAt((random.nextInt(letters.length())));
                    }
                } else {
                    password[i] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
                }
            }
        }

        return new String(password);
    }
}