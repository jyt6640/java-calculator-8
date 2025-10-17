package calculator.service;

import calculator.validator.NumberValidator;

public class Calculator {

    private final NumberValidator numberValidator = new NumberValidator();

    public int calculate(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }
            int number = numberValidator.parseAndValidateNumber(token);

            sum += number;
        }

        return sum;
    }
}