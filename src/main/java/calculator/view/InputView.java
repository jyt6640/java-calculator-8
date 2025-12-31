package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readNumber() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String value = readLine();
        System.out.println();
        return value;
    }

    protected String readLine() {
        return Console.readLine();
    }

}
