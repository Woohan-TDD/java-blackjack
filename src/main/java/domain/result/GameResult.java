package domain.result;

import java.util.stream.Stream;

import domain.participant.Dealer;
import domain.participant.Player;

public enum GameResult {
    PLAYER_WIN(new PlayerWinStrategy()),
    DRAW(new DrawStrategy()),
    PLAYER_LOSE(new PlayerLoseStrategy());

    private final ResultDecideStrategy resultDecideStrategy;

    GameResult(final ResultDecideStrategy resultDecideStrategy) {
        this.resultDecideStrategy = resultDecideStrategy;
    }

    public static GameResult fromDealerAndPlayer(final Dealer dealer, final Player player) {
        return Stream.of(values())
                .filter(result -> result.matches(dealer, player))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("결과가 존재하지 않습니다."));
    }

    private boolean matches(final Dealer dealer, final Player player) {
        return resultDecideStrategy.matches(dealer, player);
    }
}