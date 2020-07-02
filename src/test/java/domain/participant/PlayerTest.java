package domain.participant;

import static domain.Fixture.EASTJUN;
import static domain.Fixture.HITTABLE_HAND_STATE;
import static domain.Fixture.HUNDRED_BETTING_MONEY;
import static domain.Fixture.TEN_SCORE;
import static domain.Fixture.TWO_SCORE;
import static domain.Fixture.WESTJUN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.math.BigDecimal;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.card.CardDeck;
import domain.card.FakeCardDeck;

class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player(EASTJUN, HITTABLE_HAND_STATE, HUNDRED_BETTING_MONEY);
    }

    @DisplayName("constructor: 사용자 생성")
    @Test
    void constructor_TwoArguments() {
        assertThat(new Player(EASTJUN, HUNDRED_BETTING_MONEY)).isInstanceOf(Player.class);
    }

    @DisplayName("constructor: 사용자 생성")
    @Test
    void constructor_ThreeArguments() {
        assertThat(new Player(EASTJUN, HITTABLE_HAND_STATE, HUNDRED_BETTING_MONEY)).isInstanceOf(Player.class);
    }

    @DisplayName("constructor: Name이 null이면 예외 발생")
    @Test
    void constructor_NameIsNull_ExceptionThrown() {
        assertThatThrownBy(() -> new Player(null, HITTABLE_HAND_STATE, HUNDRED_BETTING_MONEY))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("name이 null입니다");
    }

    @DisplayName("constructor: HandState가 null이면 예외 발생")
    @Test
    void constructor_HandStateIsNull_ExceptionThrown() {
        assertThatThrownBy(() -> new Player(WESTJUN, null, HUNDRED_BETTING_MONEY))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("handState가 null입니다");
    }

    @DisplayName("constructor: BettingMoney가 null이면 예외 발생")
    @Test
    void constructor_BettingMoneyIsNull_ExceptionThrown() {
        assertThatThrownBy(() -> new Player(EASTJUN, HITTABLE_HAND_STATE, null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("bettingMoney가 null입니다");
    }

    @DisplayName("hit: 카드를 한 장 뽑고 상태 전이")
    @Test
    void hit() {
        CardDeck cardDeck = new FakeCardDeck(Collections.singletonList(TWO_SCORE));
        player.hit(cardDeck);

        assertAll(
                () -> assertThat(player.isFinished()).isFalse(),
                () -> assertThat(player.isBlackjack()).isFalse(),
                () -> assertThat(player.isBusted()).isFalse()
        );
    }

    @DisplayName("hit: 카드를 한 장 뽑고 버스트 상태로 전이")
    @Test
    void hit_Busted() {
        CardDeck cardDeck = new FakeCardDeck(Collections.singletonList(TEN_SCORE));
        player.hit(cardDeck);

        assertAll(
                () -> assertThat(player.isFinished()).isTrue(),
                () -> assertThat(player.isBlackjack()).isFalse(),
                () -> assertThat(player.isBusted()).isTrue()
        );
    }

    @DisplayName("stay: 카드를 한 장 뽑고 상태 전이")
    @Test
    void stay() {
        player.stay();

        assertAll(
                () -> assertThat(player.isFinished()).isTrue(),
                () -> assertThat(player.isBlackjack()).isFalse(),
                () -> assertThat(player.isBusted()).isFalse()
        );
    }

    @DisplayName("calculateProfit: 수익률 계산")
    @Test
    void calculateProfit() {
        player.stay();
        assertThat(player.calculateProfit()).isEqualTo(BigDecimal.valueOf(1_000_000));
    }

    @DisplayName("getName: 이름을 반환")
    @Test
    void getName() {
        assertThat(player.getName()).isEqualTo("eastjun");
    }
}
