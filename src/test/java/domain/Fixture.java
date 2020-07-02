package domain;

import static domain.card.Face.ACE;
import static domain.card.Face.FIVE;
import static domain.card.Face.FOUR;
import static domain.card.Face.JACK;
import static domain.card.Face.SEVEN;
import static domain.card.Face.SIX;
import static domain.card.Face.THREE;
import static domain.card.Face.TWO;
import static domain.card.Suit.CLUB;
import static domain.card.Suit.SPADE;

import java.util.Arrays;
import java.util.List;

import domain.card.Card;
import domain.participant.hand.Hand;
import domain.participant.hand.HandState;
import domain.participant.hand.ReadyState;

public class Fixture {
    public static final List<Card> CARDS = Card.values();

    public static final Name SOUTHJUN = new Name("southjun");
    public static final Name NORTHJUN = new Name("northjun");
    public static final Name WESTJUN = new Name("westjun");
    public static final Name EASTJUN = new Name("eastjun");

    public static final BettingMoney HUNDRED_BETTING_MONEY = new BettingMoney(1_000_000);

    public static final Card ACE_SCORE = Card.fromFaceAndSuit(ACE, CLUB);
    public static final Card TWO_SCORE = Card.fromFaceAndSuit(TWO, CLUB);
    public static final Card THREE_SCORE = Card.fromFaceAndSuit(THREE, CLUB);
    public static final Card FOUR_SCORE = Card.fromFaceAndSuit(FOUR, CLUB);
    public static final Card FIVE_SCORE = Card.fromFaceAndSuit(FIVE, CLUB);
    public static final Card SIX_SCORE = Card.fromFaceAndSuit(SIX, CLUB);
    public static final Card SEVEN_SCORE = Card.fromFaceAndSuit(SEVEN, CLUB);
    public static final Card TEN_SCORE = Card.fromFaceAndSuit(JACK, SPADE);

    public static final List<Card> BUSTED_CARDS = Arrays.asList(TEN_SCORE, TEN_SCORE, TWO_SCORE);
    public static final List<Card> BUSTED_BY_ACE_CARDS = Arrays.asList(TEN_SCORE, TEN_SCORE, ACE_SCORE, ACE_SCORE);
    public static final List<Card> BLACKJACK_CARDS = Arrays.asList(TEN_SCORE, ACE_SCORE);
    public static final List<Card> MAX_SCORE_CARDS = Arrays.asList(TEN_SCORE, TEN_SCORE, ACE_SCORE);
    public static final List<Card> DEALER_HITTABLE_LOWER_BOUND_CARDS = Arrays.asList(TWO_SCORE, TWO_SCORE);
    public static final List<Card> DEALER_HITTABLE_UPPER_BOUND_CARDS = Arrays.asList(TEN_SCORE, SIX_SCORE);
    public static final List<Card> DEALER_NOT_HITTABLE_LOWER_BOUND_CARDS = Arrays.asList(TEN_SCORE, SEVEN_SCORE);

    public static final Hand HITTABLE_LOW_HAND = createHand(DEALER_HITTABLE_LOWER_BOUND_CARDS);
    public static final Hand HITTABLE_HIGH_HAND = createHand(DEALER_HITTABLE_UPPER_BOUND_CARDS);
    public static final Hand BLACKJACK_HAND = createHand(BLACKJACK_CARDS);
    public static final Hand BUSTED_HAND = createHand(BUSTED_CARDS);

    public static final HandState HITTABLE_HAND_STATE = createHandState(DEALER_HITTABLE_UPPER_BOUND_CARDS);

    public static Hand createHand(List<Card> cards) {
        Hand hand = new Hand();
        for (final Card card : cards) {
            hand.draw(card);
        }
        return hand;
    }

    public static HandState createHandState(List<Card> cards) {
        HandState handState = new ReadyState();
        for (final Card card : cards) {
            handState = handState.draw(card);
        }
        return handState;
    }
}
