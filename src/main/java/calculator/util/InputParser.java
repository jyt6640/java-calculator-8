package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.*?)\\\\\\\\n");

    public String customDelimiterParser(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public String numberSection(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            return input.substring(matcher.end());
        }
        return null;
    }
}
