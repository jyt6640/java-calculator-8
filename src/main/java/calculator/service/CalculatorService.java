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

    public int process(String input) {
        input = input.trim();
        if (input.isEmpty()) return 0;

        if(inputValidator.startCustomDelimiterPrefix(input)){
            return processWithCustomDelimiter(input);
        }

        return processWithBasicDelimiter(input);

    }

    private int processWithCustomDelimiter(String input) {
        inputValidator.validateCustomDelimiterFormat(input);

        String customDelimiter = inputParser.extractCustomDelimiter(input);
        String numberPart = inputParser.extractNumbersPart(input);

        inputValidator.validateWithCustomDelimiter(input);

        Delimiters delimiters = new Delimiters(customDelimiter);
        String[] tokens = delimiters.split(numberPart);

        Numbers numbers = Numbers.from(tokens);
        return numbers.sum();
    }

    private int processWithBasicDelimiter(String input) {
        inputValidator.validateWithoutCustomDelimiter(input);

        Delimiters delimiters = new Delimiters(null);
        String[] tokens = delimiters.split(input);

        Numbers numbers = Numbers.from(tokens);
        return numbers.sum();
    }

}


