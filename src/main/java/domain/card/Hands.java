package domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hands {
    public static final int TEN = 10;
    public static final int ELEVEN = 11;
    private final List<Card> cards;

    public Hands() {
        this.cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public void add(final Card card) {
        cards.add(card);
    }

    public boolean isBust() {
        return false;
    }

    public int sum() {
        int sum = cards.stream()
                .mapToInt(Card::getScore)
                .sum();
        if (isAceOne(sum)) {
            return sum;
        }
        return sum + TEN;
    }

    private boolean isAceOne(int sum) {
        return isAceExist() && sum > ELEVEN;
    }

    private boolean isAceExist() {
        return cards.stream()
                .anyMatch(Card::isAce);
    }
}
