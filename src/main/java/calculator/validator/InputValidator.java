package calculator.validator;

import static calculator.constant.Delimiter.CUSTOM_PREFIX;
import static calculator.constant.Delimiter.MINUS_SIGN;
import static calculator.constant.Patterns.CUSTOM_DELIMITER;
import static calculator.constant.Patterns.INVALID_CHAR_PATTERN;

import calculator.constant.ErrorMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public boolean hasCustomDelimiterPrefix(String input) { return input.startsWith(CUSTOM_PREFIX); }

    //커스텀 구분자 형식 검증 및 커스텀 구분자 유무 여부 검증
    public void validateCustomDelimiterFormat(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if(!matcher.find()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
        }
        String delimiter = matcher.group(1);
        if (delimiter == null || delimiter.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CUSTOM_DELIMITER.getMessage());
        }
    }

    //커스텀 구분자가 (-)기호인지 확인
    public void validateNotMinusSign(String input) {
        if (MINUS_SIGN.equals(input)) {
            throw new IllegalArgumentException(ErrorMessage.MINUS_SIGN_NOT_ALLOWED.getMessage());
        }
    }

    //기본 구분자로만 추출 가능한 문자열 인지 검증
    public void validateBasicDelimiterInput(String input) {
        if(input.matches(INVALID_CHAR_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER_USAGE.getMessage());
        }
    }

    //기본 구분자 및 커스텀 구분자로 추출 가능한 문자열인지 검증
    public void validateCustomDelimiterInput(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
        }
        String customDelimiter = matcher.group(1);
        String numbersPart = input.substring(matcher.end());
        String allowedPattern = "^[0-9,:" + Pattern.quote(customDelimiter) + "\\n]+$";
        if (!numbersPart.matches(allowedPattern)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER_USAGE.getMessage());
        }
    }
}

