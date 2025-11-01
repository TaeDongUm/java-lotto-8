package lotto.domain;

public class PurchaseAmount {

    public PurchaseAmount(String input) {
        validate(input);
    }

    private void validate(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 입력해 주세요.");
        }
    }
}
