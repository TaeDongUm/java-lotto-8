package lotto.domain;

import lotto.parser.WinningNumbersParser;
import org.junit.jupiter.api.DisplayName;
import lotto.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("6개 번호가 모두 일치하면 1등을 반환한다.")
    @Test
    void calculateRank_with6Matches_shouldReturnFirst() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.calculateRank(userLotto)).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("5개 번호와 보너스 번호가 일치하면 2등을 반환한다.")
    @Test
    void calculateRank_with5MatchesAndBonus_shouldReturnSecond() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(winningLotto.calculateRank(userLotto)).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("5개 번호만 일치하면 3등을 반환한다.")
    @Test
    void calculateRank_with5Matches_shouldReturnThird() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        assertThat(winningLotto.calculateRank(userLotto)).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("4개 번호가 일치하면 4등을 반환한다.")
    @Test
    void calculateRank_with4Matches_shouldReturnFourth() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        assertThat(winningLotto.calculateRank(userLotto)).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("3개 번호가 일치하면 5등을 반환한다.")
    @Test
    void calculateRank_with3Matches_shouldReturnFifth() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        assertThat(winningLotto.calculateRank(userLotto)).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("2개 이하 번호가 일치하면 MISS를 반환한다.")
    @Test
    void calculateRank_with2OrLessMatches_shouldReturnMiss() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));
        Lotto userLotto = new Lotto(List.of(1, 2, 8, 9, 10, 11));
        assertThat(winningLotto.calculateRank(userLotto)).isEqualTo(LottoRank.MISS);
    }
}
