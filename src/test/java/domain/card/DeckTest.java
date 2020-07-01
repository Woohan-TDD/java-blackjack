package domain.card;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DeckTest {

    @Test
    @DisplayName("카드 한 장 나눠주기")
    void deal() {
        Deck deck = new Deck();
        Card card = deck.deal();
        assertThat(card).isNotNull();
    }

}