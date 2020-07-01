package domain.participant;

import domain.Name;
import domain.card.Card;
import domain.participant.hand.HandState;

public class Dealer extends Participant {
    private static final Name NAME = new Name("딜러");
    private static final int DEALER_HITTABLE_UPPER_BOUND = 16;

    public Dealer(final HandState hand) {
        super(NAME, hand);
    }

    @Override
    public void hit(final Card card) {
        super.hit(card);
        if (hand.isOver(DEALER_HITTABLE_UPPER_BOUND)) {
            stay();
        }
    }
}
