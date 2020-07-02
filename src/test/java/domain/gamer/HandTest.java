package domain.gamer;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.card.Card;
import domain.card.Rank;
import domain.card.Suit;

public class HandTest {
	@Test
	@DisplayName("생성 테스트")
	void constructor() {
		assertThat(
			new Hand(Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE), new Card(Rank.EIGHT, Suit.CLUB)))).isNotNull();
	}

	@Test
	@DisplayName("카드를 더할 수 있는 지 확인")
	void addCard() {
		Hand hand = new Hand(new ArrayList<>(Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE), new Card(Rank.EIGHT, Suit.CLUB))));
		hand.add(new Card(Rank.ACE, Suit.SPADE));
		assertThat(hand.getCards()).hasSize(3);
	}

	@Test
	@DisplayName("현재 가지고 있는 카드의 점수를 계산하는지 확인")
	void calculateScore1() {
		Hand hand = new Hand(Arrays.asList(new Card(Rank.EIGHT, Suit.SPADE), new Card(Rank.EIGHT, Suit.CLUB)));
		assertThat(hand.calculateScore()).isEqualTo(16);
	}

	@Test
	@DisplayName("현재 가지고 있는 카드의 점수를 계산하는지 확인 - 에이스 보너스")
	void calculateScore2() {
		Hand hand = new Hand(Arrays.asList(new Card(Rank.ACE, Suit.SPADE), new Card(Rank.EIGHT, Suit.CLUB)));
		assertThat(hand.calculateScore()).isEqualTo(19);
	}

	@Test
	@DisplayName("현재 가지고 있는 카드의 점수를 계산하는지 확인 - 에이스 보너스 적용 X")
	void calculateScore3() {
		Hand hand = new Hand(Arrays.asList(new Card(Rank.ACE, Suit.SPADE),
			new Card(Rank.TEN, Suit.CLUB),
			new Card(Rank.TEN, Suit.SPADE)));
		assertThat(hand.calculateScore()).isEqualTo(21);
	}

	@Test
	@DisplayName("현재 가지고 있는 카드의 점수를 계산하는지 확인 - 에이스 보너스 일부 적용")
	void calculateScore4() {
		Hand hand = new Hand(Arrays.asList(new Card(Rank.ACE, Suit.SPADE),
			new Card(Rank.ACE, Suit.CLUB),
			new Card(Rank.NINE, Suit.SPADE)));
		assertThat(hand.calculateScore()).isEqualTo(21);
	}

	@Test
	@DisplayName("버스트 여부 확인")
	void isBust() {
		Hand hand = new Hand(Arrays.asList(new Card(Rank.TEN, Suit.SPADE),
			new Card(Rank.EIGHT, Suit.CLUB),
			new Card(Rank.NINE, Suit.SPADE)));
		assertThat(hand.isBust()).isTrue();
	}

	@Test
	@DisplayName("블랙잭 스코어와 같은 지 확인")
	void isBlackJackScore() {
		Hand hand = new Hand(Arrays.asList(new Card(Rank.TEN, Suit.SPADE),
			new Card(Rank.TWO, Suit.CLUB),
			new Card(Rank.NINE, Suit.SPADE)));
		assertThat(hand.isBlackJackScore()).isTrue();
	}
}
