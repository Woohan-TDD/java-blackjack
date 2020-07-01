package domain.card;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HandsTest {

    @Test
    @DisplayName("카드 한 장 추가")
    void add() {
        Hands hands = new Hands();
        hands.add(new Card(Symbol.ACE, Type.CLUB));
        assertThat(hands.getCards()).hasSize(1);
    }

}