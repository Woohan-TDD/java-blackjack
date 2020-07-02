package domain.state;

import domain.card.deck.Deck;
import domain.gamer.Hand;

public abstract class Finished extends GamerState {
	public Finished(Hand hand) {
		super(hand);
	}

	@Override
	public State hit(Deck deck) {
		throw new UnsupportedOperationException();
	}

	@Override
	public State stay() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
