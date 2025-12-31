package calculator;

import calculator.controller.Controller;
import calculator.view.InputView;
import calculator.view.handler.InputHandler;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new InputHandler(new InputView()));
        controller.run();
    }
}
