package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResult {
    private final List<LottoRank> ranks;

    public LottoResult(List<LottoRank> ranks) {
        this.ranks = ranks;
    }

    public Map<LottoRank, Long> getRankCounts() {
        return ranks.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
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
