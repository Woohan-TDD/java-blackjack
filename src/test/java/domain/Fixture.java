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

public class Fixture {
    public static final List<Card> CARDS = Card.values();

    public static final Name POBI = new Name("Pobi");
    public static final Name JUN = new Name("Jun");

    public static final BettingMoney THOUSAND_BETTING_MONEY = new BettingMoney(1_000);
    public static final BettingMoney HUNDRED_BETTING_MONEY = new BettingMoney(1_000_000);

    public static final Card ACE_SCORE = Card.fromFaceAndSuit(ACE, CLUB);
    public static final Card TWO_SCORE = Card.fromFaceAndSuit(TWO, CLUB);
    public static final Card THREE_SCORE = Card.fromFaceAndSuit(THREE, CLUB);
    public static final Card FOUR_SCORE = Card.fromFaceAndSuit(FOUR, CLUB);
    public static final Card FIVE_SCORE = Card.fromFaceAndSuit(FIVE, CLUB);
    public static final Card SIX_SCORE = Card.fromFaceAndSuit(SIX, CLUB);
    public static final Card SEVEN_SCORE = Card.fromFaceAndSuit(SEVEN, CLUB);
    public static final Card EIGHT_SCORE = Card.fromFaceAndSuit(SEVEN, CLUB);
    public static final Card NINE_SCORE = Card.fromFaceAndSuit(SEVEN, CLUB);
    public static final Card TEN_SCORE = Card.fromFaceAndSuit(JACK, SPADE);

    public static final List<Card> BUSTED_CARDS = Arrays.asList(TEN_SCORE, TEN_SCORE, TWO_SCORE);
    public static final List<Card> BUSTED_BY_ACE_CARDS = Arrays.asList(TEN_SCORE, TEN_SCORE, ACE_SCORE, ACE_SCORE);
    public static final List<Card> BLACKJACK_CARDS = Arrays.asList(TEN_SCORE, ACE_SCORE);
    public static final List<Card> MAX_SCORE_CARDS = Arrays.asList(TEN_SCORE, TEN_SCORE, ACE_SCORE);
    public static final List<Card> DEALER_HITTABLE_UPPER_BOUND_CARDS = Arrays.asList(TEN_SCORE, SIX_SCORE);
    public static final List<Card> DEALER_NOT_HITTABLE_LOWER_BOUND_CARDS = Arrays.asList(TEN_SCORE, SEVEN_SCORE);

    public static Hand createHand(List<Card> cards) {
        Hand hand = new Hand();
        for (final Card card : cards) {
            hand.draw(card);
        }
        return hand;
    }
}
