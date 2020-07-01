package domain.participant.hand;

import java.math.BigDecimal;

public class BlackjackState extends FinishedState {
    private static final BigDecimal PROFIT_RATE = BigDecimal.valueOf(1.5);

    public BlackjackState(final Hand hand) {
        super(hand);
    }

    @Override
    public boolean isBlackjack() {
        return true;
    }

    @Override
    protected BigDecimal getProfitRate() {
        return PROFIT_RATE;
    }
}
