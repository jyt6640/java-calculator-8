package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.+?)\\\\n");

    public static String extractCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static String extractNumbersPart(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            return input.substring(matcher.end());
        }
        return null;
    }

    public static int calculate(String input) {
        if (input.isEmpty()) return 0;

        String delimiters = ",:";
        String numbersPart = input;

        if (input.startsWith("//")) {
            String customDelimiter = extractCustomDelimiter(input);
            numbersPart = extractNumbersPart(input);
            delimiters += customDelimiter;
        }

        String[] tokens = numbersPart.split("[" + delimiters + "]");

        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}