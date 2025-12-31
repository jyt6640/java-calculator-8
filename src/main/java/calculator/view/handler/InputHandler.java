package calculator.view.handler;

import calculator.view.InputView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.*?)\\\\n");

    private final InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public String getNumber() {
        return inputView.readNumber();
    }

    public boolean hasCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public String getCustomNumberSection(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            return matcher.replaceAll("\n");
        }
        return null;
    }

    public String customDelimiterParser(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

}
