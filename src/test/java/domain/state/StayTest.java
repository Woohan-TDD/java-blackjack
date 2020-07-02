package domain.state;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.card.Card;
import domain.card.Rank;
import domain.card.Suit;
import domain.gamer.Hand;

public class StayTest {
	@Test
	@DisplayName("승리시 얻는 상금 비율을 확인")
	void getEarningRate() {
		assertThat(new Stay(
			new Hand(
				Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE),
					new Card(Rank.NINE, Suit.CLUB)))).getEarningRate()).isEqualTo(1);
	}

	@Test
	@DisplayName("stay가 이기는 경우 확인")
	void isWin1() {
		Stay stay = new Stay(
			new Hand(
				Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE), new Card(Rank.KING, Suit.CLUB))));
		assertThat(stay.isWin(new Bust(
			new Hand(
				Arrays.asList(new Card(Rank.SEVEN, Suit.SPADE), new Card(Rank.KING, Suit.CLUB),
					new Card(Rank.NINE, Suit.CLUB)))))).isTrue();
	}

	@Test
	@DisplayName("stay가 지는 경우 확인")
	void isWin2() {
		Stay stay = new Stay(
			new Hand(
				Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE), new Card(Rank.KING, Suit.CLUB))));
		assertThat(stay.isWin(new BlackJack(
			new Hand(
				Arrays.asList(new Card(Rank.ACE, Suit.SPADE), new Card(Rank.KING, Suit.CLUB)))))).isFalse();
	}

	@Test
	@DisplayName("stay가 stay에게 지는 경우 확인")
	void isWin3() {
		Stay stay = new Stay(
			new Hand(
				Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE), new Card(Rank.KING, Suit.CLUB))));
		assertThat(stay.isWin(new Stay(
			new Hand(
				Arrays.asList(new Card(Rank.TEN, Suit.SPADE), new Card(Rank.KING, Suit.CLUB)))))).isFalse();
	}

	@Test
	@DisplayName("자신과 동일한 결과일지 확인")
	void isSameResult() {
		Stay stay = new Stay(
			new Hand(
				Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE), new Card(Rank.NINE, Suit.CLUB))));
		assertThat(stay.isSameResult(new Stay(
			new Hand(
				Arrays.asList(new Card(Rank.SEVEN, Suit.SPADE), new Card(Rank.KING, Suit.CLUB),
					new Card(Rank.NINE, Suit.CLUB)))))).isFalse();
	}
}
