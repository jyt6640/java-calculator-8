package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTest {
    @DisplayName("문자열을 숫자로 변환")
    @Test
    void 문자열을_숫자로_변환() {
        //given
        String input = "123";

        //when
        Number number = new Number(input);

        //then
        assertEquals(123, number,getValue());
    }

}
