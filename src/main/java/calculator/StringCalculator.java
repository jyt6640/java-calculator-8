package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public static int calculate(String input) {
        if (input == "") return 0;

        String[] tokens = input.split(",");
        List<Integer> numbers = new ArrayList<>();


        for (String token : tokens) {
            numbers.add(Integer.parseInt(token));
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

}