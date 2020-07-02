package domain.card;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Card {
    private final Face face;
    private final Suit suit;

    private Card(final Face face, final Suit suit) {
        this.face = face;
        this.suit = suit;
    }

    public static Card fromFaceAndSuit(final Face face, final Suit suit) {
        return CardCache.cache
                .stream()
                .filter(card -> card.isCardOf(face, suit))
                .findFirst()
                .orElseThrow(() -> new CardNotFoundException("카드가 존재하지 않습니다.\n"
                        + "face: " + face + "\n"
                        + "suit: " + suit));
    }

    public static List<Card> values() {
        return Collections.unmodifiableList(CardCache.cache);
    }

    public boolean isAce() {
        return face.isAce();
    }

    public boolean isCardOf(final Face face, final Suit suit) {
        return this.face == face && this.suit == suit;
    }

    public Face getFace() {
        return face;
    }

    public Suit getSuit() {
        return suit;
    }

    public String alias() {
        return suit.alias() + face.alias();
    }

    private static class CardCache {
        public static final List<Card> cache;

        static {
            cache = Stream.of(Face.values())
                    .flatMap(CardCache::createByFace)
                    .collect(toList());
        }

        private static Stream<Card> createByFace(final Face face) {
            return Stream.of(Suit.values())
                    .map(suit -> new Card(face, suit));
        }
    }
}
