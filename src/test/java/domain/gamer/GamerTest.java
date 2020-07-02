package domain.gamer;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.card.deck.DeckFactory;
import domain.card.deck.TestDeckFactory;
import domain.state.Stay;

public class GamerTest {
	@Test
	@DisplayName("게이머가 hit 할 수 있는지 확인")
	void hit() {
		DeckFactory testDeckFactory = new TestDeckFactory();
		Gamer gamer = Player.of("사람", testDeckFactory.create(), 10_000);
		gamer.hit(testDeckFactory.create());
		assertThat(gamer.getState().getCards()).hasSize(3);
	}

	@Test
	@DisplayName("게이머가 stay 할 수 있는지 확인")
	void stay() {
		DeckFactory testDeckFactory = new TestDeckFactory();
		Gamer gamer = Player.of("사람", testDeckFactory.create(), 10_000);
		gamer.stay();
		assertThat(gamer.getState()).isInstanceOf(Stay.class);
	}

	@Test
	@DisplayName("게이머의 턴이 끝났는지 확인")
	void isFinished() {
		DeckFactory testDeckFactory = new TestDeckFactory();
		Gamer gamer = Player.of("사람", testDeckFactory.create(), 10_000);
		gamer.hit(testDeckFactory.create());
		assertThat(gamer.isFinished()).isFalse();
	}

	@Test
	@DisplayName("게이머의 카드 스코어를 계산하는 지 확인")
	void calculateScore() {
		DeckFactory testDeckFactory = new TestDeckFactory();
		Gamer gamer = Player.of("사람", testDeckFactory.create(), 10_000);
		assertThat(gamer.calculateScore()).isEqualTo(12);
	}
}
