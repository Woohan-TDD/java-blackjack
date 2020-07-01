package domain.state;

import domain.card.Card;
import domain.card.Hands;

public abstract class Finished extends Started {

    public Finished(Hands hands) {
        super(hands);
    }

    public abstract double earningRate();

    @Override
    public State draw(Card card) {
        throw new UnsupportedOperationException();
    }

    @Override
    public State stay() {
        throw new UnsupportedOperationException();
    }

    @Override
    public double profit(int money) {
        return earningRate() * money;
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
