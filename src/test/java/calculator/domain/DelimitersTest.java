package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DelimitersTest {
    @DisplayName("기본 구분자 집합 정의")
    @Test
    void 기본_구분자_집합_정의() {
        //given
        Delimiters delimiters = new Delimiters(null);

        //when
        Set<String> result = delimiters.getDelimiters();

        //then
        assertEquals(2, result.size());
        assertTrue(result.contains(","));
        assertTrue(result.contains(":"));
    }

    @DisplayName("커스텀 구분자 추가")
    @Test
    void 커스텀_구분자_추가() {
        //given
        Delimiters delimiters = new Delimiters("#");

        //when
        Set<String> result = delimiters.getDelimiters();

        //then
        assertEquals(3, result.size());
        assertTrue(result.contains("#"));
        assertTrue(result.contains(":"));
        assertTrue(result.contains(","));
    }

    @DisplayName("중복 구분자 제거")
    @Test
    void 중복_구분자_제거() {
        //given
        Delimiters delimiters = new Delimiters(",");

        //when
        Set<String> result = delimiters.getDelimiters();

        //then
        assertEquals(2, result.size());
    }

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
}
