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

public class DealerTest {
	@Test
	@DisplayName("생성 테스트")
	void constructor() {
		Deck deck = new TestDeckFactory().create();
		assertThat(Dealer.of(deck)).isNotNull();
	}

	@Test
	@DisplayName("플레이어들의 총 수익을 계산")
	void calculateEarning() {
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

		assertThat(dealer.calculateEarning(players)).isEqualTo(10_000);
	}
}
