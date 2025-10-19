package calculator.domain;

import calculator.constant.ErrorMessage;
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
        long sum = 0;
        for (Number number : values) {
            sum += number.addTo(0);

            validateSumRange(sum);
        }
        return (int) sum;
    }

    private void validateSumRange(long sum) {
        if (sum > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }
}
