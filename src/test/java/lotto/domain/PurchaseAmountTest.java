package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {

    @DisplayName("구입 금액이 1000원으로 나누어떨어지지 않으면 예외가 발생한다.")
    @Test
    void createPurchaseAmount_withNonMultipleOf1000_shouldThrowException() {
        assertThatThrownBy(() -> new PurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0 이하일 경우 예외가 발생한다.")
    @Test
    void createPurchaseAmount_withNonPositiveAmount_shouldThrowException() {
        assertThatThrownBy(() -> new PurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액으로 로또 개수를 올바르게 계산한다.")
    @Test
    void calculateLottoCount_withValidAmount_shouldReturnCorrectCount() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(8000);
        org.assertj.core.api.Assertions.assertThat(purchaseAmount.calculateLottoCount()).isEqualTo(8);
    }

    @DisplayName("getAmount가 정확한 금액을 반환한다.")
    @Test
    void getAmount_shouldReturnCorrectAmount() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(8000);
        org.assertj.core.api.Assertions.assertThat(purchaseAmount.getAmount()).isEqualTo(8000);
    }
}