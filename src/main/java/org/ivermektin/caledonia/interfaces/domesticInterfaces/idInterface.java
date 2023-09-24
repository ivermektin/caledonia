package org.ivermektin.caledonia.interfaces.domesticInterfaces;

import java.security.SecureRandom;
import java.util.Random;

/**
 * This class is the idInterface.
 * This is used by the program to generate random codes for each class.
 * Because user input can sometimes have unusual characters, classes
 * are identified by the system by their ID, which is assigned here.
 */

public class idInterface {

    /**
     * The characters from which the random string will be generated.
     */
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789";

    /**
     * The length of the random string.
     */
    private static final int LENGTH = 5;

    /**
     * Generates a random string.
     *
     * @return the generated random string
     */
    public static String generateRandomString() {
        StringBuilder sb = new StringBuilder(LENGTH);
        Random random = new SecureRandom();

        for (int i = 0; i < LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    /**
     * Generates a random string of specified length.
     *
     * @param length the length of the random string to generate
     * @return the generated random string
     */
    public static String generateRandomString(Integer length) {
        StringBuilder sb = new StringBuilder(length);
        Random random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}