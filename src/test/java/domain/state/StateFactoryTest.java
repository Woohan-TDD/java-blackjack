package domain.state;

import domain.card.Card;
import domain.card.Hands;
import domain.card.Symbol;
import domain.card.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class StateFactoryTest {

    @Test
    @DisplayName("처음 두장 받은 후 블랙잭인 경우, 블랙잭 반환")
    void blackjack() {
        Card card1 = new Card(Symbol.ACE, Type.DIAMOND);
        Card card2 = new Card(Symbol.JACK, Type.DIAMOND);
        assertThat(Objects.requireNonNull(StateFactory.drawFirst(card1, card2)).getClass()).isEqualTo(Blackjack.class);
    }

    @Test
    @DisplayName("처음 두장 받은 후 블랙잭이 아니면 Hit 반환")
    void hit() {
        Hands hands = new Hands();
        Card card1 = new Card(Symbol.JACK, Type.DIAMOND);
        Card card2 = new Card(Symbol.TWO, Type.DIAMOND);
        assertThat(Objects.requireNonNull(StateFactory.drawFirst(card1, card2)).getClass()).isEqualTo(Hit.class);
    }

}