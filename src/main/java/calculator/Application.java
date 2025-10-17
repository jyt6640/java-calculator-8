package calculator;

import calculator.controller.CalculatorController;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            CalculatorController controller = new CalculatorController();
            controller.run();
        } finally {
            Console.close();
        }
    }
}