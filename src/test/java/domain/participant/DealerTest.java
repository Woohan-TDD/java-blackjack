package domain.participant;

import static domain.Fixture.ACE_SCORE;
import static domain.Fixture.DEALER_HITTABLE_LOWER_BOUND_CARDS;
import static domain.Fixture.DEALER_HITTABLE_UPPER_BOUND_CARDS;
import static domain.Fixture.createHandState;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.participant.hand.HitState;
import domain.participant.hand.StayState;

class DealerTest {
    @DisplayName("constructor: 딜러 인스턴스 생성")
    @Test
    void constructor() {
        assertThat(new Dealer(createHandState(DEALER_HITTABLE_UPPER_BOUND_CARDS))).isInstanceOf(Dealer.class);
    }

    @DisplayName("hit: 카드 한 장을 받고 16 이하이면 Hittable 상태 유지")
    @Test
    void hit_HittableState() {
        Dealer dealer = new Dealer(createHandState(DEALER_HITTABLE_LOWER_BOUND_CARDS));

        dealer.hit(ACE_SCORE);

        assertThat(dealer.getHandState()).isInstanceOf(HitState.class);
    }

    @DisplayName("hit: 카드 한 장을 받고 16 초과하면 stay 상태로 전이")
    @Test
    void hit_ChangeToStayState() {
        Dealer dealer = new Dealer(createHandState(DEALER_HITTABLE_UPPER_BOUND_CARDS));

        dealer.hit(ACE_SCORE);

        assertThat(dealer.getHandState()).isInstanceOf(StayState.class);
    }
}
