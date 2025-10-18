package calculator.validator;

import static calculator.constant.Delimiter.CUSTOM_PREFIX;
import static calculator.constant.Patterns.CUSTOM_DELIMITER;
import static calculator.constant.Patterns.INVALID_CHAR_PATTERN;

import calculator.constant.ErrorMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public boolean startCustomDelimiterPrefix(String input) {
        return input.startsWith(CUSTOM_PREFIX);
    }

    public void validateCustomDelimiterFormat(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if(!matcher.find()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
        }
        String delimiter = matcher.group(1);
        if (delimiter == null || delimiter.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CUSTOM_DELIMITER.getMessage());
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

