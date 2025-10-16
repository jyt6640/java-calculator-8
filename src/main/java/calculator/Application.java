package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요");
        String input = Console.readLine();
        try {
            int result = StringCalculator.calculate(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.out.println("[ERROR] : 알 수 없는 오류가 발생했습니다.");
        } finally {
            Console.close();
        }
    }
}