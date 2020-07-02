package domain.card;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTest {
	@Test
	@DisplayName("생성 테스트")
	void constructor() {
		assertThat(new Card(Rank.ACE, Suit.SPADE)).isNotNull();
	}

	@Test
	@DisplayName("Ace인지 확인")
	void isAce() {
		assertThat(new Card(Rank.ACE, Suit.SPADE).isAce()).isTrue();
	}
}
