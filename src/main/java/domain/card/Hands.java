package domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static domain.Game.FIRST_DRAW_NUMBER;

public class Hands {
    public static final int TEN = 10;
    public static final int ELEVEN = 11;
    public static final int BLACKJACK = 21;
    public static final int DEALER_BUST_NUMBER = 17;

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
        return sum() > BLACKJACK;
    }

    public int sum() {
        int sum = cards.stream()
                .mapToInt(Card::getScore)
                .sum();
        if (isAceNotExist() || isAceOne(sum)) {
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

    private boolean isAceNotExist() {
        return !isAceExist();
    }

    public boolean isBlackjack() {
        return cards.size() == FIRST_DRAW_NUMBER && sum() == BLACKJACK;
    }

    public boolean isDealerBust() {
        return sum() >= DEALER_BUST_NUMBER;
    }
}
