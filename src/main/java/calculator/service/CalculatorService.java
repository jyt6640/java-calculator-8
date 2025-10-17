package calculator.service;

import static calculator.constant.Delimiter.CUSTOM_PREFIX;
import static calculator.constant.Delimiter.DEFAULT_DELIMITER;

import calculator.extractor.CustomDelimiterExtractor;
import calculator.extractor.NumberPartExtractor;
import calculator.validator.CustomDelimiterValidator;
import calculator.validator.NumberPartValidator;

public class CalculatorService {
    private final Calculator calculator;
    private final CustomDelimiterExtractor customDelimiterExtractor;
    private final NumberPartExtractor numberPartExtractor;
    private final CustomDelimiterValidator customDelimiterValidator;
    private final NumberPartValidator numberPartValidator;

    public CalculatorService() {
        this.calculator = new Calculator();
        this.customDelimiterExtractor = new CustomDelimiterExtractor();
        this.numberPartExtractor = new NumberPartExtractor();
        this.customDelimiterValidator = new CustomDelimiterValidator();
        this.numberPartValidator = new NumberPartValidator();
    }

    public int process(String input) {
        input = input.trim(); // 앞뒤 공백 제거
        if (input.isEmpty()) return 0; // 빈 입력 처리

        String delimiters = DEFAULT_DELIMITER;
        String[] tokens;

        if (customDelimiterValidator.startCustomDelimiterPrefix(input)) {
            customDelimiterValidator.validateCustomDelimiterFormat(input);
            customDelimiterValidator.emptyCustomDelimiterValidate(input);

            String customDelimiter = customDelimiterExtractor.extractCustomDelimiter(input);

            delimiters += customDelimiter;

            String numberPart = numberPartExtractor.extractNumbersPart(input);

            tokens = numberPart.split("[" + delimiters + "]");
            numberPartValidator.hasNegativeNumberValidate(tokens);
            numberPartValidator.containsNonDigit(tokens);
            numberPartValidator.validateWithCustomDelimiter(input);

            return calculator.calculate(tokens);
        }
        tokens = input.split("[" + delimiters + "]");

        numberPartValidator.hasNegativeNumberValidate(tokens);
        numberPartValidator.containsNonDigit(tokens);
        numberPartValidator.validateWithoutCustomDelimiter(input);

        return calculator.calculate(tokens);
    }

}


