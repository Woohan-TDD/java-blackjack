package domain.state;

import domain.card.Card;
import domain.card.Hands;

public class StateFactory {

    public static State drawFirst(Card firstCard, Card secondCard) {
        Hands hands = new Hands();
        hands.add(firstCard);
        hands.add(secondCard);
        if (hands.isBlackjack()) {
            return new Blackjack(hands);
        }
        return new Hit(hands);
    }
}
