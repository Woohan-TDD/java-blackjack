package domain;

public class BettingMoney {

    public static final int MIN_BETTING_MONEY = 1;
    private final double bettingMoney;

    public BettingMoney(final double bettingMoney) {
        validate(bettingMoney);
        this.bettingMoney = bettingMoney;
    }

    private void validate(final double bettingMoney) {
        if (bettingMoney < MIN_BETTING_MONEY) {
            throw new IllegalArgumentException("배팅금액은 1원 이상이어야 합니다. 입력금액 : " + bettingMoney);
        }
    }

    public double getBettingMoney() {
        return bettingMoney;
    }
}
