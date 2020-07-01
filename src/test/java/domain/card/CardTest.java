package domain.card;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardTest {

    @Test
    @DisplayName("카드의 점수 반환")
    void getScore() {
        Card card = new Card(Symbol.EIGHT, Type.DIAMOND);
        assertThat(card.getScore()).isEqualTo(8);
    }

    @Test
    @DisplayName("에이스 카드인지 확인")
    void isAce() {
        Card cardA = new Card(Symbol.ACE, Type.DIAMOND);
        Card card8 = new Card(Symbol.EIGHT, Type.DIAMOND);
        assertThat(cardA.isAce()).isTrue();
        assertThat(card8.isAce()).isFalse();
    }

}