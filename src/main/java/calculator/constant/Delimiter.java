package calculator.constant;

import java.util.Set;

public class Delimiter {
    public static final String COMMA = ",";
    public static final String SEMICOLON = ":";
    public static final String CUSTOM_PREFIX = "//";

    public static final Set<String> DEFAULT_DELIMITER_SET = Set.of(COMMA, SEMICOLON);

    private Delimiter() {}
}
