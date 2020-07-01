package domain.user;

import domain.card.Card;
import domain.card.Hands;

import java.util.Collections;
import java.util.List;

public abstract class Participant {

    protected final Hands hands;

    public Participant() {
        this.hands = new Hands();
    }

    public void draw(final Card card) {
        hands.add(card);
    }

    public List<Card> getHands() {
        return Collections.unmodifiableList(hands.getCards());
    }
}
