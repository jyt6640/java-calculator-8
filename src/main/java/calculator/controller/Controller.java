package calculator.controller;

import calculator.service.CalculatorService;
import calculator.util.Parser;
import calculator.view.handler.InputHandler;
import java.util.List;

public class Controller {
    private final InputHandler inputHandler;

    public Controller(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void run() {
        String input = inputHandler.getNumber();
        Parser parser = new Parser();
        CalculatorService calculatorService = new CalculatorService();
        if (inputHandler.hasCustomDelimiter(input)) {
            String numberSection = inputHandler.getCustomNumberSection(input);
            String customDelimiter = inputHandler.customDelimiterParser(input);
            List<Integer> numbers = parser.customNumberParser(numberSection, customDelimiter);
            int result = calculatorService.calculate(numbers);
        }
        List<Integer> numbers = parser.numberParser(input);
        int result = calculatorService.calculate(numbers);
    }
}
