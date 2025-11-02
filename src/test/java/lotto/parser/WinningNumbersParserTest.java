package lotto.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersParserTest {

    @DisplayName("입력이 null이거나 빈 문자열, 공백만 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void parse_withBlankInput_shouldThrowException(String input) {
        assertThatThrownBy(() -> WinningNumbersParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void parse_withNullInput_shouldThrowException() {
        assertThatThrownBy(() -> WinningNumbersParser.parse(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력에 빈 토큰이 포함되어 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,,", "1,2,3,", ",1,2,3"})
    void parse_withEmptyToken_shouldThrowException(String input) {
        assertThatThrownBy(() -> WinningNumbersParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}