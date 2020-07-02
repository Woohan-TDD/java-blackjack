package domain.card;

public enum Suit {
    SPADE("♠️"),
    HEART("❤️"),
    DIAMOND("♦️"),
    CLUB("♣️");

    private final String alias;

    Suit(final String alias) {
        this.alias = alias;
    }

    public String alias() {
        return alias;
    }
}
