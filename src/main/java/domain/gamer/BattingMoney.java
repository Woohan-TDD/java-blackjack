package domain.gamer;

public class BattingMoney {
	private final int money;

	public BattingMoney(int money) {
		validate(money);
		this.money = money;
	}

	private void validate(int money) {
		if (money < 0) {
			throw new IllegalArgumentException("음수는 허용되지 않습니다. input : " + money);
		}
	}

	public int getMoney() {
		return money;
	}
}
