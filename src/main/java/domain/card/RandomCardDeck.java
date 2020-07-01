package domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class RandomCardDeck implements CardDeck {
    private final Stack<Card> cards;

    public RandomCardDeck(final List<Card> cards) {
        validate(cards);
        Stack<Card> shuffledCards = new Stack<>();
        shuffledCards.addAll(cards);
        Collections.shuffle(shuffledCards);
        this.cards = shuffledCards;
    }

    @Override
    public Card pick() {
        return cards.pop();
    }

    @Override
    public List<Card> pick(final int amount) {
        List<Card> pickedCards = new ArrayList<>();
        for (int count = 0; count < amount; ++count) {
            pickedCards.add(pick());
        }
        return pickedCards;
    }

    private void validate(final List<Card> cards) {
        Objects.requireNonNull(cards, "카드 리스트가 null입니다.");
        if (cards.isEmpty()) {
            throw new IllegalArgumentException("카드 리스트의 크기가 0입니다.");
        }
    }
}
