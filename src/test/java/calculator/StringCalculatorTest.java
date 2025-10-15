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

    @DisplayName("숫자 하나 입력 시 숫자 하나만 반환")
    @Test
    void 숫자_하나_입력_시_숫자_하나만_반환() {
        //given
        String input = "1";

        //when
        int result = StringCalculator.calculate(input);

        //then
        assertEquals(1, result);
    }
}
