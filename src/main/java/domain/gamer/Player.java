package domain.gamer;

import domain.card.deck.Deck;
import domain.state.State;
import domain.state.StateFactory;

public class Player extends Gamer {
	private final BattingMoney battingMoney;

	private Player(Name name, State state, BattingMoney battingMoney) {
		super(name, state);
		this.battingMoney = battingMoney;
	}

	public static Player of(String name, Deck deck, int battingMoney) {
		return new Player(new Name(name), StateFactory.create(deck), new BattingMoney(battingMoney));
	}

	public int calculateEarning(Dealer dealer) {
		if (state.isSameResult(dealer.state)) {
			return 0;
		}
		if (state.isWin(dealer.state)) {
			return (int)(battingMoney.getMoney() * state.getEarningRate());
		}
		return -1 * battingMoney.getMoney();
	}

	@Override
	public boolean canHit() {
		return !state.isFinished();
	}
}
