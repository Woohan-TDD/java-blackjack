package domain.participant.hand;

import java.math.BigDecimal;

import domain.card.Card;

public interface HandState {
    default HandState draw(final Card card) {
        throw new UnsupportedOperationException("hit을 할 수 없는 상태입니다.");
    }

    default HandState stay() {
        throw new UnsupportedOperationException("stay를 할 수 없는 상태입니다.");
    }

    boolean isFinished();

    default boolean isOver(final int score) {
        return calculateScore() > score;
    }

    int calculateScore();

    default BigDecimal calculateProfit(final BigDecimal money) {
        throw new UnsupportedOperationException("수익을 계산할 수 없는 상태입니다.");
    }

    Hand getHand();
}
