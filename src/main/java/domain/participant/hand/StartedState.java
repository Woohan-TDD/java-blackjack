package domain.participant.hand;

public abstract class StartedState implements HandState {
    protected final Hand hand;

    public StartedState(final Hand hand) {
        this.hand = hand;
    }

    @Override
    public int calculateScore() {
        return hand.calculateScore();
    }

    @Override
    public Hand getHand() {
        return hand;
    }
}
