package calculator.domain;

public class Number {
    private final int value;

    public Number(String token) {
        this.value = Integer.parseInt(token);
    }

    public int getValue() {
        return value;
    }
}
