package calculator.view.handler;

import calculator.view.InputView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.*?)\\\\n");
    private static final Pattern VALID_INPUT_PATTERN = Pattern.compile("^[0-9,;]+$");

    private final InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public String getNumber() {
        String input = inputView.readNumber();
        validateEmpty(input);
        return input;
    }

    public boolean hasCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            validateRegex(input);
            return true;
        }
        validateBasicInput(input);
        return false;
    }

    public String getCustomNumberSection(String input) {
        int newlineIndex = input.indexOf("\\n");
        if (newlineIndex != -1) {
            return input.substring(newlineIndex + 2);
        }
        return input;
    }

    public String customDelimiterParser(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private void validateEmpty(String numbers) {
        if (numbers.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 공백입니다.");
        }
    }

    private void validateRegex(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 입력 형식입니다.");
        }
        String delimiter = matcher.group(1);
        if (delimiter == null || delimiter.trim().isBlank()) {
            throw new IllegalArgumentException("[ERROR] 커스텀 구분자가 공백입니다.");
        }
    }

    private void validateBasicInput(String input) {
        if (!VALID_INPUT_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 입력 형식입니다.");
        }
    }

}
