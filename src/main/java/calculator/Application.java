package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = InputView.readInput();
        try {
            int result = StringCalculator.calculate(input);
            OutputView.printResult(result);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            throw e;
        } catch (Exception e) {
            OutputView.printError(e.getMessage());
        } finally {
            Console.close();
        }
    }
}