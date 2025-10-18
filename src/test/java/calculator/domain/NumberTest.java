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
        assertEquals(123, number.getValue());
    }

    @DisplayName("음수 입력 예외 발생")
    @Test
    void 음수_입력_예외_발생() {
        //given
        String input = "-1";

        //when&then
        assertThrows(IllegalArgumentException.class, () -> new Number(input));
    }

    @DisplayName("빈 입력값 0 반환")
    @Test
    void 빈_입력값_0_반환() {
        //given
        String input = "";

        //when
        Number number = new Number(input);

        //then
        assertEquals(0, number.getValue());
    }

}
