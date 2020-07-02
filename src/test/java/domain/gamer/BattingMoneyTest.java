package domain.gamer;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class
BattingMoneyTest {
	@Test
	@DisplayName("생성 테스트")
	void constructor() {
		assertThat(new BattingMoney(10)).isNotNull();
	}

	@Test
	@DisplayName("생성 테스트 - 음수 시 예외")
	void constructorException() {
		assertThatThrownBy(() -> new BattingMoney(-10))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("음수");
	}
}
