package domain.participant.hand;

import static domain.Fixture.BLACKJACK_CARDS;
import static domain.Fixture.TWO_SCORE;
import static domain.Fixture.createHand;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlackjackStateTest {
    private static final BlackjackState BLACKJACK_STATE = new BlackjackState(createHand(BLACKJACK_CARDS));

    @DisplayName("constructor: blackjack 상태 생성")
    @Test
    void constructor() {
        assertThat(new BlackjackState(createHand(BLACKJACK_CARDS)))
                .isInstanceOf(BlackjackState.class);
    }

    @DisplayName("draw: 지원하지 않는 메서드를 호출하여 예외 발생")
    @Test
    void draw() {
        assertThatThrownBy(() -> BLACKJACK_STATE.draw(TWO_SCORE)).isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("isBusted: 버스트가 아님")
    @Test
    void isBusted() {
        assertThat(BLACKJACK_STATE.isBusted()).isFalse();
    }

    @DisplayName("isFinished: 끝났음을 반환")
    @Test
    void isFinished() {
        assertThat(BLACKJACK_STATE.isFinished()).isTrue();
    }

    @DisplayName("stay: 지원하지 않는 메서드를 호출하여 예외 발생")
    @Test
    void stay() {
        assertThatThrownBy(BLACKJACK_STATE::stay).isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("calculateProfit: 수익금 계산")
    @Test
    void calculateProfit() {
        assertThat(BLACKJACK_STATE.calculateProfit(BigDecimal.valueOf(1_000)))
                .isEqualTo(BigDecimal.valueOf(1_500));
    }
}
