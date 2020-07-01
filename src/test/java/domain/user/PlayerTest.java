package domain.user;

import domain.card.Card;
import domain.card.Symbol;
import domain.card.Type;
import domain.money.BettingMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @ParameterizedTest
    @CsvSource(value = {"ACE, true", "FIVE,false"})
    @DisplayName("카드를 더 받을 수 있는지 확인")
    void canReceiveCard(Symbol symbol, boolean expected) {
        Player player = new Player(new Name("name"), new BettingMoney(30));
        player.drawFirst(new Card(Symbol.TEN, Type.DIAMOND), new Card(Symbol.TEN, Type.DIAMOND));
        player.draw(new Card(symbol, Type.DIAMOND));
        assertThat(player.canDrawCard()).isEqualTo(expected);
    }

}