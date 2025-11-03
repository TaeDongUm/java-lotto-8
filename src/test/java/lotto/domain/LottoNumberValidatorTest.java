package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberValidatorTest {

    @DisplayName("로또 번호가 1-45 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1, 100})
    void validateRange_withOutOfRangeNumber_shouldThrowException(int number) {
        assertThatThrownBy(() -> LottoNumberValidator.validateRange(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
