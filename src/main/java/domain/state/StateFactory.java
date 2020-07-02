package domain.state;

import java.util.ArrayList;
import java.util.Arrays;

import domain.card.Card;
import domain.card.deck.Deck;
import domain.gamer.Hand;

public class StateFactory {
	private StateFactory() {
	}

	public static State create(Deck deck) {
		return createState(deck.pop(), deck.pop());
	}

	private static State createState(Card first, Card second) {
		Hand hand = new Hand(new ArrayList<>(Arrays.asList(first, second)));
		if (hand.isBlackJackScore()) {
			return new BlackJack(hand);
		}
		return new Playing(hand);
	}
}
