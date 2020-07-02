package domain.participant;

import static domain.Fixture.ACE_SCORE;
import static domain.Fixture.DEALER_HITTABLE_LOWER_BOUND_CARDS;
import static domain.Fixture.DEALER_HITTABLE_UPPER_BOUND_CARDS;
import static domain.Fixture.TWO_SCORE;
import static domain.Fixture.createHandState;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.card.CardDeck;
import domain.card.FakeCardDeck;

class DealerTest {
    @DisplayName("constructor: 딜러 인스턴스 생성")
    @Test
    void constructor_NoArguments() {
        assertThat(new Dealer()).isInstanceOf(Dealer.class);
    }

    @DisplayName("constructor: 딜러 인스턴스 생성")
    @Test
    void constructor_OneArguments() {
        assertThat(new Dealer(createHandState(DEALER_HITTABLE_UPPER_BOUND_CARDS))).isInstanceOf(Dealer.class);
    }

    @DisplayName("hitAtFirst: 최초로 카드를 두 장 뽑음")
    @Test
    void hitAtFirst() {
        Dealer dealer = new Dealer(createHandState(DEALER_HITTABLE_LOWER_BOUND_CARDS));
        CardDeck cardDeck = new FakeCardDeck(Arrays.asList(ACE_SCORE, TWO_SCORE));

        dealer.hitAtFirst(cardDeck);

        assertAll(
                () -> assertThat(dealer.isBusted()).isFalse()
        );
    }

    @DisplayName("hit: 카드 한 장을 받고 16 이하이면 Hittable 상태 유지")
    @Test
    void hit_HittableState() {
        Dealer dealer = new Dealer(createHandState(DEALER_HITTABLE_LOWER_BOUND_CARDS));
        CardDeck cardDeck = new FakeCardDeck(Collections.singletonList(ACE_SCORE));

        dealer.hit(cardDeck);

        assertAll(
                () -> assertThat(dealer.isFinished()).isFalse(),
                () -> assertThat(dealer.isBlackjack()).isFalse(),
                () -> assertThat(dealer.isBusted()).isFalse()
        );
    }

    @DisplayName("hit: 카드 한 장을 받고 16 초과하면 stay 상태로 전이")
    @Test
    void hit_ChangeToStayState() {
        Dealer dealer = new Dealer(createHandState(DEALER_HITTABLE_UPPER_BOUND_CARDS));
        CardDeck cardDeck = new FakeCardDeck(Collections.singletonList(ACE_SCORE));

        dealer.hit(cardDeck);

        assertAll(
                () -> assertThat(dealer.isFinished()).isTrue(),
                () -> assertThat(dealer.isBlackjack()).isFalse(),
                () -> assertThat(dealer.isBusted()).isFalse()
        );
    }

    @DisplayName("getHand: hand를 반환")
    @Test
    void getHand() {
        Dealer dealer = new Dealer(createHandState(DEALER_HITTABLE_LOWER_BOUND_CARDS));

        assertThat(dealer.getHand()).isNotNull();
    }
}
