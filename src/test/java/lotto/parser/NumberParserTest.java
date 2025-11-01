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

    @DisplayName("NULL 값을 파싱하려 하면 예외가 발생한다.")
    @Test
    void parse_withNull_shouldThrowException() {
        assertThatThrownBy(() -> NumberParser.parse(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
