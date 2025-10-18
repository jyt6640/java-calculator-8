package calculator.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    private InputParser inputParser;

    @BeforeEach
    public void setUp() {
        inputParser = new InputParser();
    }

    @DisplayName("커스텀 구분자 추출")
    @Test
    void 커스텀_구분자_추출() {
        //given
        String input = "//;\\n1;2;3";

        //when
        String result = inputParser.extractCustomDelimiter(input);

        //then
        assertEquals(";", result);
    }

    @DisplayName("커스텀 구분자 형식 뒤 문자열 추출")
    @Test
    void 커스텀_구분자_형식_뒤_문자열_추출() {
        //given
        String input = "//;\\n1;2;3";

        //when
        String result = inputParser.extractNumberSection(input);

        //then
        assertEquals("1;2;3", result);
    }
}
