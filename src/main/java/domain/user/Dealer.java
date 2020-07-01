package domain.user;

public class Dealer extends Participant {

    public Dealer() {
    }

    @Override
    public boolean canDrawCard() {
        return !state.hands().isDealerBust();
    }
}
