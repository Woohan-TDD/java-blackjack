package domain.card.deck;

import java.util.List;

import domain.card.Card;

public interface CardFactory {
	List<Card> createCards();
}
