package domain.participant;

import static domain.Fixture.EASTJUN;
import static domain.Fixture.HUNDRED_BETTING_MONEY;
import static domain.Fixture.TWO_SCORE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import domain.card.CardDeck;
import domain.card.FakeCardDeck;

class PlayerDecisionTest {
    @DisplayName("of: PlayerDecision 반환")
    @CsvSource(value = {"y, HIT", "n, STAY"})
    @ParameterizedTest
    void of_ValidInput_ReturnPlayerDecision(final String input, final PlayerDecision expect) {
        assertThat(PlayerDecision.of(input)).isEqualTo(expect);
    }

    @DisplayName("of: PlayerDecision 반환")
    @CsvSource(value = {"HIT, false", "STAY, true"})
    @ParameterizedTest
    void act(final PlayerDecision playerDecision, final boolean isFinished) {
        Player player = new Player(EASTJUN, HUNDRED_BETTING_MONEY);
        CardDeck cardDeck = new FakeCardDeck(Collections.singletonList(TWO_SCORE));

        playerDecision.act(cardDeck, player);

        assertAll(
                () -> assertThat(player.isFinished()).isEqualTo(isFinished),
                () -> assertThat(player.isBlackjack()).isFalse(),
                () -> assertThat(player.isBusted()).isFalse()
        );
    }
}