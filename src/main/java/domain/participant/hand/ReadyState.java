package domain.participant.hand;

import domain.card.Card;

public class ReadyState extends NotFinishedState {
    public ReadyState() {
        super(new Hand());
    }

    @Override
    public HandState draw(final Card card) {
        hand.draw(card);
        if (hand.isBlackjack()) {
            return new BlackjackState(hand);
        }
        if (hand.isInitialDraw()) {
            return new HitState(hand);
        }
        return this;
    }
}
