package calculator.domain;

import calculator.constant.Delimiter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Delimiters {
    private final Set<String> delimiters;

    public Delimiters(String customDelimiter) {
        this.delimiters = createDelimiterSet(customDelimiter);
    }

    private Set<String> createDelimiterSet(String customDelimiter) {
        Set<String> delimiters = new HashSet<>(Delimiter.DEFAULT_DELIMITER_SET);

        if (customDelimiter != null && !customDelimiter.isEmpty()) {
            customDelimiter = customDelimiter.trim();
            delimiters.add(customDelimiter);
        }

        return Collections.unmodifiableSet(delimiters);
    }

    public String[] split(String input) {
        String pattern = createRegexPattern();
        return input.split(pattern);
    }

    private String createRegexPattern() {
        String quoted = delimiters
                .stream()
                .map(Pattern::quote)
                .collect(Collectors.joining(""));

        return "[" + quoted + "]";
    }
}
