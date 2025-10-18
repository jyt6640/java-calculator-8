package calculator.domain;

import calculator.constant.Delimiter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Delimiters {
    private final Set<String> delimiters;

    public Delimiters(String customDelimiter) {
        this.delimiters = buildDelimiters(customDelimiter);
    }

    private Set<String> buildDelimiters(String customDelimiter) {
        Set<String> delimiters = new HashSet<>(Delimiter.DEFAULT_DELIMITER_SET);

        return Collections.unmodifiableSet(delimiters);
    }

    public Set<String> getDelimiters() {
        return delimiters;
    }
}
