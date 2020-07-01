package domain.participant.hand;

import java.math.BigDecimal;

public class StayState extends FinishedState {
    private static final BigDecimal PROFIT_RATE = BigDecimal.valueOf(1);

    public StayState(final Hand hand) {
        super(hand);
    }

    @Override
    protected BigDecimal getProfitRate() {
        return PROFIT_RATE;
    }
}
