package domain.card;

public enum Suit {
	CLUB("♣"),
	DIAMOND("♦"),
	HEART("♥"),
	SPADE("♠");

	private final String pattern;

	Suit(String pattern) {
		this.pattern = pattern;
	}

	public String getPattern() {
		return pattern;
	}
}
