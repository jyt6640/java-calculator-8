package calculator.domain;

import calculator.constant.ErrorMessage;

public class Number {
    private final int value;

    public Number(String token) {
        token = token.trim();

        token = normalizeEmptyInput(token);

        this.value = Integer.parseInt(token);

        validateNegative(this.value);
    }

    private void validateNegative(int number) {
        if (value < 0 ) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER.getMessage());
        }
    }

    private String normalizeEmptyInput(String token) {
        if (token == null || token.isEmpty()) {
            return "0";
        }
        return token;
    }

    public int addTo(int sum) {
        return sum + this.value;
    }
}
