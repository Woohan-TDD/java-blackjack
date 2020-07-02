package domain.card;

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
        if (cards.isEmpty()) {
            throw new EmptyCardDeckException("카드를 모두 소모하여 더 뽑을 수 없습니다.");
        }
        return cards.pop();
    }

    private void validate(final List<Card> cards) {
        Objects.requireNonNull(cards, "카드 리스트가 null입니다.");
        if (cards.isEmpty()) {
            throw new IllegalArgumentException("카드 리스트의 크기가 0입니다.");
        }
    }
}
