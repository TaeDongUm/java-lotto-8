package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @DisplayName("1-45 범위를 벗어나는 숫자로 보너스 번호를 생성하면 예외가 발생한다.")
    @Test
    void createBonusNumber_withOutOfRangeNumber_shouldThrowException() {
        assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1-45 범위 내의 숫자로 보너스 번호를 성공적으로 생성한다.")
    @Test
    void createBonusNumber_withInRangeNumber_shouldSucceed() {
        assertThatCode(() -> new BonusNumber(45))
                .doesNotThrowAnyException();
    }
}
