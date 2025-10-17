package calculator.domain;

import static calculator.constant.Patterns.CUSTOM_DELIMITER;

import calculator.constant.ErrorMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public String extractCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(1);

            if (delimiter.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.EMPTY_CUSTOM_DELIMITER.getMessage());
            }

            return delimiter;
        }

        //개행 문자 누락
        throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
    }

    public String extractNumbersPart(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            return input.substring(matcher.end());
        }

        throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
    }
}
