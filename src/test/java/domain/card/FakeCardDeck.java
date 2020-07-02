package domain.card;

import java.util.List;
import java.util.Stack;

public class FakeCardDeck implements CardDeck {
    private final Stack<Card> cards;

    public FakeCardDeck(final List<Card> cards) {
        Stack<Card> stackedCards = new Stack<>();
        stackedCards.addAll(cards);
        this.cards = stackedCards;
    }

    @Override
    public Card pick() {
        if (cards.isEmpty()) {
            throw new EmptyCardDeckException("카드를 모두 소모하여 더 뽑을 수 없습니다.");
        }
        return cards.pop();
    }
}
