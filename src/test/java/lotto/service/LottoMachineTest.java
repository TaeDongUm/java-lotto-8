package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    @DisplayName("발행 장수가 1장 미만일 경우 예외가 발생한다.")
    @Test
    void generateLottos_withCountLessThanOne_shouldThrowException() {
        // given
        LottoMachine lottoMachine = new LottoMachine();

        // when & then
        assertThatThrownBy(() -> lottoMachine.generate(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
