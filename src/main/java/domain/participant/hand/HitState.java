package domain.participant.hand;

import domain.card.Card;

public class HitState extends StartedState {
    public HitState(final Hand hand) {
        super(hand);
    }

    @Override
    public HandState draw(final Card card) {
        hand.draw(card);
        if (hand.isBust()) {
            return new BustedState(hand);
        }
        return new HitState(hand);
    }

    @Override
    public HandState stay() {
        return new StayState(hand);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
