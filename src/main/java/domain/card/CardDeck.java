package domain.card;

import java.util.List;

public interface CardDeck {
    Card pick();

    List<Card> pick(final int count);
}
