package domain.participant.hand;

import java.math.BigDecimal;

import domain.card.Card;

public interface HandState {
    HandState draw(final Card card);

    HandState stay();

    boolean isFinished();

    boolean isBlackjack();

    boolean isBusted();

    boolean isOver(final int score);

    int calculateScore();

    BigDecimal calculateProfit(final BigDecimal money);

    Hand getHand();
}
