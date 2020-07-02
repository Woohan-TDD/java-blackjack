package domain;

import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BettingMoneyTest {
    @DisplayName("constructor: 금액을 입력받아 인스턴스 생성")
    @ValueSource(ints = {100, 1_000, 5_000, 10_500})
    @ParameterizedTest
    void constructor(final int amount) {
        assertThat(new BettingMoney(amount)).isInstanceOf(BettingMoney.class);
    }

    @DisplayName("constructor: 최소 베팅 금액을 충족하지 못한 경우 예외 발생")
    @ValueSource(ints = {0, 99})
    @ParameterizedTest
    void constructor_LackOfAmount_ExceptionThrown(final int amount) {
        assertThatThrownBy(() -> new BettingMoney(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("베팅 최소 금액을 충족하지 못했습니다");
    }

    @DisplayName("constructor: 금액의 단위가 못한 경우 예외 발생")
    @Test
    void constructor_BettingUnitMismatch_ExceptionThrown() {
        assertThatThrownBy(() -> new BettingMoney(101))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액의 단위가 올바르지 않습니다");
    }

    @DisplayName("getAmount: 금액을 반환")
    @Test
    void getAmount() {
        BettingMoney bettingMoney = new BettingMoney(1_000);

        assertThat(bettingMoney.getAmount()).isEqualTo(valueOf(1_000));
    }
}
