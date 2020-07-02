package domain.gamer;

import java.util.Collections;
import java.util.List;

import domain.card.Card;

public class Hand {
	private static final int BLACKJACK_SCORE = 21;
	private static final int ACE_BONUS = 10;

	private final List<Card> cards;

	public Hand(List<Card> cards) {
		this.cards = cards;
	}

	public void add(Card card) {
		cards.add(card);
	}

	public int calculateScore() {
		return cards.stream()
			.filter(Card::isAce)
			.reduce(calculateRawScore(), (subTotal, card) -> addAceBonus(subTotal), Integer::sum);
	}

	private int addAceBonus(int subTotal) {
		if (subTotal + ACE_BONUS <= BLACKJACK_SCORE) {
			return subTotal + ACE_BONUS;
		}
		return subTotal;
	}

	private int calculateRawScore() {
		return cards.stream()
			.mapToInt(Card::getScore)
			.sum();
	}

	public boolean isBust() {
		return calculateScore() > BLACKJACK_SCORE;
	}

	public boolean isBlackJackScore() {
		return calculateScore() == BLACKJACK_SCORE;
	}

	public List<Card> getCards() {
		return Collections.unmodifiableList(cards);
	}
}
