package domain.card.deck;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import domain.card.Card;
import domain.card.Rank;
import domain.card.Suit;

public abstract class AbstractDeckFactory implements DeckFactory, CardFactory {
	@Override
	public List<Card> createCards() {
		return Arrays.stream(Rank.values())
			.flatMap((rank -> Arrays.stream(Suit.values())
				.map(suit -> new Card(rank, suit))))
			.collect(Collectors.toList());
	}

	@Override
	public Deck create() {
		List<Card> cards = handleCards(createCards());
		Stack<Card> newCards = new Stack<>();
		newCards.addAll(cards);
		return new Deck(newCards);
	}

	public abstract List<Card> handleCards(List<Card> cards);
}
