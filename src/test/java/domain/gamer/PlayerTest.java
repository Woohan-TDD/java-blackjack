package domain.gamer;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.card.Card;
import domain.card.Rank;
import domain.card.Suit;
import domain.card.deck.AbstractDeckFactory;
import domain.card.deck.TestDeckFactory;

public class PlayerTest {
	@Test
	@DisplayName("생성 테스트")
	void constructor() {
		assertThat(Player.of("사람", new TestDeckFactory().create(), 10_000)).isNotNull();
	}

	@Test
	@DisplayName("게임 후 수익 결과 계산 - 무승부")
	void calculateEarning1() {
		Player player = Player.of("사람", new TestDeckFactory().create(), 10_000);
		Dealer dealer = Dealer.of(new TestDeckFactory().create());

		player.stay();
		dealer.stay();

		assertThat(player.calculateEarning(dealer)).isEqualTo(0);
	}

	@Test
	@DisplayName("게임 후 수익 결과 계산 - 이기는 경우")
	void calculateEarning2() {
		Player player = Player.of("사람", new AbstractDeckFactory() {
			@Override
			public List<Card> handleCards(List<Card> cards) {
				return Arrays.asList(new Card(Rank.KING, Suit.CLUB), new Card(Rank.TEN, Suit.CLUB));
			}
		}.create(), 10_000);
		Dealer dealer = Dealer.of(new AbstractDeckFactory() {
			@Override
			public List<Card> handleCards(List<Card> cards) {
				return Arrays.asList(new Card(Rank.ACE, Suit.CLUB), new Card(Rank.SEVEN, Suit.CLUB));
			}
		}.create());

		player.stay();
		dealer.stay();

		assertThat(player.calculateEarning(dealer)).isEqualTo(10_000);
	}

	@Test
	@DisplayName("게임 후 수익 결과 계산 - 이기는 경우")
	void calculateEarning3() {
		Player player = Player.of("사람", new AbstractDeckFactory() {
			@Override
			public List<Card> handleCards(List<Card> cards) {
				return Arrays.asList(new Card(Rank.KING, Suit.CLUB), new Card(Rank.ACE, Suit.CLUB));
			}
		}.create(), 10_000);
		Dealer dealer = Dealer.of(new AbstractDeckFactory() {
			@Override
			public List<Card> handleCards(List<Card> cards) {
				return Arrays.asList(new Card(Rank.ACE, Suit.CLUB), new Card(Rank.SEVEN, Suit.CLUB));
			}
		}.create());

		dealer.stay();

		assertThat(player.calculateEarning(dealer)).isEqualTo(15_000);
	}

	@Test
	@DisplayName("게임 후 수익 결과 계산 - 지는 경우")
	void calculateEarning4() {
		Player player = Player.of("사람", new TestDeckFactory().create(), 10_000);
		Dealer dealer = Dealer.of(new AbstractDeckFactory() {
			@Override
			public List<Card> handleCards(List<Card> cards) {
				return Arrays.asList(new Card(Rank.TEN, Suit.SPADE), new Card(Rank.TEN, Suit.CLUB));
			}
		}.create());

		player.stay();
		dealer.stay();

		assertThat(player.calculateEarning(dealer)).isEqualTo(-10_000);
	}
}
