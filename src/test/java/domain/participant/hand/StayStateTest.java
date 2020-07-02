package domain.participant.hand;

import static domain.Fixture.DEALER_HITTABLE_UPPER_BOUND_CARDS;
import static domain.Fixture.TWO_SCORE;
import static domain.Fixture.createHand;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StayStateTest {
    private static final StayState STAY_STATE = new StayState(createHand(DEALER_HITTABLE_UPPER_BOUND_CARDS));

    @DisplayName("constructor: stay 상태 생성")
    @Test
    void constructor() {
        assertThat(new StayState(createHand(DEALER_HITTABLE_UPPER_BOUND_CARDS)))
                .isInstanceOf(StayState.class);
    }

    @DisplayName("draw: 지원하지 않는 메서드를 호출하여 예외 발생")
    @Test
    void draw() {
        assertThatThrownBy(() -> STAY_STATE.draw(TWO_SCORE)).isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("isFinished: 끝났음을 반환")
    @Test
    void isFinished() {
        assertThat(STAY_STATE.isFinished()).isTrue();
    }

    @DisplayName("stay: 지원하지 않는 메서드를 호출하여 예외 발생")
    @Test
    void stay() {
        assertThatThrownBy(STAY_STATE::stay).isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("calculateProfit: 수익금 계산")
    @Test
    void calculateHand() {
        assertThat(STAY_STATE.calculateProfit(BigDecimal.valueOf(1_000)))
                .isEqualTo(BigDecimal.valueOf(1_000));
    }
}
