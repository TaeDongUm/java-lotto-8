package lotto.domain;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        LottoNumberValidator.validateRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
