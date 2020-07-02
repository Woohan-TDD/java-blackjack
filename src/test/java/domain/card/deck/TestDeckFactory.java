package domain.card.deck;

import java.util.Arrays;
import java.util.List;

import domain.card.Card;
import domain.card.Rank;
import domain.card.Suit;

public class TestDeckFactory extends AbstractDeckFactory {
	@Override
	public List<Card> handleCards(List<Card> cards) {
		return Arrays.asList(new Card(Rank.ACE, Suit.SPADE), new Card(Rank.ACE, Suit.CLUB));
	}
}
