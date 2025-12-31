package calculator.controller;

import calculator.service.CalculatorService;
import calculator.util.Parser;
import calculator.view.OutputView;
import calculator.view.handler.InputHandler;
import java.util.List;

public class Controller {
    private final InputHandler inputHandler;
    private final OutputView outputView;

    public Controller(InputHandler inputHandler, OutputView outputView) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
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
            outputView.printResult(result);
            return;
        }
        List<Integer> numbers = parser.numberParser(input);
        int result = calculatorService.calculate(numbers);
        outputView.printResult(result);
    }
}
