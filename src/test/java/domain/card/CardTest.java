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
    @DisplayName("fromFaceAndSuit: 카드 한 장을 생성")
    @Test
    void fromFaceAndSuit() {
        assertThat(Card.fromFaceAndSuit(ACE, CLUB)).isInstanceOf(Card.class);
    }

    @DisplayName("fromFaceAndSuit: face 또는 suit가 null인 경우 예외 발생")
    @CsvSource(value = {", CLUB", "TEN,"})
    @ParameterizedTest
    void fromFaceAndSuit_FaceOrSuitIsNull_ExceptionThrown(final Face face, final Suit suit) {
        assertThatThrownBy(() -> Card.fromFaceAndSuit(face, suit))
                .isInstanceOf(CardNotFoundException.class)
                .hasMessageContaining("카드가 존재하지 않습니다");
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
        Card card = Card.fromFaceAndSuit(face, CLUB);

        assertThat(card.isAce()).isEqualTo(expect);
    }

    @DisplayName("isCardOf: 카드의 face와 suit가 일치하는지 확인")
    @CsvSource(value = {"ACE, CLUB, true", "TEN, CLUB, false", "ACE, DIAMOND, false"})
    @ParameterizedTest
    void isAce(final Face face, final Suit suit, final boolean expect) {
        Card card = Card.fromFaceAndSuit(ACE, CLUB);

        assertThat(card.isCardOf(face, suit)).isEqualTo(expect);
    }

    @DisplayName("getFace: face를 반환")
    @Test
    void getFace() {
        Card card = Card.fromFaceAndSuit(ACE, CLUB);

        assertThat(card.getFace()).isEqualTo(ACE);
    }

    @DisplayName("getSuit: suit를 반환")
    @Test
    void getSuit() {
        Card card = Card.fromFaceAndSuit(ACE, CLUB);

        assertThat(card.getSuit()).isEqualTo(CLUB);
    }
}
