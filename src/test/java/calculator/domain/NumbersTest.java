package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest {
    @DisplayName("숫자 배열의 합 계산")
    @Test
    void 숫자_배열의_합_계산() {
        //given
        String[] tokens = {"3","5","7"};

        //when
        Numbers numbers = Numbers.from(tokens);
        int result = numbers.sum();

        //then
        Assertions.assertEquals(15, result);
    }

    @DisplayName("합 계산의 결과가 int 값을 벗어났을 시 예외 발생")
    @Test
    void 합_계산의_결과가_int_값을_벗어났을_시_예외_발생() {
        //given
        String[] tokens = {"2147483646","1","1"};

        //when&then
        Numbers numbers = Numbers.from(tokens);
        assertThrows(IllegalArgumentException.class, () -> numbers.sum());
    }
}
