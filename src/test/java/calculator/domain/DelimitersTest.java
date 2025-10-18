package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DelimitersTest {
    @DisplayName("기본 구분자로 문자열 분리")
    @Test
    void 기본_구분자로_문자열_분리() {
        //given
        Delimiters delimiters = new Delimiters(null);
        String input = "1:2,3";

        //when
        String[] result = delimiters.split(input);

        //then
        assertArrayEquals(new String[]{"1","2","3"}, result);
    }

    @DisplayName("커스텀 구분자로 문자열 분리")
    @Test
    void 커스텀_구분자로_문자열_분리() {
        //given
        Delimiters delimiters = new Delimiters("#");
        String input = "1#2,3";

        //when
        String[] result = delimiters.split(input);

        //then
        assertArrayEquals(new String[]{"1","2","3"}, result);
    }

    @DisplayName("구분자 사이의 공백 빈 문자열로 반환")
    @Test
    void 구분자_사이의_공백_빈_문자열로_반환() {
        //given
        Delimiters delimiters = new Delimiters(null);
        String input = "1,,3";

        //when
        String[] result = delimiters.split(input);

        //then
        assertArrayEquals(new String[]{"1","","3"}, result);
    }
}
