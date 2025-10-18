package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private final List<Number> values;

    private Numbers(List<Number> values) {
        this.values = values;
    }

    public static Numbers from(String[] tokens) {
        List<Number> numbers = Arrays.stream(tokens)
                .map(Number::new)
                .collect(Collectors.toList());
        return new Numbers(numbers);
    }

    public int sum() {
        return values.stream()
                .mapToInt(Number::getValue)
                .sum();
    }
}
