package domain.state;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.card.Card;
import domain.card.Rank;
import domain.card.Suit;
import domain.gamer.Hand;

public class BustTest {
	@Test
	@DisplayName("승리시 얻는 상금 비율을 확인")
	void getEarningRate() {
		assertThat(new Bust(
			new Hand(
				Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE), new Card(Rank.KING, Suit.CLUB),
					new Card(Rank.NINE, Suit.CLUB)))).getEarningRate()).isEqualTo(0);
	}

	@Test
	@DisplayName("bust가 지는 경우 확인")
	void isWin() {
		Bust bust = new Bust(
			new Hand(
				Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE), new Card(Rank.KING, Suit.CLUB),
					new Card(Rank.NINE, Suit.CLUB))));
		assertThat(bust.isWin(new Bust(
			new Hand(
				Arrays.asList(new Card(Rank.SEVEN, Suit.SPADE), new Card(Rank.KING, Suit.CLUB),
					new Card(Rank.NINE, Suit.CLUB)))))).isFalse();
	}

	@Test
	@DisplayName("bust가 같은 결과가 아닌 경우 확인")
	void isSameResult() {
		Bust bust = new Bust(
			new Hand(
				Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE), new Card(Rank.KING, Suit.CLUB),
					new Card(Rank.NINE, Suit.CLUB))));
		assertThat(bust.isWin(new Bust(
			new Hand(
				Arrays.asList(new Card(Rank.SEVEN, Suit.SPADE), new Card(Rank.KING, Suit.CLUB),
					new Card(Rank.NINE, Suit.CLUB)))))).isFalse();
	}
}
