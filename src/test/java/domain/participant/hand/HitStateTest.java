package domain.participant.hand;

import static domain.Fixture.ACE_SCORE;
import static domain.Fixture.DEALER_HITTABLE_UPPER_BOUND_CARDS;
import static domain.Fixture.FOUR_SCORE;
import static domain.Fixture.createHand;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import domain.card.Card;

class HitStateTest {
    private static final HitState HIT_STATE = new HitState(createHand(DEALER_HITTABLE_UPPER_BOUND_CARDS));

    private static Stream<Arguments> createCardAndIsNextBust() {
        return Stream.of(
                Arguments.of(FOUR_SCORE, HitState.class),
                Arguments.of(ACE_SCORE, HitState.class),
                Arguments.of(FOUR_SCORE, BustedState.class)
        );
    }

    @DisplayName("constructor: 초기 카드로 HitState 생성")
    @Test
    void constructor() {
        assertThat(new HitState(createHand(DEALER_HITTABLE_UPPER_BOUND_CARDS)))
                .isInstanceOf(HitState.class);
    }

    @DisplayName("draw: 카드를 한 장 받아 다음 상태로 전이")
    @MethodSource("createCardAndIsNextBust")
    @ParameterizedTest
    void draw(final Card card, final Class<? extends HandState> expect) {
        assertThat(HIT_STATE.draw(card)).isInstanceOf(expect);
    }

    @DisplayName("isFinished: 끝나지 않았음을 반환")
    @Test
    void isFinished() {
        assertThat(HIT_STATE.isFinished()).isFalse();
    }

    @DisplayName("stay: 턴을 마치고 상태 전이")
    @Test
    void stay() {
        assertThat(HIT_STATE.stay()).isInstanceOf(StayState.class);
    }

    @DisplayName("calculateHand: 지원하지 않는 메서드를 호출하여 예외 발생")
    @Test
    void calculateHand() {
        assertThatThrownBy(() -> HIT_STATE.calculateProfit(BigDecimal.valueOf(1_000)))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("getHand: 가지고 있는 패를 반환")
    @Test
    void getHand() {
        assertThat(HIT_STATE.getHand()).isInstanceOf(Hand.class);
    }
}
