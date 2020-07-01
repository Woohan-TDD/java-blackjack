package domain.card;

public class CardNotFoundException extends RuntimeException {
    public CardNotFoundException(final String message) {
        super(message);
    }
}
