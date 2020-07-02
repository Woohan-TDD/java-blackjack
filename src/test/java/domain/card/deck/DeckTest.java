package domain.card.deck;

import static org.assertj.core.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.card.Card;
import domain.card.Rank;
import domain.card.Suit;

class DeckTest {
	@Test
	@DisplayName("가장 마지막 카드를 내보내는 지 확인")
	void pop() {
		Stack<Card> cards = new Stack<>();
		cards.push(new Card(Rank.EIGHT, Suit.SPADE));
		cards.push(new Card(Rank.NINE, Suit.CLUB));
		Deck deck = new Deck(cards);
		assertThat(deck.pop()).isEqualTo(new Card(Rank.NINE, Suit.CLUB));
	}
}