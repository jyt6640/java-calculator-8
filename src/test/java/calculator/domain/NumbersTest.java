package calculator.domain;


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
}
