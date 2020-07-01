package domain.result;

import static domain.Fixture.BLACKJACK_HAND;
import static domain.Fixture.BUSTED_HAND;
import static domain.Fixture.EASTJUN;
import static domain.Fixture.HITTABLE_HIGH_HAND;
import static domain.Fixture.HITTABLE_LOW_HAND;
import static domain.Fixture.HUNDRED_BETTING_MONEY;
import static domain.Fixture.NORTHJUN;
import static domain.Fixture.SOUTHJUN;
import static domain.Fixture.WESTJUN;
import static domain.result.GameResult.DRAW;
import static domain.result.GameResult.PLAYER_LOSE;
import static domain.result.GameResult.PLAYER_WIN;
import static domain.result.GameResult.fromDealerAndPlayer;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.participant.Dealer;
import domain.participant.Player;
import domain.participant.hand.BlackjackState;
import domain.participant.hand.BustedState;
import domain.participant.hand.StayState;

public class GameResultTest {
    private static final Dealer BLACKJACK_DEALER = new Dealer(new BlackjackState(BLACKJACK_HAND));
    private static final Dealer HIGH_SCORE_DEALER = new Dealer(new StayState(HITTABLE_HIGH_HAND));
    private static final Dealer LOW_SCORE_DEALER = new Dealer(new StayState(HITTABLE_LOW_HAND));
    private static final Dealer BUSTED_DEALER = new Dealer(new BustedState(BUSTED_HAND));

    private static final Player BLACKJACK_PLAYER =
            new Player(WESTJUN, new BlackjackState(BLACKJACK_HAND), HUNDRED_BETTING_MONEY);
    private static final Player HIGH_SCORE_PLAYER =
            new Player(EASTJUN, new StayState(HITTABLE_HIGH_HAND), HUNDRED_BETTING_MONEY);
    private static final Player LOW_SCORE_PLAYER =
            new Player(SOUTHJUN, new StayState(HITTABLE_LOW_HAND), HUNDRED_BETTING_MONEY);
    private static final Player BUSTED_PLAYER =
            new Player(NORTHJUN, new BustedState(BUSTED_HAND), HUNDRED_BETTING_MONEY);

    @DisplayName("플레이어가 블랙잭 승리")
    @Test
    void fromDealerAndPlayer_PlayerBlackjackWin() {
        assertThat(fromDealerAndPlayer(HIGH_SCORE_DEALER, BLACKJACK_PLAYER)).isEqualTo(PLAYER_WIN);
    }

    @DisplayName("블랙잭 무승부")
    @Test
    void fromDealerAndPlayer_BlackjackDraw() {
        assertThat(fromDealerAndPlayer(BLACKJACK_DEALER, BLACKJACK_PLAYER)).isEqualTo(DRAW);
    }

    @DisplayName("딜러가 블랙잭 승리")
    @Test
    void fromDealerAndPlayer_DealerBlackjackWin() {
        assertThat(fromDealerAndPlayer(BLACKJACK_DEALER, HIGH_SCORE_PLAYER)).isEqualTo(PLAYER_LOSE);
    }

    @DisplayName("플레이어가 버스트 패배")
    @Test
    void fromDealerAndPlayer_PlayerBustLose() {
        assertThat(fromDealerAndPlayer(LOW_SCORE_DEALER, BUSTED_PLAYER)).isEqualTo(PLAYER_LOSE);
    }

    @DisplayName("딜러가 버스트 패배")
    @Test
    void fromDealerAndPlayer_DealerBustLose() {
        assertThat(fromDealerAndPlayer(BUSTED_DEALER, HIGH_SCORE_PLAYER)).isEqualTo(PLAYER_WIN);
    }

    @DisplayName("플레이어가 점수를 비교하여 승리")
    @Test
    void fromDealerAndPlayer_PlayerScoreWin() {
        assertThat(fromDealerAndPlayer(LOW_SCORE_DEALER, HIGH_SCORE_PLAYER)).isEqualTo(PLAYER_WIN);
    }

    @DisplayName("점수를 비교하여 무승부")
    @Test
    void fromDealerAndPlayer_ScoreDraw() {
        assertThat(fromDealerAndPlayer(HIGH_SCORE_DEALER, HIGH_SCORE_PLAYER)).isEqualTo(DRAW);
    }

    @DisplayName("딜러가 점수를 비교하여 승리")
    @Test
    void fromDealerAndPlayer_DealerScoreWin() {
        assertThat(fromDealerAndPlayer(HIGH_SCORE_DEALER, LOW_SCORE_PLAYER)).isEqualTo(PLAYER_LOSE);
    }
}
