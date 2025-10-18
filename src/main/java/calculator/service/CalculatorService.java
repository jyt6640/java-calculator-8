package calculator.service;

import static calculator.constant.Delimiter.CUSTOM_PREFIX;
import static calculator.constant.Delimiter.DEFAULT_DELIMITER;

import calculator.domain.Numbers;
import calculator.extractor.CustomDelimiterExtractor;
import calculator.extractor.NumberPartExtractor;
import calculator.validator.CustomDelimiterValidator;
import calculator.validator.NumberPartValidator;

public class CalculatorService {
    private final CustomDelimiterExtractor customDelimiterExtractor;
    private final NumberPartExtractor numberPartExtractor;
    private final CustomDelimiterValidator customDelimiterValidator;
    private final NumberPartValidator numberPartValidator;

    public CalculatorService() {
        this.customDelimiterExtractor = new CustomDelimiterExtractor();
        this.numberPartExtractor = new NumberPartExtractor();
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

        String customDelimiter = customDelimiterExtractor.extractCustomDelimiter(input);
        String numberPart = numberPartExtractor.extractNumbersPart(input);

        numberPartValidator.validateWithCustomDelimiter(input);

        String delimiters = DEFAULT_DELIMITER + customDelimiter;
        String[] tokens = numberPart.split("[" + delimiters + "]");

        Numbers numbers = Numbers.from(tokens);
        return numbers.sum();
    }

    private int processWithBasicDelimiter(String input) {
        numberPartValidator.validateWithoutCustomDelimiter(input);

        String[] tokens =  input.split("[" + DEFAULT_DELIMITER + "]");

        Numbers numbers = Numbers.from(tokens);
        return numbers.sum();
    }

}


