package domain.user;

import domain.BettingMoney;

import java.util.Objects;

public class Player extends Participant {

    private final BettingMoney bettingMoney;
    private final Name name;

    public Player(final Name name, final BettingMoney bettingMoney) {
        Objects.requireNonNull(name, "null 비허용");
        Objects.requireNonNull(bettingMoney, "null 비허용");
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    @Override
    public boolean canDrawCard() {
        return !state.hands().isBust();
    }

    public String getName() {
        return name.getName();
    }

    public double getBettingMoney() {
        return bettingMoney.getBettingMoney();
    }
}