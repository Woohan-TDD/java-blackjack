package domain.participant.hand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.card.Card;

public class Hand {
    private static final int INITIAL_CARD_SIZE = 2;
    private static final int MAX_SCORE = 21;
    private static final int ACE_UPGRADABLE_SCORE_UPPER_BOUND = 11;
    private static final int ACE_UPGRADE_SCORE = 10;

    private final List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void draw(final Card card) {
        cards.add(card);
    }

    public boolean isBlackjack() {
        return isInitialDraw() && isMaxScore();
    }

    public boolean isMaxScore() {
        return calculateScore() == MAX_SCORE;
    }

    public boolean isBust() {
        return calculateScore() > MAX_SCORE;
    }

    public int calculateScore() {
        int score = calculateMaxScore();
        return upgradeIfHasAce(score);
    }

    public int size() {
        return cards.size();
    }

    private int calculateMaxScore() {
        return cards.stream()
                .mapToInt(card -> card.getFace().getScore())
                .sum();
    }

    private int upgradeIfHasAce(final int score) {
        if (hasAce() && isAceUpgradableScore(score)) {
            return score + ACE_UPGRADE_SCORE;
        }
        return score;
    }

    private boolean hasAce() {
        return cards.stream()
                .anyMatch(Card::isAce);
    }

    private boolean isAceUpgradableScore(final int score) {
        return score <= ACE_UPGRADABLE_SCORE_UPPER_BOUND;
    }

    public boolean isInitialDraw() {
        return cards.size() == INITIAL_CARD_SIZE;
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }
}
