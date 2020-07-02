package domain.participant;

import java.math.BigDecimal;
import java.util.Objects;

import domain.BettingMoney;
import domain.Name;
import domain.participant.hand.HandState;

public class Player extends Participant {
    private final BettingMoney bettingMoney;

    public Player(final Name name, final HandState handState, final BettingMoney bettingMoney) {
        super(name, handState);
        this.bettingMoney = Objects.requireNonNull(bettingMoney, "bettingMoney가 null입니다.");
    }

    public BigDecimal calculateProfit() {
        return hand.calculateProfit(bettingMoney.getAmount());
    }

    public BigDecimal getBettingMoney() {
        return bettingMoney.getAmount();
    }
}
