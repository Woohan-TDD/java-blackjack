package domain.participant;

import java.util.Objects;

import domain.Name;
import domain.card.Card;
import domain.participant.hand.FinishedState;
import domain.participant.hand.HandState;

public abstract class Participant {
    private final Name name;
    HandState hand;

    public Participant(final Name name, final HandState hand) {
        this.name = Objects.requireNonNull(name, "name이 null입니다.");
        this.hand = Objects.requireNonNull(hand, "handState가 null입니다.");
    }

    public void hit(final Card card) {
        hand = hand.draw(card);
    }

    public void stay() {
        hand = hand.stay();
    }

    public boolean isFinished() {
        return hand.isFinished();
    }

    public boolean isBusted() {
        if (!isFinished()) {
            return false;
        }
        FinishedState state = (FinishedState)hand;
        return state.isBusted();
    }

    public boolean isBlackjack() {
        if (!isFinished()) {
            return false;
        }
        FinishedState state = (FinishedState)hand;
        return state.isBlackjack();
    }

    public int compareScore(final Participant that) {
        return Integer.compare(calculateScore(), that.calculateScore());
    }

    private int calculateScore() {
        return hand.calculateScore();
    }

    public Name getName() {
        return name;
    }

    public HandState getHandState() {
        return hand;
    }
}
