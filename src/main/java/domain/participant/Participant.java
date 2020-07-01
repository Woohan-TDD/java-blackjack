package domain.participant;

import java.util.Objects;

import domain.Name;
import domain.card.Card;
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

    public Name getName() {
        return name;
    }

    public HandState getHandState() {
        return hand;
    }
}
