package dto;

public class PlayerInfo {
	private String name;
	private int battingMoney;

	public PlayerInfo(String name, int battingMoney) {
		this.name = name;
		this.battingMoney = battingMoney;
	}

	public String getName() {
		return name;
	}

	public int getBattingMoney() {
		return battingMoney;
	}
}
