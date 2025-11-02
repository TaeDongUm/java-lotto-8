package lotto.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersParserTest {

    @DisplayName("입력이 NULL이면 예외가 발생한다.")
    @Test
    void parse_withNullInput_shouldThrowException() {
        assertThatThrownBy(() -> WinningNumbersParser.parse(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력이 공백만 있으면 예외가 발생한다.")
    @Test
    void parse_withBlankInput_shouldThrowException() {
        assertThatThrownBy(() -> WinningNumbersParser.parse("   "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력이 빈 문자열이면 예외가 발생한다.")
    @Test
    void parse_withEmptyInput_shouldThrowException() {
        assertThatThrownBy(() -> WinningNumbersParser.parse(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
