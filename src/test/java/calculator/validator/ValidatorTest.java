package calculator.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    private CustomDelimiterValidator customDelimiterValidator;
    private NumberPartValidator numberPartValidator;

    @BeforeEach
    public void setUp() {
        customDelimiterValidator = new CustomDelimiterValidator();
        numberPartValidator = new NumberPartValidator();
    }

    @DisplayName("커스텀 구분자 누락 시 예외 발생")
    @Test
    void 커스텀_구분자_누락_시_예외_발생 () {
        //given
        String input = "//\n1;2;3";

        //when&then
        assertThrows(IllegalArgumentException.class, () -> customDelimiterValidator.emptyCustomDelimiterValidate(input));
    }

    @DisplayName("커스텀 구분자 형식 예외 발생")
    @Test
    void 커스텀_구분자_형식_예외_발생() {
        //given
        String input = "//;1;2;3";

        //when&then
        assertThrows(IllegalArgumentException.class, () -> customDelimiterValidator.validateCustomDelimiterFormat(input));
    }

    @DisplayName("커스텀 구분자 접두사 문자 확인")
    @Test
    void 커스텀_구분자_접두사_문자_확인() {
        //given
        String input = "//;1;2;3";

        //when
        customDelimiterValidator.startCustomDelimiterPrefix(input);

        //then
        assertTrue(true);
    }

    @DisplayName("숫자가 아닌 값 입력 시 예외 발생")
    @Test
    void 숫자가_아닌_값_입력_시_예외_발생() {
        //given
        String input[] = {"1","a","3"};

        //when&then
        assertThrows(IllegalArgumentException.class, () -> numberPartValidator.containsNonDigit(input));
    }

    @DisplayName("커스텀 구분자 형식 선언 없이 커스텀 구분자 사용 시 예외 발생")
    @Test
    void 커스텀_구분자_형식_선언_없이_커스텀_구분자_사용_시_예외_발생() {
        //given
        String input = "1,2;3";

        //when&then
        assertThrows(IllegalArgumentException.class, () -> numberPartValidator.validateWithoutCustomDelimiter(input));
    }

    @DisplayName("커스텀 구분자 형식 선언 후 선언하지 않은 커스텀 구분자 사용 시 예외 발생")
    @Test
    void 커스텀_구분자_형식_선언_후_선언하지_않은_커스텀_구분자_사용_시_예외_발생() {
        //given
        String input = "//#\n1#2;3";

        //when&then
        assertThrows(IllegalArgumentException.class, () -> numberPartValidator.validateWithCustomDelimiter(input));
    }
}
