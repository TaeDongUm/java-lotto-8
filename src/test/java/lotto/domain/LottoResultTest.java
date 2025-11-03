package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("등수 목록으로 총상금을 정확히 계산한다.")
    @Test
    void calculateTotalPrizeMoney_shouldReturnCorrectSum() {
        // given
        List<LottoRank> ranks = List.of(LottoRank.FIFTH, LottoRank.MISS, LottoRank.FOURTH, LottoRank.MISS);
        LottoResult result = new LottoResult(ranks);

        // when
        long totalPrize = result.getTotalPrizeMoney();

        // then
        assertThat(totalPrize).isEqualTo(5000 + 50000);
    }

    @DisplayName("총상금과 구매금액으로 수익률을 소수점 둘째 자리에서 반올림하여 정확히 계산한다.")
    @Test
    void calculateProfitRate_shouldReturnCorrectlyRoundedValue() {
        // given
        // 5000원(5등) 당첨 / 8000원 구매 -> 62.5%
        List<LottoRank> ranks = List.of(LottoRank.FIFTH, LottoRank.MISS, LottoRank.MISS, LottoRank.MISS, LottoRank.MISS, LottoRank.MISS, LottoRank.MISS, LottoRank.MISS);
        LottoResult result = new LottoResult(ranks);
        PurchaseAmount purchaseAmount = new PurchaseAmount(8000);

        // when
        double profitRate = result.getProfitRate(purchaseAmount);

        // then
        assertThat(profitRate).isEqualTo(62.5);
    }
}
