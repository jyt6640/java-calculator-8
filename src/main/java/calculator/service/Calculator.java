package calculator.service;

public class Calculator {
    public int calculate(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }

            sum += Integer.parseInt(token);
        }

        return sum;
    }
}