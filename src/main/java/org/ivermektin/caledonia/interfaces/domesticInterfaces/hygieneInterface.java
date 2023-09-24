package org.ivermektin.caledonia.interfaces.domesticInterfaces;

import java.util.regex.Pattern;

/**
 * This class is the hygieneInterface.
 * This class provides methods for sanitizing and formatting input strings for JSON requests.
 * It includes a method for sanitizing strings by removing special characters and another method for
 * concatenating multiple lines of a string into a single line.
 * These methods are designed to ensure that the input is properly formatted and meets the requirements
 * for making JSON requests.
 */

public class hygieneInterface {

    /**
     * Sanitizes a string by removing special characters.
     * @param string the input string
     * @return the sanitized string
     */
    public static String stringSanitizer(String string) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9\\s]");

        // Replace special characters with an empty string
        return pattern.matcher(string).replaceAll("");
    }

    /**
     * Concatenates multiple lines of a string into a single line.
     * @param string the input string
     * @return the string with concatenated lines
     */
    public static String concatenateLines(String string) {
        return string.replaceAll("\\n", "").replaceAll("\\r", "");
    }
}