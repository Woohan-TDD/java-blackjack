package domain.state;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.card.Card;
import domain.card.Rank;
import domain.card.Suit;
import domain.card.deck.TestDeckFactory;
import domain.gamer.Hand;

public class FinishedTest {
	@Test
	@DisplayName("종료 상태인지 확인")
	void isFinished() {
		assertThat(new BlackJack(
			new Hand(Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE),
				new Card(Rank.NINE, Suit.CLUB)))).isFinished()).isTrue();
	}

	@Test
	@DisplayName("hit 요청 시 예외 처리")
	void hit() {
		assertThatThrownBy(() -> new Stay(
			new Hand(Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE),
				new Card(Rank.NINE, Suit.CLUB)))).hit(new TestDeckFactory().create()))
			.isInstanceOf(UnsupportedOperationException.class);
	}

	@Test
	@DisplayName("stay 요청 시 예외 처리")
	void stay() {
		assertThatThrownBy(() -> new Stay(
			new Hand(Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE),
				new Card(Rank.NINE, Suit.CLUB)))).stay())
			.isInstanceOf(UnsupportedOperationException.class);
	}

	@Test
	void calculateScore() {
		assertThat(new Stay(
			new Hand(Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE),
				new Card(Rank.NINE, Suit.CLUB)))).calculateScore()).isEqualTo(17);
	}
}
