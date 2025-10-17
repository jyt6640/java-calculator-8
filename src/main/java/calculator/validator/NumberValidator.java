package calculator.validator;

import calculator.constant.ErrorMessage;

public class NumberValidator {
    public int parseAndValidateNumber(String token) {
        try {
            int number = Integer.parseInt(token);

            if (number < 0) {
                throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER.getMessage());
            }

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.getMessage());
        }
    }
}
