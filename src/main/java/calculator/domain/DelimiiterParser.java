package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiiterParser {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.+?)\\\\n");

    public String extractCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(1);

            if (delimiter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자가 비어있습니다.");
            }

            return delimiter;
        }

        //개행 문자 누락
        throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
    }

    public String extractNumbersPart(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            return input.substring(matcher.end());
        }

        throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
    }
}
