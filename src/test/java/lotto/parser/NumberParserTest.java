package lotto.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberParserTest {

    @DisplayName("빈 문자열을 파싱하려 하면 예외가 발생한다.")
    @Test
    void parse_withEmptyString_shouldThrowException() {
        assertThatThrownBy(() -> NumberParser.parse(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백만 있는 문자열을 파싱하려 하면 예외가 발생한다.")
    @Test
    void parse_withWhitespaceString_shouldThrowException() {
        assertThatThrownBy(() -> NumberParser.parse("   "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 문자/기호가 섞인 입력은 예외가 발생한다.")
    @Test
    void parse_withNonNumericInput_shouldThrowException() {
        assertThatThrownBy(() -> NumberParser.parse("1000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("NULL 값을 파싱하려 하면 예외가 발생한다.")
    @Test
    void parse_withNull_shouldThrowException() {
        assertThatThrownBy(() -> NumberParser.parse(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}