package calculator.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @DisplayName("음수 입력 예외 발생")
    @Test
    void 음수_입력_예외_발생() {
        //given
        String input = "-1,2,3";

        //when&then
        assertThrows(IllegalArgumentException.class, () -> numberPartValidator.negativeNumberValidate(input));
    }

    @DisplayName("숫자가 아닌 값 입력 시 예외 발생")
    @Test
    void 숫자가_아닌_값_입력_시_예외_발생() {
        //given
        String input = "1,a,3";

        //when&then
        assertThrows(IllegalArgumentException.class, () -> numberPartValidator.notANumberValidate(input));
    }

    @DisplayName("커스텀 구분자 누락 시 예외 발생")
    @Test
    void 커스텀_구분자_누락_시_예외_발생 () {
        //given
        String input = "//\n1;2;3";

        //when&then
        assertThrows(IllegalArgumentException.class, () -> CustomDelimiterValidator.emptyCustomValidate(input));
    }

    @DisplayName("개행 표식 누락 시 예외 발생")
    @Test
    void 개행_표식_누락_시_예외_발생() {
        //given
        String input = "//;1;2;3";

        //when&then
        assertThrows(IllegalArgumentException.class, () -> CustomDelimiterValidator.invalidCustomDelimiterFormatValidate(input));
    }
}
