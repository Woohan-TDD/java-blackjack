package domain.state;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.card.Card;
import domain.card.Rank;
import domain.card.Suit;
import domain.card.deck.AbstractDeckFactory;
import domain.card.deck.Deck;
import domain.card.deck.TestDeckFactory;

public class StateFactoryTest {
	@Test
	@DisplayName("Deck을 이용해 초기 카드 상태를 만들어주는 지 확인")
	void create1() {
		Deck deck = new TestDeckFactory().create();
		State state = StateFactory.create(deck);
		assertThat(state).isInstanceOf(Playing.class);
	}

	@Test
	@DisplayName("Deck을 이용해 초기 카드 상태를 만들어주는 지 확인 - 블랙잭")
	void create2() {
		Deck deck = new AbstractDeckFactory() {
			@Override
			public List<Card> handleCards(List<Card> cards) {
				return Arrays.asList(new Card(Rank.ACE, Suit.CLUB), new Card(Rank.TEN, Suit.CLUB));
			}
		}.create();
		State state = StateFactory.create(deck);
		assertThat(state).isInstanceOf(BlackJack.class);
	}
}
