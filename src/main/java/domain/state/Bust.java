package domain.state;

import domain.card.Hands;

public class Bust extends Finished {

    public Bust(Hands hands) {
        super(hands);
    }

    @Override
    public double earningRate() {
        return -1;
    }
}
