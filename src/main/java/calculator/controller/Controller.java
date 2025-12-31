package calculator.controller;

import calculator.view.handler.InputHandler;

public class Controller {
    private final InputHandler inputHandler;

    public Controller(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void run() {
        String input = inputHandler.getNumber();
        if (inputHandler.hasCustomDelimiter(input)) {
            String numberSection = inputHandler.getCustomNumberSection(input);
            String customDelimiter = inputHandler.customDelimiterParser(input);
        }


    }
}
