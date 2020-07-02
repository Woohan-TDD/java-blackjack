package domain.card.deck;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardFactoryTest {
	@Test
	@DisplayName("52장의 카드를 만드는 지 확인")
	void createCards() {
		CardFactory testDeckFactory = new TestDeckFactory();
		assertThat(testDeckFactory.createCards()).hasSize(52);
	}
}
