package calculator.controller;

import calculator.view.InputView;

public class Controller {
    private final InputView inputView;

    public Controller(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        inputView.readNumber();
    }
}
