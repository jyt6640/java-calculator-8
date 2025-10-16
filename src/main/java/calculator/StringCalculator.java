package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.+?)\\n");

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

        if (input.startsWith("//")) {
            String customDelimiter = extractCustomDelimiter(input);
            String numbersPart = extractNumbersPart(input);

            String[] tokens = numbersPart.split("["+ delimiters + customDelimiter + "]");
            int sum = 0;
            for (String token : tokens) {
                sum += Integer.parseInt(token);
            }

            return sum;
        }

        String[] tokens = input.split("[" + delimiters + "]");
        List<Integer> numbers = new ArrayList<>();


        for (String token : tokens) {
            numbers.add(Integer.parseInt(token));
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }
}