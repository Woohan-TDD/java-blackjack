package domain.participant;

import java.util.Objects;

import domain.Name;
import domain.card.CardDeck;
import domain.participant.hand.Hand;
import domain.participant.hand.HandState;
import domain.participant.hand.ReadyState;

public abstract class Participant {
    public static final int INITIAL_DRAW_CARDS = 2;

    private final Name name;
    HandState hand;

    public Participant(final Name name) {
        this(name, new ReadyState());
    }

    public Participant(final Name name, final HandState hand) {
        this.name = Objects.requireNonNull(name, "name이 null입니다.");
        this.hand = Objects.requireNonNull(hand, "handState가 null입니다.");
    }

    public void hitAtFirst(final CardDeck cardDeck) {
        for (int count = 0; count < INITIAL_DRAW_CARDS; count++) {
            hit(cardDeck);
        }
    }

    public void hit(final CardDeck cardDeck) {
        hand = hand.draw(cardDeck.pick());
    }

    public void stay() {
        hand = hand.stay();
    }

    public boolean isFinished() {
        return hand.isFinished();
    }

    public boolean isBusted() {
        return hand.isBusted();
    }

    public boolean isBlackjack() {
        return hand.isBlackjack();
    }

    public int compareScore(final Participant that) {
        return Integer.compare(calculateScore(), that.calculateScore());
    }

    private int calculateScore() {
        return hand.calculateScore();
    }

    public String getName() {
        return name.getName();
    }

    public Hand getHand() {
        return hand.getHand();
    }
}
