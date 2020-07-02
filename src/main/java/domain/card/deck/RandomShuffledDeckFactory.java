package domain.card.deck;

import java.util.Collections;
import java.util.List;

import domain.card.Card;

public class RandomShuffledDeckFactory extends AbstractDeckFactory {
	@Override
	public List<Card> handleCards(List<Card> cards) {
		Collections.shuffle(cards);
		return cards;
	}
}
