package domain.card;

import static domain.Fixture.CARDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomCardDeckTest {
    private RandomCardDeck cardDeck;

    @BeforeEach
    void setUp() {
        cardDeck = new RandomCardDeck(CARDS);
    }

    @DisplayName("생성자: 카드 덱 생성")
    @Test
    void constructor() {
        assertThat(new RandomCardDeck(Card.values())).isInstanceOf(RandomCardDeck.class);

    }

    @DisplayName("생성자: 카드 리스트가 null인 경우 예외 발생")
    @Test
    void constructor_CardsIsNull_ExceptionThrown() {
        assertThatThrownBy(() -> new RandomCardDeck(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("카드 리스트가 null입니다");
    }

    @DisplayName("생성자: 카드 리스트의 크기가 0인 경우 예외 발생")
    @Test
    void constructor_CardsIsEmpty_ExceptionThrown() {
        assertThatThrownBy(() -> new RandomCardDeck(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("카드 리스트의 크기가 0입니다");
    }

    @DisplayName("pick: 카드 한 장을 뽑음")
    @Test
    void pick() {
        assertThat(cardDeck.pick()).isInstanceOf(Card.class);
    }

    @DisplayName("pick: 카드를 입력받은 장수만큼 뽑음")
    @Test
    void pick_MultipleCards() {
        assertThat(cardDeck.pick(5)).hasSize(5);
    }
}
