package domain.participant.hand;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    protected abstract BigDecimal getProfitRate();
}
