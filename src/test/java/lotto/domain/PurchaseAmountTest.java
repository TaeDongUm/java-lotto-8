package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {

    @DisplayName("구입 금액으로 빈 문자열을 입력하면 예외가 발생한다.")
    @Test
    void createPurchaseAmount_withEmptyString_shouldThrowException() {
        assertThatThrownBy(() -> new PurchaseAmount(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
