package calculator.service;

import calculator.domain.Delimiters;
import calculator.domain.Numbers;
import calculator.parser.InputParser;
import calculator.validator.CustomDelimiterValidator;
import calculator.validator.NumberPartValidator;

public class CalculatorService {
    private final InputParser inputParser;
    private final CustomDelimiterValidator customDelimiterValidator;
    private final NumberPartValidator numberPartValidator;

    public CalculatorService() {
        this.inputParser = new InputParser();
        this.customDelimiterValidator = new CustomDelimiterValidator();
        this.numberPartValidator = new NumberPartValidator();
    }

    public int process(String input) {
        input = input.trim();
        if (input.isEmpty()) return 0;

        if(customDelimiterValidator.startCustomDelimiterPrefix(input)){
            return processWithCustomDelimiter(input);
        }

        return processWithBasicDelimiter(input);

    }

    private int processWithCustomDelimiter(String input) {
        customDelimiterValidator.validateCustomDelimiterFormat(input);
        customDelimiterValidator.emptyCustomDelimiterValidate(input);

        String customDelimiter = inputParser.extractCustomDelimiter(input);
        String numberPart = inputParser.extractNumbersPart(input);

        numberPartValidator.validateWithCustomDelimiter(input);

        Delimiters delimiters = new Delimiters(customDelimiter);
        String[] tokens = delimiters.split(numberPart);

        Numbers numbers = Numbers.from(tokens);
        return numbers.sum();
    }

    private int processWithBasicDelimiter(String input) {
        numberPartValidator.validateWithoutCustomDelimiter(input);

        Delimiters delimiters = new Delimiters(null);
        String[] tokens = delimiters.split(input);

        Numbers numbers = Numbers.from(tokens);
        return numbers.sum();
    }

}


