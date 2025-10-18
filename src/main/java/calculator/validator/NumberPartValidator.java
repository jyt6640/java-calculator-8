package calculator.validator;

import static calculator.constant.Patterns.CUSTOM_DELIMITER;
import static calculator.constant.Patterns.INVALID_CHAR_PATTERN;
import static calculator.constant.Patterns.ONLY_NUMBER;

import calculator.constant.ErrorMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberPartValidator {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public void containsNonDigit(String[] tokens) {
        for (String token : tokens) {
            if (!token.matches(ONLY_NUMBER)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.getMessage());
            }
        }
    }

    public void validateWithoutCustomDelimiter(String input) {
        if(input.matches(INVALID_CHAR_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER_USAGE.getMessage());
        }
    }

    public void validateWithCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (!matcher.find()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
        }

        String customDelimiter = matcher.group(1);
        String numbersPart = input.substring(matcher.end());
        String allowedPattern = "^[0-9,:" + Pattern.quote(customDelimiter) + "\\n]+$";

        if (!numbersPart.matches(allowedPattern)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER_USAGE.getMessage());
        }
    }

}
