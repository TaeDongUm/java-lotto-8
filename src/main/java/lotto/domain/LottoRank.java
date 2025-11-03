package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    LottoRank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank valueOf(int matchCount, boolean hasBonus) {
        if (matchCount == 5 && hasBonus) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(rank -> rank != SECOND && rank.matchCount == matchCount)
                .findFirst()
                .orElse(MISS);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
