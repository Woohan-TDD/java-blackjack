package domain.card.deck;

import java.util.Stack;

import domain.card.Card;

public class Deck {
	private final Stack<Card> cards;

	public Deck(Stack<Card> cards) {
		this.cards = cards;
	}

	public Card pop() {
		return cards.pop();
	}
}
