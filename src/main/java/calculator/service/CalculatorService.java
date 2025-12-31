package calculator.service;

import java.util.List;

public class CalculatorService {

    public int calculate(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(number -> number)
                .sum();
    }
}
