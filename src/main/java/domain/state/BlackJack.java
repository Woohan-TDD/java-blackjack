package domain.state;

import domain.gamer.Hand;

public class BlackJack extends Finished {
	private static final double BLACKJACK_RATE = 1.5;

	public BlackJack(Hand hand) {
		super(hand);
	}

	@Override
	public boolean isWin(State state) {
		return !isSameResult(state);
	}

	@Override
	public boolean isSameResult(State state) {
		return state instanceof BlackJack;
	}

	@Override
	public double getEarningRate() {
		return BLACKJACK_RATE;
	}
}
