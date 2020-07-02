package domain.participant.hand;

import static domain.Fixture.BLACKJACK_CARDS;
import static domain.Fixture.BUSTED_BY_ACE_CARDS;
import static domain.Fixture.BUSTED_CARDS;
import static domain.Fixture.DEALER_HITTABLE_UPPER_BOUND_CARDS;
import static domain.Fixture.DEALER_NOT_HITTABLE_LOWER_BOUND_CARDS;
import static domain.Fixture.MAX_SCORE_CARDS;
import static domain.card.Face.ACE;
import static domain.card.Suit.SPADE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import domain.card.Card;

class HandTest {
    private static Stream<Arguments> createCardsAndScore() {
        return Stream.of(
                Arguments.of(BUSTED_CARDS, 22),
                Arguments.of(BUSTED_BY_ACE_CARDS, 22),
                Arguments.of(BLACKJACK_CARDS, 21),
                Arguments.of(MAX_SCORE_CARDS, 21),
                Arguments.of(DEALER_HITTABLE_UPPER_BOUND_CARDS, 16),
                Arguments.of(DEALER_NOT_HITTABLE_LOWER_BOUND_CARDS, 17)
        );
    }

    private static Stream<Arguments> createCardsAndIsBlackjack() {
        return Stream.of(
                Arguments.of(BUSTED_BY_ACE_CARDS, false),
                Arguments.of(BLACKJACK_CARDS, true),
                Arguments.of(MAX_SCORE_CARDS, false),
                Arguments.of(DEALER_HITTABLE_UPPER_BOUND_CARDS, false)
        );
    }

    private static Stream<Arguments> createCardsAndIsBust() {
        return Stream.of(
                Arguments.of(BUSTED_BY_ACE_CARDS, true),
                Arguments.of(BLACKJACK_CARDS, false),
                Arguments.of(MAX_SCORE_CARDS, false),
                Arguments.of(DEALER_HITTABLE_UPPER_BOUND_CARDS, false)
        );
    }

    @DisplayName("constructor: Hand 인스턴스 생성")
    @Test
    void constructor() {
        assertThat(new Hand()).isInstanceOf(Hand.class);
    }

    @DisplayName("draw: 카드를 한 장 추가")
    @Test
    void draw() {
        Hand hand = new Hand();
        Card card = Card.fromFaceAndSuit(ACE, SPADE);

        hand.draw(card);
        assertThat(hand.size()).isEqualTo(1);
    }

    @DisplayName("isBlackjack: 카드가 블랙잭인지 여부를 판단")
    @MethodSource("createCardsAndIsBlackjack")
    @ParameterizedTest
    void isBlackjack(final List<Card> cards, final boolean expect) {
        Hand hand = new Hand();

        for (final Card card : cards) {
            hand.draw(card);
        }

        assertThat(hand.isBlackjack()).isEqualTo(expect);
    }

    @DisplayName("isBust: 카드가 버스트인지 여부를 판단")
    @MethodSource("createCardsAndIsBust")
    @ParameterizedTest
    void isBust(final List<Card> cards, final boolean expect) {
        Hand hand = new Hand();

        for (final Card card : cards) {
            hand.draw(card);
        }

        assertThat(hand.isBust()).isEqualTo(expect);
    }

    @DisplayName("calculateScore: 카드의 점수를 계산")
    @MethodSource("createCardsAndScore")
    @ParameterizedTest
    void calculateScore(final List<Card> cards, final int expect) {
        Hand hand = new Hand();

        for (final Card card : cards) {
            hand.draw(card);
        }

        assertThat(hand.calculateScore()).isEqualTo(expect);
    }
}
