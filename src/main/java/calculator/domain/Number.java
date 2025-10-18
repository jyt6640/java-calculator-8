package calculator.domain;

import calculator.constant.ErrorMessage;

public class Number {
    private final int value;

    public Number(String token) {
        token = token.trim();

        token = normalizeEmptyInput(token);

        this.value = parseToInt(token);

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

    private int parseToInt(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.getMessage());
        }

    }

    public int addTo(int sum) {
        return sum + this.value;
    }
}
