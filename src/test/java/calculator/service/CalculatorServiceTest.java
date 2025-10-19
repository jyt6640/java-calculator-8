package calculator.service;

import calculator.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    // 정상 케이스 ----------------------------------------------------------------

    @DisplayName("빈 문자열 또는 공백 입력은 0 반환")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n"})
    void 빈_문자열_또는_공백_입력은_0_반환(String input) {
        assertEquals(0, calculatorService.calculate(input));
    }

    @DisplayName("기본 구분자 계산")
    @ParameterizedTest
    @MethodSource("basicDelimiterCases")
    void 기본_구분자_계산(String input, int expected) {
        assertEquals(expected, calculatorService.calculate(input));
    }

    static Stream<Arguments> basicDelimiterCases() {
        return Stream.of(
                Arguments.of("1,2,3", 6),
                Arguments.of("1,2:3", 6),
                Arguments.of("0,0,0", 0),
                Arguments.of("10:20,30", 60)
        );
    }

    @DisplayName("커스텀 구분자 계산")
    @ParameterizedTest
    @MethodSource("customDelimiterCases")
    void 커스텀_구분자_계산(String input, int expected) {
        assertEquals(expected, calculatorService.calculate(input));
    }

    static Stream<Arguments> customDelimiterCases() {
        return Stream.of(
                Arguments.of("//;\\n1;2;3", 6),
                Arguments.of("//*\\n1*2*3", 6),
                Arguments.of("//***\\n1***2***3", 6),
                Arguments.of("//.\\n1.2.3", 6)
        );
    }

    @DisplayName("커스텀 구분자만 있고 숫자 파트가 없을 시 0 반환")
    @ParameterizedTest
    @ValueSource(strings = {"//;\\n", "//***\\n"})
    void 커스텀_구분자만_있고_숫자_파트가_없을_시_0_반환(String input) {
        assertEquals(0, calculatorService.calculate(input));
    }

    @DisplayName("연속된 기본 구분자나 빈 토큰은 0 반환")
    @ParameterizedTest
    @MethodSource("emptyTokenCases")
    void 연속된_기본_구분자_및_빈_토큰은_0_반환(String input, int expected) {
        assertEquals(expected, calculatorService.calculate(input));
    }

    static Stream<Arguments> emptyTokenCases() {
        return Stream.of(
                Arguments.of("1,,2", 3),
                Arguments.of(",1,2", 3),
                Arguments.of(",,,", 0)
        );
    }

    @DisplayName("연속된 커스텀 구분자는 빈 토큰은 0 반환")
    @ParameterizedTest
    @MethodSource("consecutiveCustomDelimiterCases")
    void 연속된_커스텀_구분자_및_빈_토큰은_0_반환(String input, int expected) {
        assertEquals(expected, calculatorService.calculate(input));
    }

    static Stream<Arguments> consecutiveCustomDelimiterCases() {
        return Stream.of(
                Arguments.of("//;\\n1;;2", 3),
                Arguments.of("//;\\n;;;;", 0)
        );
    }

    // 예외 케이스 ----------------------------------------------------------------

    @DisplayName("음수가 포함된 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "//;\\n1;-2;3"})
    void 음수가_포함된_경우_예외_발생(String input) {
        assertThatThrownBy(() -> calculatorService.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NEGATIVE_NUMBER.getMessage());
    }

    @DisplayName("숫자가 아닌 문자가 포함된 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,a,3", "//;\\n1;a;3"})
    void 숫자가_아닌_문자가_포함된_경우_예외_발생(String input) {
        assertThatThrownBy(() -> calculatorService.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_A_NUMBER.getMessage());
    }

    @DisplayName("커스텀 구분자 형식이 잘못된 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"//;1;2;3", "//\n1;2;3"})
    void 커스텀_구분자_형식이_잘못된_경우_예외_발생(String input) {
        assertThatThrownBy(() -> calculatorService.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
    }

    @DisplayName("커스텀 구분자가 비어있거나 공백만 있을 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"//\\n1;2;3", "// \\n1;2;3"})
    void 커스텀_구분자가_비어있거나_공백만_있을_경우_예외_발생(String input) {
        assertThatThrownBy(() -> calculatorService.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_CUSTOM_DELIMITER.getMessage());
    }

    @DisplayName("커스텀 구분자가 숫자인 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"//1\\n2123", "//123\\n456123789"})
    void 커스텀_구분자가_숫자인_경우_예외_발생(String input) {
        assertThatThrownBy(() -> calculatorService.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_NOT_ALLOWED.getMessage());
    }

    @DisplayName("커스텀 구분자가 음수 기호인 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"//-\\n1-2-3"})
    void 커스텀_구분자가_음수_기호인_경우_예외_발생(String input) {
        assertThatThrownBy(() -> calculatorService.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MINUS_SIGN_NOT_ALLOWED.getMessage());
    }

    @DisplayName("선언되지 않은 구분자가 포함된 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,2;3", "//;\\n1#2:3"})
    void 선언되지_않은_구분자가_포함된_경우_예외_발생(String input) {
        assertThatThrownBy(() -> calculatorService.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DELIMITER_PARSE_FAILED.getMessage());
    }

    @DisplayName("입력 숫자가 int 범위를 벗어나는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"9999999999999", "//;\\n9999999999999;1"})
    void 입력_숫자가_int_범위를_벗어나는_경우_예외_발생(String input) {
        assertThatThrownBy(() -> calculatorService.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUT_OF_RANGE.getMessage());
    }

    @DisplayName("계산 후 숫자가 int 범위를 벗어나는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"2147483647,1", "//;\\n2147483647;1"})
    void 계산_후_숫자가_int_범위를_벗어나는_경우_예외_발생(String input) {
        assertThatThrownBy(() -> calculatorService.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUT_OF_RANGE.getMessage());
    }
}