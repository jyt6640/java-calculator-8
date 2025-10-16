package calculator;

public class NumberValidator {
    public int parseAndValidateNumber(String token) {
        try {
            int number = Integer.parseInt(token);

            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }
}
