package domain.user;

import domain.BettingMoney;

import java.util.Objects;

public class Player extends Participant {
    private final Name name;
    private final BettingMoney bettingMoney;

    public Player(final Name name, final BettingMoney bettingMoney) {
        Objects.requireNonNull(name, "null 비허용");
        Objects.requireNonNull(bettingMoney, "null 비허용");
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    public String getName() {
        return name.getName();
    }

    public double getBettingMoney() {
        return bettingMoney.getBettingMoney();
    }
}