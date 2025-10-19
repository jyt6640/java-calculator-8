package calculator.service;

import calculator.domain.Delimiters;
import calculator.domain.Numbers;
import calculator.parser.InputParser;
import calculator.validator.InputValidator;

public class CalculatorService {
    private final InputParser inputParser;
    private final InputValidator inputValidator;

    public CalculatorService() {
        this.inputParser = new InputParser();
        this.inputValidator = new InputValidator();
    }

    public int calculate(String input) {
        input = input.trim();
        if (input.isEmpty()) return 0;

        if(inputValidator.hasCustomDelimiterPrefix(input)){
            return calculateWithCustomDelimiter(input);
        }

        return calculateWithBasicDelimiter(input);

    }

    private int calculateWithBasicDelimiter(String input) {
        inputValidator.validateBasicDelimiterInput(input);

        Delimiters delimiters = new Delimiters(null);
        String[] tokens = delimiters.split(input);

        Numbers numbers = Numbers.from(tokens);
        return numbers.sum();
    }

    private int calculateWithCustomDelimiter(String input) {
        inputValidator.validateCustomDelimiterFormat(input);

        String customDelimiter = inputParser.extractCustomDelimiter(input);

        inputValidator.validateNotMinusSign(customDelimiter);

        String numberPart = inputParser.extractNumberSection(input);

        inputValidator.validateCustomDelimiterInput(input);

        Delimiters delimiters = new Delimiters(customDelimiter);
        String[] tokens = delimiters.split(numberPart);

        Numbers numbers = Numbers.from(tokens);
        return numbers.sum();
    }
}


