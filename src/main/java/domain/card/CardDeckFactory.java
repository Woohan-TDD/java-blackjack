package domain.card;

public class CardDeckFactory {
    private CardDeckFactory() {
        throw new AssertionError();
    }

    public static CardDeck createRandomCardDeck() {
        return new RandomCardDeck(Card.values());
    }
}
