package calculator.controller;

import static calculator.constant.Delimiter.CUSTOM_PREFIX;
import static calculator.constant.Delimiter.DEFAULT_DELIMITER;

import calculator.extractor.CustomDelimiterExtractor;
import calculator.extractor.NumberPartExtractor;
import calculator.view.InputView;
import calculator.view.OutputView;
import calculator.service.Calculator;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;
    private final CustomDelimiterExtractor customDelimiterExtractor;
    private final NumberPartExtractor numberPartExtractor;

    public CalculatorController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.calculator = new Calculator();
        this.customDelimiterExtractor = new CustomDelimiterExtractor();
        this.numberPartExtractor = new NumberPartExtractor();
    }

    public void run() {
        try {
            String input = inputView.readInput();

            int result = processInput(input);

            outputView.printResult(result);

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            throw e;
        }
    }

    private int processInput(String input) {
        if (input.isEmpty()) return 0;

        if (hasCustomDelimiter(input)) {
            String delimiters = customDelimiterExtractor.extractCustomDelimiter(input) + DEFAULT_DELIMITER;
            String numbersStringPart = numberPartExtractor.extractNumbersPart(input);
            String[] tokens = numbersStringPart.split("[" + delimiters + "]");

            return calculator.calculate(tokens);
        }

        String[] tokens = input.split("[" + DEFAULT_DELIMITER + "]");

        return calculator.calculate(tokens);
    }

    private boolean hasCustomDelimiter(String token) {
        return token.startsWith(CUSTOM_PREFIX);
    }
}