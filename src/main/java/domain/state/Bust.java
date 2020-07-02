package domain.state;

import domain.gamer.Hand;

public class Bust extends Finished {
	public Bust(Hand hand) {
		super(hand);
	}

	@Override
	public boolean isWin(State state) {
		return false;
	}

	@Override
	public boolean isSameResult(State state) {
		return state instanceof Bust;
	}

	@Override
	public double getEarningRate() {
		return 0;
	}
}
