package domain.participant;

import static domain.Fixture.HUNDRED_BETTING_MONEY;
import static domain.Fixture.JUN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @DisplayName("constructor: 사용자 생성")
    @Test
    void constructor() {
        assertThat(new Player(JUN, HUNDRED_BETTING_MONEY)).isInstanceOf(Player.class);
    }

    @DisplayName("constructor: Name이 null이면 예외 발생")
    @Test
    void constructor_NameIsNull_ExceptionThrown() {
        assertThatThrownBy(() -> new Player(null, HUNDRED_BETTING_MONEY))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("name이 null입니다");
    }

    @DisplayName("constructor: BettingMoney가 null이면 예외 발생")
    @Test
    void constructor_BettingMoneyIsNull_ExceptionThrown() {
        assertThatThrownBy(() -> new Player(JUN, null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("bettingMoney가 null입니다");
    }

    @DisplayName("getName: 이름을 반환")
    @Test
    void getName() {
        Player player = new Player(JUN, HUNDRED_BETTING_MONEY);

        assertThat(player.getName()).isEqualTo(JUN);
    }

    @DisplayName("getBettingMoney: 베팅 금액을 반환")
    @Test
    void getBettingMoney() {
        Player player = new Player(JUN, HUNDRED_BETTING_MONEY);

        assertThat(player.getBettingMoney()).isEqualTo(HUNDRED_BETTING_MONEY);
    }
}
