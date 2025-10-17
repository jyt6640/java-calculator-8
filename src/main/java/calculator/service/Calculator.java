package calculator.service;

import calculator.validator.NumberPartValidator;

public class Calculator {

    private final NumberPartValidator numberPartValidator = new NumberPartValidator();

    public int calculate(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }
            int number = numberPartValidator.parseAndValidateNumber(token);

            sum += number;
        }

        return sum;
    }
}