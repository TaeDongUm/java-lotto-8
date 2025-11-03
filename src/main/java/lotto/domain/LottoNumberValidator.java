package lotto.domain;

import lotto.constant.ErrorMessage;

public class LottoNumberValidator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static void validateRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
}
