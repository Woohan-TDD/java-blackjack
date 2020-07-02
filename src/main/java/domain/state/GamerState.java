package domain.state;

import java.util.Collections;
import java.util.List;

import domain.card.Card;
import domain.gamer.Hand;

public abstract class GamerState implements State {
	protected final Hand hand;

	public GamerState(Hand hand) {
		this.hand = hand;
	}

	@Override
	public List<Card> getCards() {
		return Collections.unmodifiableList(hand.getCards());
	}

	public int calculateScore() {
		return hand.calculateScore();
	}

}
