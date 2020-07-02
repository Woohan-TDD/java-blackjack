package domain.card;

public class EmptyCardDeckException extends RuntimeException {
    public EmptyCardDeckException(final String message) {
        super(message);
    }
}
