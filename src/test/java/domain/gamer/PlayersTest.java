package domain.gamer;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.card.Card;
import domain.card.Rank;
import domain.card.Suit;
import domain.card.deck.AbstractDeckFactory;
import domain.card.deck.Deck;
import domain.card.deck.TestDeckFactory;

public class PlayersTest {
	@Test
	@DisplayName("생성 테스트")
	void constructor() {
		assertThat(new Players(
			Collections.singletonList(Player.of("사람", new TestDeckFactory().create(), 10_000)))).isNotNull();
	}

	@Test
	@DisplayName("생성 테스트 - 리스트가 비어있는 경우 예외 처리")
	void constructorException() {
		assertThatThrownBy(() -> new Players(Collections.emptyList()))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("비어");
	}

	@Test
	@DisplayName("플레이어들의 총 수익을 계산")
	void calculateTotalEarning() {
		Deck deck = new AbstractDeckFactory() {
			@Override
			public List<Card> handleCards(List<Card> cards) {
				return Arrays.asList(new Card(Rank.ACE, Suit.CLUB), new Card(Rank.TEN, Suit.CLUB),
					new Card(Rank.ACE, Suit.DIAMOND), new Card(Rank.ACE, Suit.CLUB));
			}
		}.create();
		Player player = Player.of("사람", deck, 10_000);
		player.stay();
		Players players = new Players(
			Collections.singletonList(player));
		Dealer dealer = Dealer.of(deck);

		assertThat(players.calculateTotalEarning(dealer)).isEqualTo(-10_000);
	}
}
