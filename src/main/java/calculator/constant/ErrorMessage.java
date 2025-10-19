package calculator.constant;

public enum ErrorMessage {
    NEGATIVE_NUMBER("음수는 허용되지 않습니다."),
    NOT_A_NUMBER("숫자가 아닌 값이 포함되어 있습니다."),
    EMPTY_CUSTOM_DELIMITER("커스텀 구분자가 비어있습니다."),
    INVALID_CUSTOM_DELIMITER_FORMAT("커스텀 구분자 형식이 올바르지 않습니다."),
    INVALID_DELIMITER_USAGE("선언된 구분자 이외의 구분자가 입력되었습니다."),
    MINUS_SIGN_NOT_ALLOWED("(-)기호는 커스텀 구분자로 허용되지 않습니다."),
    NUMBER_NOT_ALLOWED("숫자는 커스텀 구분자로 허용되지 않습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
