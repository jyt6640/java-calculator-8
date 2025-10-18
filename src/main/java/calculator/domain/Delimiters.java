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
        this.delimiters = buildDelimiters(customDelimiter);
    }

    private Set<String> buildDelimiters(String customDelimiter) {
        Set<String> delimiters = new HashSet<>(Delimiter.DEFAULT_DELIMITER_SET);

        if (customDelimiter != null && !customDelimiter.isEmpty()) {
            delimiters.add(customDelimiter);
        }

        return Collections.unmodifiableSet(delimiters);
    }

    public Set<String> getDelimiters() {
        return delimiters;
    }

    public String[] split(String input) {
        String pattern = buildPattern();
        return input.split(pattern);
    }

    public String buildPattern() {
        String quoted = delimiters.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining(""));

        return "[" + quoted + "]";
    }
}
