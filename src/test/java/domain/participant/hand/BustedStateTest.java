package domain.participant.hand;

import static domain.Fixture.BLACKJACK_CARDS;
import static domain.Fixture.BUSTED_CARDS;
import static domain.Fixture.TWO_SCORE;
import static domain.Fixture.createHand;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BustedStateTest {
    private static final BustedState BUSTED_STATE = new BustedState(createHand(BUSTED_CARDS));

    @DisplayName("constructor: busted 상태 생성")
    @Test
    void constructor() {
        assertThat(new BustedState(createHand(BLACKJACK_CARDS)))
                .isInstanceOf(BustedState.class);
    }

    @DisplayName("draw: 지원하지 않는 메서드를 호출하여 예외 발생")
    @Test
    void draw() {
        assertThatThrownBy(() -> BUSTED_STATE.draw(TWO_SCORE)).isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("isFinished: 끝났음을 반환")
    @Test
    void isFinished() {
        assertThat(BUSTED_STATE.isFinished()).isTrue();
    }

    @DisplayName("stay: 지원하지 않는 메서드를 호출하여 예외 발생")
    @Test
    void stay() {
        assertThatThrownBy(BUSTED_STATE::stay).isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("calculateProfit: 수익금 계산")
    @Test
    void calculateProfit() {
        assertThat(BUSTED_STATE.calculateProfit(BigDecimal.valueOf(1_000)))
                .isEqualTo(BigDecimal.valueOf(-1_000));
    }
}
