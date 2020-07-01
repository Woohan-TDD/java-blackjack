package domain.state;

import domain.card.Hands;

public abstract class Running extends Started {

    public Running(Hands hands) {
        super(hands);
    }

    @Override
    public double profit(int money) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
