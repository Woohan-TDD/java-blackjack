package domain.gamer;

import java.util.List;

import domain.card.Card;
import domain.card.deck.Deck;
import domain.state.State;
import domain.state.StateFactory;

public class Dealer extends Gamer {
	private static final int HIT_THRESHOLD = 17;

	private Dealer(State state) {
		super(new Name("딜러"), state);
	}

	public static Dealer of(Deck deck) {
		return new Dealer(StateFactory.create(deck));
	}

	@Override
	public boolean canHit() {
		return !state.isFinished() && state.calculateScore() < HIT_THRESHOLD;
	}

	public int calculateEarning(Players players) {
		return -1 * players.calculateTotalEarning(this);
	}

	public List<Card> getOneCards() {
		return getState().getCards().subList(0, 1);
	}
}
