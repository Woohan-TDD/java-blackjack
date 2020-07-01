package domain.card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class HandsTest {

    private Hands hands;

    @BeforeEach
    void setUp() {
        hands = new Hands();
    }

    @Test
    @DisplayName("카드 한 장 추가")
    void add() {
        hands.add(new Card(Symbol.ACE, Type.CLUB));
        assertThat(hands.getCards()).hasSize(1);
    }

    @Test
    @DisplayName("에이스 없는 경우 카드합(17) 구하기")
    void sum() {
        hands.add(new Card(Symbol.EIGHT, Type.DIAMOND));
        hands.add(new Card(Symbol.NINE, Type.DIAMOND));
        assertThat(hands.sum()).isEqualTo(17);
    }

    @Test
    @DisplayName("에이스 있는 경우(1로 계산되는 경우) 카드합 구하기")
    void sumWhenAceOne() {
        hands.add(new Card(Symbol.ACE, Type.DIAMOND));
        hands.add(new Card(Symbol.EIGHT, Type.DIAMOND));
        hands.add(new Card(Symbol.NINE, Type.DIAMOND));
        assertThat(hands.sum()).isEqualTo(18);
    }

    @Test
    @DisplayName("에이스 있는 경우(11로 계산되는 경우) 카드합 구하기")
    void sumWhenAceEleven() {
        hands.add(new Card(Symbol.ACE, Type.DIAMOND));
        hands.add(new Card(Symbol.TEN, Type.DIAMOND));
        assertThat(hands.sum()).isEqualTo(21);
    }

    @ParameterizedTest
    @CsvSource(value = {"TWO,false", "NINE,true"})
    @DisplayName("Bust인지 확인")
    void isBust(Symbol symbol, boolean expected) {
        hands.add(new Card(symbol, Type.DIAMOND));
        hands.add(new Card(symbol, Type.DIAMOND));
        hands.add(new Card(symbol, Type.DIAMOND));
        assertThat(hands.isBust()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"JACK,ACE,true", "TWO,THREE,false"})
    @DisplayName("두 장 받았을 때 블랙잭인지 확인")
    void isBlackJack(Symbol symbol1, Symbol symbol2, boolean expected) {
        hands.add(new Card(symbol1, Type.DIAMOND));
        hands.add(new Card(symbol2, Type.DIAMOND));
        assertThat(hands.isBlackjack()).isEqualTo(expected);
    }

    @Test
    @DisplayName("세장 이상 받았을 때 합은 21이지만 블랙잭이 아님 확인")
    void isBlackjack() {
        hands.add(new Card(Symbol.JACK, Type.DIAMOND));
        hands.add(new Card(Symbol.JACK, Type.DIAMOND));
        hands.add(new Card(Symbol.ACE, Type.DIAMOND));
        assertThat(hands.isBlackjack()).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"SEVEN, true", "SIX, false"})
    @DisplayName("딜러 버스트 확인")
    void isDealerBust(Symbol symbol, boolean expected) {
        hands.add(new Card(Symbol.JACK, Type.DIAMOND));
        hands.add(new Card(symbol, Type.DIAMOND));
        assertThat(hands.isDealerBust()).isEqualTo(expected);
    }

    @Test
    @DisplayName("합이 더 큰지 확인")
    void isBiggerThan() {
        hands.add(new Card(Symbol.JACK, Type.DIAMOND));
        Hands newHands = new Hands();
        newHands.add(new Card(Symbol.EIGHT, Type.DIAMOND));
        assertThat(newHands.isBiggerThan(hands)).isFalse();
    }

    @Test
    @DisplayName("합이 같은지 확인")
    void isSame() {
        hands.add(new Card(Symbol.JACK, Type.DIAMOND));
        Hands newHands = new Hands();
        newHands.add(new Card(Symbol.JACK, Type.DIAMOND));
        assertThat(newHands.isSame(hands)).isTrue();
    }
}