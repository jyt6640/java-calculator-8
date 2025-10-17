package calculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("숫자 하나 입력 시 숫자 하나만 반환")
    @Test
    void 숫자_하나_입력_시_숫자_하나만_반환() {
        //given
        String[] tokens = {"1"};

        //when
        int result = calculator.calculate(tokens);

        //then
        assertEquals(1, result);
    }

    @DisplayName("여러 숫자 덧셈")
    @Test
    void 여러_숫자_덧셈() {
        //given
        String[] tokens = {"1","2","3"};

        //when
        int result = calculator.calculate(tokens);

        //then
        assertEquals(6, result);
    }
}
