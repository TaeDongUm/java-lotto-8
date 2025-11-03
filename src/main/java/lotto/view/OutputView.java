package lotto.view;

import lotto.Lotto;
import lotto.constant.Message;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void printLottoCount(PurchaseAmount purchaseAmount) {
        System.out.printf(Message.INFO_PURCHASE_COUNT.getMessage(), purchaseAmount.calculateLottoCount());
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResults(LottoResult lottoResult) {
        System.out.println(Message.RESULT_HEADER.getMessage());
        System.out.println(Message.RESULT_SEPARATOR.getMessage());

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
            bonusInfo = Message.BONUS_MATCH_TEXT.getMessage();
        }
        return String.format(Message.RESULT_RANK_FORMAT.getMessage(),
                rank.getMatchCount(),
                bonusInfo,
                rank.getPrizeMoney(),
                count);
    }

    public void printProfitRate(LottoResult lottoResult, PurchaseAmount purchaseAmount) {
        double profitRate = lottoResult.getProfitRate(purchaseAmount);
        System.out.printf(Message.RESULT_PROFIT_RATE.getMessage(), profitRate);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
