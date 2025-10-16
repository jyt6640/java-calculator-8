package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        StringCalculator calculator = new StringCalculator();

        String input = inputView.readInput();
        try {
            int result = calculator.calculate(input);
            outputView.printResult(result);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            throw e;
        } catch (Exception e) {
            outputView.printError(e.getMessage());
        } finally {
            Console.close();
        }
    }
}