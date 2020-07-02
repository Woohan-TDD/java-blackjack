package domain.participant.hand;

import domain.card.Card;

public class HitState extends NotFinishedState {
    public HitState(final Hand hand) {
        super(hand);
    }

    @Override
    public HandState draw(final Card card) {
        hand.draw(card);
        if (hand.isMaxScore()) {
            return new StayState(hand);
        }
        if (hand.isBust()) {
            return new BustedState(hand);
        }
        return new HitState(hand);
    }
}
