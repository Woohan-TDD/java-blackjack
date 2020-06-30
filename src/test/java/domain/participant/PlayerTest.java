package domain.participant;

import static domain.Fixture.HUNDRED_BETTING_MONEY;
import static domain.Fixture.JUN;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @DisplayName("생성자: 사용자 생성")
    @Test
    void constructor() {
        Assertions.assertThat(new Player(JUN, HUNDRED_BETTING_MONEY)).isInstanceOf(Player.class);
    }

    @DisplayName("생성자: Name이 null이면 예외 발생")
    @Test
    void constructor_NameIsNull_ExceptionThrown() {
        assertThatThrownBy(() -> new Player(null, HUNDRED_BETTING_MONEY))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("name이 null입니다");
    }

    @DisplayName("생성자: BettingMoney가 null이면 예외 발생")
    @Test
    void constructor_BettingMoneyIsNull_ExceptionThrown() {
        assertThatThrownBy(() -> new Player(JUN, null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("bettingMoney가 null입니다");
    }
}
