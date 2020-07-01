package domain.user;

import domain.card.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class Participant {

    protected final List<Card> cards = new ArrayList<>();

    public void addCard(final Card card) {
        cards.add(card);
    }
}
