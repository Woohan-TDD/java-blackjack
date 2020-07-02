package domain.result;

import java.math.BigDecimal;

import domain.participant.Participant;

public class ParticipantProfit {
    private final String name;
    private final BigDecimal profit;

    public ParticipantProfit(final Participant participant, final BigDecimal profit) {
        this.name = participant.getName();
        this.profit = profit;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getProfit() {
        return profit;
    }
}
