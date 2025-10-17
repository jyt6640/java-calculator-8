package calculator.domain;

public class StringCalculator {
    private final DelimiiterParser delimiterParser = new DelimiiterParser();
    private final NumberValidator numberValidator = new NumberValidator();

    public int calculate(String input) {
        if (input.isEmpty()) return 0;

        String delimiters = ",:";
        String numbersPart = input;

        if (input.startsWith("//")) {
            String customDelimiter = delimiterParser.extractCustomDelimiter(input);
            numbersPart = delimiterParser.extractNumbersPart(input);
            delimiters += customDelimiter;
        }

        String[] tokens = numbersPart.split("[" + delimiters + "]");

        int sum = 0;
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }

            int number = numberValidator.parseAndValidateNumber(token);

            sum += number;
        }

        return sum;
    }
}