package lotto.domain;

import lotto.parser.WinningNumbersParser;
import org.junit.jupiter.api.DisplayName;
import lotto.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("파싱된 당첨 번호 문자열로 Lotto 객체를 성공적으로 생성한다.")
    @Test
    void createLotto_fromParsedWinningNumbers_shouldSucceed() {
        // given
        String winningNumbersInput = "1,2,3,4,5,6";

        // when
        List<Integer> parsedNumbers = WinningNumbersParser.parse(winningNumbersInput);

        // then
        assertThatCode(() -> new Lotto(parsedNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("당첨 번호와 중복되는 보너스 번호로 WinningLotto를 생성하면 예외가 발생한다.")
    @Test
    void createWinningLotto_withDuplicatedBonusNumber_shouldThrowException() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(6);

        // when & then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 당첨 번호와 보너스 번호로 WinningLotto를 성공적으로 생성한다.")
    @Test
    void createWinningLotto_withValidNumbers_shouldSucceed() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        // when & then
        assertThatCode(() -> new WinningLotto(lotto, bonusNumber))
                .doesNotThrowAnyException();
    }
}
