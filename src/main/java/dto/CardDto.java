package dto;

import java.util.List;
import java.util.stream.Collectors;

import domain.card.Card;

public class CardDto {
	private String rank;
	private String suit;

	public CardDto(String rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public static List<CardDto> listOf(List<Card> cards) {
		return cards.stream()
			.map(CardDto::of)
			.collect(Collectors.toList());
	}

	private static CardDto of(Card card) {
		return new CardDto(card.getRank(), card.getSuit());
	}

	public String getRank() {
		return rank;
	}

	public String getSuit() {
		return suit;
	}
}
