package domain.result;

import domain.participant.Dealer;
import domain.participant.Player;

public class PlayerWinStrategy implements ResultDecideStrategy {
    @Override
    public boolean matchByBlackjack(final Dealer dealer, final Player player) {
        return !dealer.isBlackjack() && player.isBlackjack();
    }

    @Override
    public boolean matchByBust(final Dealer dealer, final Player player) {
        return dealer.isBusted() && !player.isBusted();
    }

    @Override
    public boolean matchByScore(final Dealer dealer, final Player player) {
        return dealer.compareScore(player) < 0;
    }
}
