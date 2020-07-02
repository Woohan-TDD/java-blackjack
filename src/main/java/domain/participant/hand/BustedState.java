package domain.participant.hand;

import java.math.BigDecimal;

public class BustedState extends FinishedState {
    private static final BigDecimal PROFIT_RATE = BigDecimal.valueOf(-1);

    public BustedState(final Hand hand) {
        super(hand);
    }

    @Override
    public boolean isBlackjack() {
        return false;
    }

    @Override
    public boolean isBusted() {
        return true;
    }

    @Override
    protected BigDecimal getProfitRate() {
        return PROFIT_RATE;
    }
}
