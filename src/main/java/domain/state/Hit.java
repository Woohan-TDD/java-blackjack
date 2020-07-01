package domain.state;

import domain.card.Card;
import domain.card.Hands;

public class Hit extends Running {

    public Hit(Hands hands) {
        super(hands);
    }

    @Override
    public State draw(Card card) {
        hands.add(card);
        if (hands.isBust()) {
            return new Bust(hands);
        }
        return new Hit(hands);
    }

    @Override
    public State stay() {
        return new Stay(hands);
    }
}
