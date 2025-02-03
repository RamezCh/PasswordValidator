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

    public static String generateRandomSecurePassword() {
        String specialCharacters = "!@#$%^&*()_][;.,=-";
        String letters = "qwertyuiopasdfghjklzxcvbnm";
        String numbers = "1234567890";

        int passwordLength = (int)(Math.random() * 92 + 8);

        char[] password = new char[passwordLength];

        int specialCharIndex = (int) (Math.random() * passwordLength);
        int numberIndex = (int) (Math.random() * passwordLength);
        int uppercaseIndex = (int) (Math.random() * passwordLength);
        int lowercaseIndex = (int) (Math.random() * passwordLength);

        while (specialCharIndex == numberIndex || specialCharIndex == uppercaseIndex || specialCharIndex == lowercaseIndex ||
                numberIndex == uppercaseIndex || numberIndex == lowercaseIndex || uppercaseIndex == lowercaseIndex) {
            specialCharIndex = (int) (Math.random() * passwordLength);
            numberIndex = (int) (Math.random() * passwordLength);
            uppercaseIndex = (int) (Math.random() * passwordLength);
            lowercaseIndex = (int) (Math.random() * passwordLength);
        }

        password[specialCharIndex] = specialCharacters.charAt((int) (Math.random() * specialCharacters.length()));
        password[numberIndex] = numbers.charAt((int) (Math.random() * numbers.length()));
        password[uppercaseIndex] = letters.toUpperCase().charAt((int) (Math.random() * letters.length()));
        password[lowercaseIndex] = letters.charAt((int) (Math.random() * letters.length()));

        for (int i = 0; i < passwordLength; i++) {
            if (password[i] == 0) {
                int randomType = (int) (Math.random() * 3);
                if (randomType == 0) {
                    password[i] = numbers.charAt((int) (Math.random() * numbers.length()));
                } else if (randomType == 1) {
                    if (Math.random() >= 0.5) {
                        password[i] = letters.toUpperCase().charAt((int) (Math.random() * letters.length()));
                    } else {
                        password[i] = letters.charAt((int) (Math.random() * letters.length()));
                    }
                } else {
                    password[i] = specialCharacters.charAt((int) (Math.random() * specialCharacters.length()));
                }
            }
        }

        return new String(password);
    }
}