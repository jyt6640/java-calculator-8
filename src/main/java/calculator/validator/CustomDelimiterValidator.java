package calculator.validator;

import static calculator.constant.Delimiter.CUSTOM_PREFIX;
import static calculator.constant.Patterns.CUSTOM_DELIMITER;

import calculator.constant.ErrorMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterValidator {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_PREFIX);
    }

    public void validateCustomDelimiterFormat(String input) {
        if (!hasCustomDelimiter(input)) {
            return;
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if(!matcher.find()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
        }
    }
}
