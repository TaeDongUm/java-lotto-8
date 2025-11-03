package lotto.domain;

import lotto.Lotto;
import lotto.constant.ErrorMessage;

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
            throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE_WITH_WINNING_NUMBERS.getMessage());
        }
    }
}
