package domain.participant.hand;

import java.math.BigDecimal;

public abstract class NotFinishedState extends StartedState {
    public NotFinishedState(final Hand hand) {
        super(hand);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean isBlackjack() {
        return false;
    }

    @Override
    public boolean isBusted() {
        return false;
    }

    @Override
    public HandState stay() {
        return new StayState(hand);
    }

    @Override
    public BigDecimal calculateProfit(final BigDecimal money) {
        throw new UnsupportedOperationException("수익을 계산할 수 없는 상태입니다.");
    }
}
