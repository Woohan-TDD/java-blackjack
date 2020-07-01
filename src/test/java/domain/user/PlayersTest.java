package domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {

    @Test
    @DisplayName("정상생성 테스트")
    void create() {
        List<Player> playerList = Arrays.asList(
                new Player(new Name("Dasom"), new BettingMoney(1000)),
                new Player(new Name("yerin"), new BettingMoney(1)));
        Players players = new Players(playerList);
        assertThat(players).isNotNull();
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("null 유효성 검사")
    void validateNull(List<Player> input) {
        assertThatThrownBy(() -> new Players(input))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("플레이어는 1명 이상이어야 합니다. 입력값 : " + input);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("empty 유효성 검사")
    void validateEmpty(List<Player> input) {
        assertThatThrownBy(() -> new Players(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어는 1명 이상이어야 합니다. 입력값 : empty");
    }

}