package domain.user;

import domain.card.Card;
import domain.card.Hands;
import domain.state.State;
import domain.state.StateFactory;

public abstract class Participant {

    protected State state;

    public void draw(final Card card) {
        state = state.draw(card);
    }

    public void drawFirst(Card firstCard, Card secondCard) {
        state = StateFactory.drawFirst(firstCard, secondCard);
    }

    public void stay() {
        state = state.stay();
    }

    public abstract boolean canDrawCard();

    public Hands getHands() {
        return state.hands();
    }
}
