package calculator.domain;

import calculator.constant.ErrorMessage;

public class Number {
    private final int value;

    public Number(String token) {
        this.value = Integer.parseInt(token);

        validateNegative(this.value);
    }

    private void validateNegative(int number) {
        if (value < 0 ) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER.getMessage());
        }
    }

    public int getValue() {
        return value;
    }
}
