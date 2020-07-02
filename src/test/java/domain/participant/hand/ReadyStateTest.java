package domain.participant.hand;

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

    @DisplayName("Ready 상태 생성")
    @Test
    void constructor() {
        assertThat(new ReadyState()).isInstanceOf(ReadyState.class);
    }

    @DisplayName("블랙잭이 아님을 확인")
    @Test
    void isBlackjack() {
        assertThat(readyState.isBlackjack()).isFalse();
    }

    @DisplayName("버스트가 아님을 확인")
    @Test
    void isBusted() {
        assertThat(readyState.isBusted()).isFalse();
    }
}
