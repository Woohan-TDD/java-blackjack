package domain.state;

import domain.card.Hands;

public class Stay extends Finished {

    public Stay(Hands hands) {
        super(hands);
    }

    @Override
    public double earningRate() {
        return 1;
    }
}
