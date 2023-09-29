package org.ivermektin.caledonia.services.internalServices;

import java.util.regex.Pattern;

/**
 * This class is the HygieneService.
 * This class provides methods for sanitizing and formatting input strings for JSON requests.
 * It includes a method for sanitizing strings by removing special characters and another method for
 * concatenating multiple lines of a string into a single line.
 * These methods are designed to ensure that the input is properly formatted and meets the requirements
 * for making JSON requests.
 */

public class HygieneService {
    public static String sanitizeString(String string) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9\\s]");

        // Replace special characters with an empty string
        return pattern.matcher(string).replaceAll("");
    }
    public static String concatenateLines(String string) {
        return string.replaceAll("\\n", "").replaceAll("\\r", "");
    }
}
