package domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerFactoryTest {

    @Test
    @DisplayName("String name 입력받고, Players 정상 생성 확인")
    void create() {
        Map<Name, Integer> inputs = new HashMap<>();
        inputs.put(new Name("yerin"), 10000);
        inputs.put(new Name("orange"), 10000);
        inputs.put(new Name("dasom"), 10000);
        Players players = PlayerFactory.createPlayers(inputs);
        assertThat(players).isNotNull();
        assertThat(players.getPlayers()).hasSize(3);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null, 공백 유효성 테스트")
    void validate(Map<Name, Integer> input) {
        assertThatThrownBy(() -> PlayerFactory.createPlayers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("null / empty 값입니다.");
    }

}