package domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BettingMoneyTest {

    @Test
    @DisplayName("정상 생성 테스트")
    void create() {
        BettingMoney bettingMoney = new BettingMoney(300);
        assertThat(bettingMoney).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, -1})
    @DisplayName("유효성 검사")
    void validate(double input) {
        assertThatThrownBy(() -> new BettingMoney(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("배팅금액은 1원 이상이어야 합니다. 입력금액 : " + input);
    }

}