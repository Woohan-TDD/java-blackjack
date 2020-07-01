package domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @Test
    @DisplayName("정상 생성 테스트")
    void create() {
        Player player = new Player(new Name("name"), new BettingMoney(30));
        assertThat(player).isNotNull();
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("생성에 대한 유효성 검사")
    void validate(Object object) {
        assertThatThrownBy(() -> new Player((Name) object, (BettingMoney) object))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("null 비허용");
    }

}