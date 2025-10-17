package calculator.extractor;

import static calculator.constant.Patterns.CUSTOM_DELIMITER;

import calculator.constant.ErrorMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberPartExtractor {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public String extractNumbersPart(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            return input.substring(matcher.end());
        }

        throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
    }

    public String emptyNumberInput(String input) {
        if (input.isEmpty()) {
            return "0";
        }
        return input;
    }
}
