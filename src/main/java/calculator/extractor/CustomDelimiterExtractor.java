package calculator.extractor;

import static calculator.constant.Patterns.CUSTOM_DELIMITER;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterExtractor {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public String extractCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        return matcher.group(1);
    }
}
