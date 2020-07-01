package domain;

import domain.card.Deck;
import domain.user.Dealer;
import domain.user.Name;
import domain.user.PlayerFactory;
import domain.user.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    private Deck deck;
    private Players players;
    private Dealer dealer;
    private Game game;

    @BeforeEach
    void setUp() {
        Map<Name, Integer> inputs = new HashMap<>();
        inputs.put(new Name("yerin"), 10000);
        inputs.put(new Name("orange"), 20000);
        inputs.put(new Name("dasom"), 30000);
        players = PlayerFactory.createPlayers(inputs);
        dealer = new Dealer();
        deck = new Deck();
        game = new Game(deck);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("게임 시작 시 참가자들에게 카드 두 장씩 부여")
    void firstDraw(int index) {
        game.drawFirst(players, dealer);
        assertThat(dealer.getHands()).hasSize(2);
        assertThat(players.getPlayers().get(index).getHands()).hasSize(2);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("한 장의 카드 지급")
    void draw(int index) {
        firstDraw(index);
        game.draw(players.getPlayers().get(index));
        assertThat(players.getPlayers().get(index).getHands()).hasSize(3);
    }


}