package domain.participant.hand;

public class HandStateFactory {
    private HandStateFactory() {
        throw new AssertionError();
    }

    public static HandState createFromInitialHand(final Hand hand) {
        if (hand.isBlackjack()) {
            return new BlackjackState(hand);
        }
        return new HitState(hand);
    }
}
