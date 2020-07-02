package domain.card.deck;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.card.Card;
import domain.card.Rank;
import domain.card.Suit;

class DeckFactoryTest {
	@Test
	@DisplayName("Deck을 만드는 지 확인")
	void create() {
		DeckFactory testDeckFactory = new TestDeckFactory();
		assertThat(testDeckFactory.create()).isNotNull();
	}

	@Test
	@DisplayName("DeckFactory가 카드를 원하는 방식으로 조절할 수 있는 지 확인")
	void handleCards() {
		DeckFactory testDeckFactory = new TestDeckFactory();
		Deck deck = testDeckFactory.create();
		assertThat(deck.pop()).isEqualTo(new Card(Rank.ACE, Suit.CLUB));
	}
}