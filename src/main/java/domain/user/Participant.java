package domain.user;

import domain.card.Card;
import domain.state.State;
import domain.state.StateFactory;

import java.util.Collections;
import java.util.List;

public abstract class Participant {

    //    protected final Hands hands;
    protected State state;

    public void draw(final Card card) {
        state = state.draw(card);
    }

    public void drawFirst(Card firstCard, Card secondCard) {
        state = StateFactory.drawFirst(firstCard, secondCard);
    }

    public abstract boolean canDrawCard();

    public List<Card> getHands() {
        return Collections.unmodifiableList(state.hands().getCards());
    }
}
