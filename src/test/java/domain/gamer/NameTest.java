package domain.gamer;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {
	@Test
	@DisplayName("생성 테스트")
	void constructor() {
		assertThat(new Name("hi")).isNotNull();
	}

	@Test
	void constructorException() {
		assertThatThrownBy(() -> new Name("h i"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("공백");
	}
}
