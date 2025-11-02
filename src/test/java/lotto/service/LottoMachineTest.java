package lotto.service;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("요청한 장수만큼 로또 리스트를 반환한다.")
    @Test
    void generateLottos_withValidCount_shouldReturnLottoList() {
        // given
        LottoMachine lottoMachine = new LottoMachine();
        int count = 5;

        // when
        List<Lotto> lottos = lottoMachine.generate(count);

        // then
        assertThat(lottos).hasSize(count);
    }
}
