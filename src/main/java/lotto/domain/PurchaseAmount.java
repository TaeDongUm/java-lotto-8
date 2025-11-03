package lotto.domain;

import lotto.constant.ErrorMessage;

public class PurchaseAmount {

    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_NOT_POSITIVE.getMessage());
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_NOT_DIVISIBLE.getMessage());
        }
    }

    public int calculateLottoCount() {
        return amount / 1000;
    }

    public int getAmount() {
        return amount;
    }
}