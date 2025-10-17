package calculator.constant;

public class Patterns {
    public static final String CUSTOM_DELIMITER = "^//(.+?)\\\\n";
    public static final String ONLY_NUMBER = "^-?\\d+$";
    public static final String INVALID_CHAR_PATTERN = ".*[^0-9,:\\n].*";

    private Patterns() {}
}
