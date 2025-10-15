package calculator;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class StringCalculatorTest {

    @DisplayName("빈 문자열은 0 반환")
    @Test
    void 빈_문자열은_0을_반환() {
        //given
        String input = "";

        //when
        int result = StringCalculator.calculate(input);

        //then
        assertEquals(0, result);
    }
}
