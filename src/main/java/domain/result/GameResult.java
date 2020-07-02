package domain.result;

import java.math.BigDecimal;
import java.util.function.Function;
import java.util.stream.Stream;

import domain.participant.Dealer;
import domain.participant.Player;

public enum GameResult {
    PLAYER_WIN(new PlayerWinStrategy(), Player::calculateProfit),
    DRAW(new DrawStrategy(), player -> BigDecimal.ZERO),
    PLAYER_LOSE(new PlayerLoseStrategy(), player -> player.getBettingMoney().multiply(BigDecimal.valueOf(-1)));

    private final ResultDecideStrategy resultDecideStrategy;
    private final Function<Player, BigDecimal> profitCalculateFunction;

    GameResult(final ResultDecideStrategy resultDecideStrategy,
            final Function<Player, BigDecimal> profitCalculateFunction) {
        this.resultDecideStrategy = resultDecideStrategy;
        this.profitCalculateFunction = profitCalculateFunction;
    }

    public static GameResult fromDealerAndPlayer(final Dealer dealer, final Player player) {
        return Stream.of(values())
                .filter(result -> result.matches(dealer, player))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("결과가 존재하지 않습니다."));
    }

    public BigDecimal calculateProfit(final Player player) {
        return profitCalculateFunction.apply(player);
    }

    private boolean matches(final Dealer dealer, final Player player) {
        return resultDecideStrategy.matches(dealer, player);
    }
}