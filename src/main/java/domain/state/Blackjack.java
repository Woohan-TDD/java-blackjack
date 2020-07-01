package domain.state;

import domain.card.Hands;

public class Blackjack extends Finished {

    public Blackjack(Hands hands) {
        super(hands);
    }

    @Override
    public double earningRate() {
        return 1.5;
    }
}
