package domain.card;

import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards;

    public Deck() {
        cards = CardFactory.create();
        Collections.shuffle(cards);
    }

    public Card deal() {
        return cards.remove(0);
    }
}