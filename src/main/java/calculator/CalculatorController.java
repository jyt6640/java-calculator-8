package calculator;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final StringCalculator calculator;

    public CalculatorController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.calculator = new StringCalculator();
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