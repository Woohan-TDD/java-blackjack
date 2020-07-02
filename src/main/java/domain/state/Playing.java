package domain.state;

import domain.card.deck.Deck;
import domain.gamer.Hand;

public class Playing extends GamerState {
	public Playing(Hand hand) {
		super(hand);
	}

	@Override
	public State hit(Deck deck) {
		hand.add(deck.pop());
		if (hand.isBust()) {
			return new Bust(hand);
		}
		return new Playing(hand);
	}

	@Override
	public State stay() {
		return new Stay(hand);
	}

	@Override
	public boolean isFinished() {
		return false;
	}

	@Override
	public boolean isWin(State state) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isSameResult(State state) {
		 throw new UnsupportedOperationException();
	}

	@Override
	public double getEarningRate() {
		throw new UnsupportedOperationException();
	}
}
