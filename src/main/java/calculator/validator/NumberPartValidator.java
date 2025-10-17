package calculator.validator;

import static calculator.constant.Patterns.ONLY_NUMBER;

import calculator.constant.ErrorMessage;

public class NumberPartValidator {
    //음수 유/무
    public boolean hasNegativeNumberValidate(String[] tokens) {
        for (String token : tokens) {
            int number = Integer.parseInt(token);

            if (number < 0) {
                throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER.getMessage());
            }
        }
        return false;
    }

    //문자열 유/무
    public boolean containsNonDigit(String[] tokens) {
        for (String token : tokens) {
            if (!token.matches(ONLY_NUMBER)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.getMessage());
            }
        }
        return false;
    }
}
