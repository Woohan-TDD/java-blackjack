package domain.card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}