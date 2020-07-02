package domain;

import java.math.BigDecimal;

public class BettingMoney {
    private static final int MIN_AMOUNT = 100;
    private static final int BETTING_UNIT = 100;

    private final BigDecimal amount;

    public BettingMoney(final int amount) {
        validate(amount);
        this.amount = BigDecimal.valueOf(amount);
    }

    private void validate(final int amount) {
        validateRange(amount);
        validateUnit(amount);
    }

    private void validateRange(final int amount) {
        if (amount < MIN_AMOUNT) {
            throw new IllegalArgumentException("베팅 최소 금액을 충족하지 못했습니다.\n"
                    + "amount: " + amount);
        }
    }

    private void validateUnit(final int amount) {
        if (amount % BETTING_UNIT != 0) {
            throw new IllegalArgumentException("금액의 단위가 올바르지 않습니다.\n"
                    + "amount: " + amount);
        }
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
