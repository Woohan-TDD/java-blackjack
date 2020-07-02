package domain.card;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardDeckFactoryTest {
    @DisplayName("constructor: 랜덤 카드 덱 생성")
    @Test
    void createRandomCardDeck() {
        Assertions.assertThat(CardDeckFactory.createRandomCardDeck()).isInstanceOf(RandomCardDeck.class);
    }
}