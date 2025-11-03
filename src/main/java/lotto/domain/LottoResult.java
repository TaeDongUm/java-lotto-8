package lotto.domain;

import java.util.List;

public class LottoResult {
    private final List<LottoRank> ranks;

    public LottoResult(List<LottoRank> ranks) {
        this.ranks = ranks;
    }

    public long getTotalPrizeMoney() {
        return ranks.stream()
                .mapToLong(LottoRank::getPrizeMoney)
                .sum();
    }

    public double getProfitRate(PurchaseAmount purchaseAmount) {
        long totalPrize = getTotalPrizeMoney();
        if (totalPrize == 0) {
            return 0.0;
        }
        double rate = (double) totalPrize / purchaseAmount.getAmount() * 100.0;
        return Math.round(rate * 10.0) / 10.0;
    }
}
