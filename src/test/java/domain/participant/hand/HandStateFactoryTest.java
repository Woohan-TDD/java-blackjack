package domain.participant.hand;

import static domain.Fixture.BLACKJACK_CARDS;
import static domain.Fixture.DEALER_HITTABLE_UPPER_BOUND_CARDS;
import static domain.Fixture.createHand;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HandStateFactoryTest {
    private static Stream<Arguments> createCardsAndExpectResult() {
        return Stream.of(
                Arguments.of(createHand(BLACKJACK_CARDS), BlackjackState.class),
                Arguments.of(createHand(DEALER_HITTABLE_UPPER_BOUND_CARDS), HitState.class)
        );
    }

    @DisplayName("createFromInitialHand: 카드를 입력받아 초기 상태 생성")
    @MethodSource("createCardsAndExpectResult")
    @ParameterizedTest
    void createFromInitialHand(final Hand hand, final Class<? extends HandState> expect) {
        assertThat(HandStateFactory.createFromInitialHand(hand)).isInstanceOf(expect);
    }
}