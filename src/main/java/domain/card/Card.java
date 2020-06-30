package domain.card;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Card {
    private final Face face;
    private final Suit suit;

    Card(final Face face, final Suit suit) {
        this.face = Objects.requireNonNull(face, "face가 null입니다.");
        this.suit = Objects.requireNonNull(suit, "suit가 null입니다.");
    }

    public static List<Card> values() {
        return Collections.unmodifiableList(CardCache.values());
    }

    public boolean isAce() {
        return face.isAce();
    }

    public Face getFace() {
        return face;
    }

    public Suit getSuit() {
        return suit;
    }

    private static class CardCache {
        private static final List<Card> cache;

        static {
            cache = Stream.of(Face.values())
                    .flatMap(CardCache::createByFace)
                    .collect(toList());
        }

        private static Stream<Card> createByFace(final Face face) {
            return Stream.of(Suit.values())
                    .map(suit -> new Card(face, suit));
        }

        public static List<Card> values() {
            return cache;
        }
    }
}
