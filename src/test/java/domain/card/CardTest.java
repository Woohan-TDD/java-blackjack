package domain.card;

import static domain.card.Face.ACE;
import static domain.card.Suit.CLUB;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CardTest {
    @DisplayName("생성자: 카드 한 장을 생성")
    @Test
    void constructor() {
        assertThat(new Card(ACE, CLUB)).isInstanceOf(Card.class);
    }

    @DisplayName("생성자: Face가 null인 경우 예외 발생")
    @Test
    void constructor_FaceIsNull_ExceptionThrown() {
        assertThatThrownBy(() -> new Card(null, CLUB))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("face가 null입니다.");
    }

    @DisplayName("생성자: Suit가 null인 경우 예외 발생")
    @Test
    void constructor_SuitIsNull_ExceptionThrown() {
        assertThatThrownBy(() -> new Card(ACE, null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("suit가 null입니다.");
    }

    @DisplayName("values: 전체 카드를 반환")
    @Test
    void values() {
        assertThat(Card.values()).hasSize(52);
    }

    @DisplayName("isAce: 카드가 Ace인지 판별")
    @CsvSource(value = {"ACE, true", "TEN, false"})
    @ParameterizedTest
    void isAce(final Face face, final boolean expect) {
        Card card = new Card(face, CLUB);

        assertThat(card.isAce()).isEqualTo(expect);
    }

    @DisplayName("getFace: face를 반환")
    @Test
    void getFace() {
        Card card = new Card(ACE, CLUB);

        assertThat(card.getFace()).isEqualTo(ACE);
    }

    @DisplayName("getSuit: suit를 반환")
    @Test
    void getSuit() {
        Card card = new Card(ACE, CLUB);

        assertThat(card.getSuit()).isEqualTo(CLUB);
    }
}
