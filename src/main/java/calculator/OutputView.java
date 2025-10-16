package calculator;

public class OutputView {
    public static void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    public static void printError(String message) {
        System.out.println("[ERROR] : " + message);
    }
}
