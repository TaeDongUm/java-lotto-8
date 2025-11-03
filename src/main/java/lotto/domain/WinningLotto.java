package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank calculateRank(Lotto userLotto) {
        int matchCount = countMatchingNumbers(userLotto);
        boolean hasBonus = hasBonus(userLotto);
        return LottoRank.valueOf(matchCount, hasBonus);
    }

    private int countMatchingNumbers(Lotto userLotto) {
        List<Integer> userNumbers = userLotto.getNumbers();
        return (int) lotto.getNumbers().stream()
                .filter(userNumbers::contains)
                .count();
    }

    private boolean hasBonus(Lotto userLotto) {
        return userLotto.getNumbers().contains(bonusNumber.getNumber());
    }

    private void validate(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
