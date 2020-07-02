package domain.card;

public enum Face {
    ACE(1, "A"),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10, "J"),
    QUEEN(10, "Q"),
    KING(10, "K");

    private final int score;
    private final String alias;

    Face(final int score) {
        this.score = score;
        this.alias = String.valueOf(score);
    }

    Face(final int score, final String alias) {
        this.score = score;
        this.alias = alias;
    }

    public boolean isAce() {
        return this == ACE;
    }

    public int getScore() {
        return score;
    }

    public String alias() {
        return alias;
    }
}
