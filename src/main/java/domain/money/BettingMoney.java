package domain.money;

public class BettingMoney {

    public static final int MIN_BETTING_MONEY = 1;

    private final int bettingMoney;

    public BettingMoney(final int bettingMoney) {
        validate(bettingMoney);
        this.bettingMoney = bettingMoney;
    }

    private void validate(final int bettingMoney) {
        if (bettingMoney < MIN_BETTING_MONEY) {
            throw new IllegalArgumentException("배팅금액은 1원 이상이어야 합니다. 입력금액 : " + bettingMoney);
        }
    }

    public int getBettingMoney() {
        return bettingMoney;
    }
}
