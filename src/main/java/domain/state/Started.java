package domain.state;

import domain.card.Hands;

public abstract class Started implements State {

    protected final Hands hands;

    public Started(Hands hands) {
        this.hands = hands;
    }

    public Hands hands() {
        return this.hands;
    }
}
