package lotto.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberParserTest {

    @DisplayName("입력이 null이거나 빈 문자열, 공백만 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void parse_withBlankInput_shouldThrowException(String input) {
        assertThatThrownBy(() -> BonusNumberParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    void parse_withNonNumericInput_shouldThrowException() {
        assertThatThrownBy(() -> BonusNumberParser.parse("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("앞뒤 공백이 있는 숫자 문자열을 올바르게 파싱한다.")
    @Test
    void parse_withWhitespace_shouldSucceed() {
        assertThat(BonusNumberParser.parse(" 45 ")).isEqualTo(45);
    }

    @DisplayName("정상적인 숫자 문자열을 올바르게 파싱한다.")
    @Test
    void parse_withValidNumber_shouldSucceed() {
        assertThat(BonusNumberParser.parse("1")).isEqualTo(1);
    }
}
