package calculator.domain;

import calculator.constant.ErrorMessage;

public class Number {
    private final int value;

    public Number(String token) {
        token = token.trim();

        token = convertEmptyToZero(token);

        this.value = parseToInt(token);

        validateNonNegative(this.value);
    }

    private void validateNonNegative(int number) {
        if (value < 0 ) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER.getMessage());
        }
    }

    private String convertEmptyToZero(String token) {
        if (token == null || token.isEmpty()) {
            return "0";
        }
        return token;
    }

    private int parseToInt(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            handleParseError(token);
            return 0;
        }
    }

    private void handleParseError(String token) {
        if(isOutOfRange(token)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.getMessage());
    }

    private boolean isOutOfRange(String token) {
        try {
            long value = Long.parseLong(token);
            return value < Integer.MIN_VALUE || value > Integer.MAX_VALUE;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public int addTo(int sum) {
        return sum + this.value;
    }
}
