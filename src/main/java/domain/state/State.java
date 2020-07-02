package domain.state;

import java.util.List;

import domain.card.Card;
import domain.card.deck.Deck;

public interface State {
	State hit(Deck deck);

	State stay();

	int calculateScore();

	boolean isFinished();

	boolean isWin(State state);

	boolean isSameResult(State state);

	double getEarningRate();

	List<Card> getCards();
}
