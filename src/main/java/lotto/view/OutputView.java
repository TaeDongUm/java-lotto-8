package lotto.view;

import lotto.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void printLottoCount(PurchaseAmount purchaseAmount) {
        System.out.printf("\n%d개를 구매했습니다.\n", purchaseAmount.calculateLottoCount());
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResults(LottoResult lottoResult) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        Map<LottoRank, Long> rankCounts = lottoResult.getRankCounts();

        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.MISS)
                .sorted(Collections.reverseOrder())
                .forEach(rank -> {
                    long count = rankCounts.getOrDefault(rank, 0L);
                    String message = formatRankMessage(rank, count);
                    System.out.println(message);
                });
    }

    private String formatRankMessage(LottoRank rank, long count) {
        String bonusInfo = "";
        if (rank == LottoRank.SECOND) {
            bonusInfo = ", 보너스 볼 일치";
        }
        return String.format("%d개 일치%s (%,d원) - %d개",
                rank.getMatchCount(),
                bonusInfo,
                rank.getPrizeMoney(),
                count);
    }

    public void printProfitRate(LottoResult lottoResult, PurchaseAmount purchaseAmount) {
        double profitRate = lottoResult.getProfitRate(purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
