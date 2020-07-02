package domain.state;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.card.Card;
import domain.card.Rank;
import domain.card.Suit;
import domain.card.deck.Deck;
import domain.card.deck.TestDeckFactory;
import domain.gamer.Hand;

public class PlayingTest {
	@Test
	@DisplayName("종료 상태인지 확인")
	void isFinished() {
		assertThat(new Playing(
			new Hand(Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE),
				new Card(Rank.NINE, Suit.CLUB)))).isFinished()).isFalse();
	}

	@Test
	@DisplayName("hit 시 다음 상태를 제대로 가지고 오는 지 확인")
	void hit() {
		Deck deck = new TestDeckFactory().create();
		State state = new Playing(
			new Hand(new ArrayList<>(Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE),
				new Card(Rank.NINE, Suit.CLUB))))).hit(deck);
		assertThat(state).isInstanceOf(Playing.class);
	}

	@Test
	@DisplayName("stay 시 다음 상태를 제대로 가지고 오는 지 확인")
	void stay() {
		Deck deck = new TestDeckFactory().create();
		State state = new Playing(
			new Hand(new ArrayList<>(Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE),
				new Card(Rank.NINE, Suit.CLUB))))).stay();
		assertThat(state).isInstanceOf(Stay.class);
	}

	@Test
	@DisplayName("EarningRate 요청 시 예외 처리")
	void getEarningRate() {
		assertThatThrownBy(() -> new Playing(
			new Hand(new ArrayList<>(Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE),
				new Card(Rank.NINE, Suit.CLUB))))).getEarningRate())
			.isInstanceOf(UnsupportedOperationException.class);
	}

	@Test
	@DisplayName("isSameResult 요청 시 예외 발생")
	void isSameResult() {
		assertThatThrownBy(() -> new Playing(
			new Hand(new ArrayList<>(Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE),
				new Card(Rank.NINE, Suit.CLUB))))).isSameResult(
			new Stay(new Hand(new ArrayList<>(Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE),
				new Card(Rank.NINE, Suit.CLUB)))))))
			.isInstanceOf(UnsupportedOperationException.class);
	}
	@Test
	@DisplayName("isSameResult 요청 시 예외 발생")
	void isWin() {
		assertThatThrownBy(() -> new Playing(
			new Hand(new ArrayList<>(Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE),
				new Card(Rank.NINE, Suit.CLUB))))).isWin(
			new Stay(new Hand(new ArrayList<>(Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE),
				new Card(Rank.NINE, Suit.CLUB)))))))
			.isInstanceOf(UnsupportedOperationException.class);
	}
}
