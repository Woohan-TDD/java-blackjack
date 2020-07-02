package domain.state;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.card.Card;
import domain.card.Rank;
import domain.card.Suit;
import domain.gamer.Hand;

public class BlackJackTest {
	@Test
	@DisplayName("승리시 얻는 상금 비율을 확인")
	void getEarningRate() {
		assertThat(new BlackJack(
			new Hand(
				Arrays.asList(new Card(Rank.TEN, Suit.SPADE),
					new Card(Rank.ACE, Suit.CLUB)))).getEarningRate()).isEqualTo(1.5);
	}

	@Test
	@DisplayName("블랙잭이 이기는 경우 확인")
	void isWin1() {
		BlackJack blackJack = new BlackJack(
			new Hand(Arrays.asList(new Card(Rank.TEN, Suit.SPADE), new Card(Rank.ACE, Suit.CLUB))));
		Stay stay = new Stay(new Hand(Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE), new Card(Rank.NINE, Suit.CLUB))));
		assertThat(blackJack.isWin(stay)).isTrue();
	}

	@Test
	@DisplayName("블랙잭이 이기는게 아닌 경우 확인")
	void isWin2() {
		BlackJack blackJack1 = new BlackJack(
			new Hand(Arrays.asList(new Card(Rank.TEN, Suit.SPADE), new Card(Rank.ACE, Suit.CLUB))));
		BlackJack blackJack2 = new BlackJack(
			new Hand(Arrays.asList(new Card(Rank.KING, Suit.SPADE), new Card(Rank.ACE, Suit.CLUB))));

		assertThat(blackJack1.isWin(blackJack2)).isFalse();
	}

	@Test
	@DisplayName("블랙잭과 동일 결과가 아닌지 확인")
	void isSameResult1() {
		BlackJack blackJack = new BlackJack(
			new Hand(Arrays.asList(new Card(Rank.TEN, Suit.SPADE), new Card(Rank.ACE, Suit.CLUB))));
		Stay stay = new Stay(new Hand(Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE), new Card(Rank.NINE, Suit.CLUB))));
		assertThat(blackJack.isSameResult(stay));
	}

	@Test
	@DisplayName("블랙잭과 동일 결과인지 확인")
	void isSameResult2() {
		BlackJack blackJack1 = new BlackJack(
			new Hand(Arrays.asList(new Card(Rank.TEN, Suit.SPADE), new Card(Rank.ACE, Suit.CLUB))));
		BlackJack blackJack2 = new BlackJack(
			new Hand(Arrays.asList(new Card(Rank.KING, Suit.SPADE), new Card(Rank.ACE, Suit.CLUB))));

		assertThat(blackJack1.isSameResult(blackJack2)).isTrue();
	}
}
