package domain.participant.hand;

import java.math.BigDecimal;

public class BustedState extends FinishedState {
    private static final BigDecimal PROFIT_RATE = BigDecimal.valueOf(-1);

    public BustedState(final Hand hand) {
        super(hand);
    }

    @Override
    protected BigDecimal getProfitRate() {
        return PROFIT_RATE;
    }
}
