package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;
import calculator.domain.Calculator;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;

    public CalculatorController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.calculator = new Calculator();
    }

    public void run() {
        try {
            String input = inputView.readInput();
            int result = calculator.calculate(input);
            outputView.printResult(result);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            throw e;
        }
    }
}