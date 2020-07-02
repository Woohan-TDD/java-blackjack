package domain.participant;

import domain.Name;
import domain.card.CardDeck;
import domain.participant.hand.HandState;

public class Dealer extends Participant {
    private static final Name NAME = new Name("딜러");
    private static final int DEALER_HITTABLE_UPPER_BOUND = 16;

    public Dealer() {
        super(NAME);
    }

    public Dealer(final HandState hand) {
        super(NAME, hand);
    }

    @Override
    public void hit(final CardDeck cardDeck) {
        super.hit(cardDeck);
        if (!hand.isFinished() && hand.isOver(DEALER_HITTABLE_UPPER_BOUND)) {
            stay();
        }
    }
}
