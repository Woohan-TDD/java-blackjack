package domain.card;

import java.util.ArrayList;
import java.util.List;

public class CardFactory {

    public static List<Card> create() {
        List<Card> cards = new ArrayList<>();
        Symbol[] symbols = Symbol.values();
        for (Symbol symbol : symbols) {
            createByType(cards, symbol);
        }
        return cards;
    }

    private static void createByType(final List<Card> cards, final Symbol symbol) {
        Type[] types = Type.values();
        for (Type type : types) {
            cards.add(new Card(symbol, type));
        }
    }
}