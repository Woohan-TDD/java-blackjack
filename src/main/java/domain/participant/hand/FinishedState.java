package domain.participant.hand;

import java.math.BigDecimal;
import java.math.RoundingMode;

import domain.card.Card;

public abstract class FinishedState extends StartedState {
    public FinishedState(final Hand hand) {
        super(hand);
    }

    @Override
    public BigDecimal calculateProfit(final BigDecimal money) {
        return money.multiply(getProfitRate())
                .setScale(0, RoundingMode.HALF_UP);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public HandState draw(final Card card) {
        throw new UnsupportedOperationException("hit을 할 수 없는 상태입니다.");
    }

    @Override
    public HandState stay() {
        throw new UnsupportedOperationException("stay를 할 수 없는 상태입니다.");
    }

    protected abstract BigDecimal getProfitRate();
}
