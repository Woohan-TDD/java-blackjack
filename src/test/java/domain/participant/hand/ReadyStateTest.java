package domain.participant.hand;

import static domain.Fixture.ACE_SCORE;
import static domain.Fixture.TEN_SCORE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReadyStateTest {
    private ReadyState readyState;

    @BeforeEach
    void setUp() {
        readyState = new ReadyState();
    }

    @DisplayName("constructor: Ready 상태 생성")
    @Test
    void constructor() {
        assertThat(new ReadyState()).isInstanceOf(ReadyState.class);
    }

    @DisplayName("draw: 두 장 드로우하여 Blackjack 상태로 전이")
    @Test
    void draw() {
        HandState handState = new ReadyState();
        handState = handState.draw(ACE_SCORE);
        handState = handState.draw(TEN_SCORE);

        assertThat(handState.isBlackjack()).isTrue();
    }

    @DisplayName("isBlackjack: 블랙잭이 아님을 확인")
    @Test
    void isBlackjack() {
        assertThat(readyState.isBlackjack()).isFalse();
    }

    @DisplayName("isBusted: 버스트가 아님을 확인")
    @Test
    void isBusted() {
        assertThat(readyState.isBusted()).isFalse();
    }
}
