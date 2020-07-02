package domain.state;

import domain.gamer.Hand;

public class Stay extends Finished {
	private static final int NORMAL_RATE = 1;

	public Stay(Hand hand) {
		super(hand);
	}

	@Override
	public boolean isWin(State state) {
		if (state instanceof Stay) {
			return calculateScore() > state.calculateScore();
		}
		return !state.isWin(this);
	}

	@Override
	public boolean isSameResult(State state) {
		return state instanceof Stay && calculateScore() == state.calculateScore();
	}

	@Override
	public double getEarningRate() {
		return NORMAL_RATE;
	}
}
