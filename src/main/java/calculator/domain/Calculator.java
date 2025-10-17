package calculator.domain;

import static calculator.constant.Delimiter.CUSTOM_PREFIX;
import static calculator.constant.Delimiter.DEFAULT_DELIMITER;

public class Calculator {
    private final DelimiiterParser delimiterParser = new DelimiiterParser();
    private final NumberValidator numberValidator = new NumberValidator();

    public int calculate(String input) {
        if (input.isEmpty()) return 0;

        String customDelimiters = "";
        String numbersPart = input;

        if (input.startsWith(CUSTOM_PREFIX)) {
            String customDelimiter = delimiterParser.extractCustomDelimiter(input);
            numbersPart = delimiterParser.extractNumbersPart(input);
            customDelimiters += customDelimiter;
        }

        String[] tokens = numbersPart.split("[" + DEFAULT_DELIMITER + customDelimiters + "]");

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