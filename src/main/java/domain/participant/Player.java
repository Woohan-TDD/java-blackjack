package domain.participant;

import java.util.Objects;

import domain.BettingMoney;
import domain.Name;

public class Player {
    private final Name name;
    private final BettingMoney bettingMoney;

    public Player(final Name name, final BettingMoney bettingMoney) {
        this.name = Objects.requireNonNull(name, "name이 null입니다.");
        this.bettingMoney = Objects.requireNonNull(bettingMoney, "bettingMoney가 null입니다.");
    }
}
