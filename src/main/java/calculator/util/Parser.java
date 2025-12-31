package calculator.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    private static final String BASIC_DELIMITER = ",;";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";

    public List<Integer> numberParser(String numberSection) {
        List<Integer> numbers = Arrays.stream(numberSection.split(PREFIX + BASIC_DELIMITER + SUFFIX))
                .map(this::inputToInt)
                .collect(Collectors.toList());
        System.out.println("numbers: " + numbers);
        return numbers;
    }

    public List<Integer> customNumberParser(String numberSection, String customDelimiter) {
        List<Integer> numbers = Arrays.stream(numberSection.split(PREFIX + BASIC_DELIMITER + customDelimiter + SUFFIX))
                .map(this::inputToInt)
                .collect(Collectors.toList());
        return numbers;
    }

    public int inputToInt(String input) {
        return Integer.parseInt(input);
    }
}
