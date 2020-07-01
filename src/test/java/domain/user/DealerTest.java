package domain.user;

import domain.card.Card;
import domain.card.Symbol;
import domain.card.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DealerTest {

    @ParameterizedTest
    @CsvSource(value = {"SEVEN, false", "SIX,true"})
    @DisplayName("카드를 더 받을 수 있는지 확인")
    void canReceiveCard(Symbol symbol, boolean expected) {
        Dealer dealer = new Dealer();
        dealer.drawFirst(new Card(Symbol.TEN, Type.DIAMOND), new Card(symbol, Type.DIAMOND));
        assertThat(dealer.canDrawCard()).isEqualTo(expected);
    }
}