package domain.result;

import domain.participant.Dealer;
import domain.participant.Player;

public interface ResultDecideStrategy {
    default boolean matches(final Dealer dealer, final Player player) {
        if (dealer.isBlackjack() || player.isBlackjack()) {
            return matchByBlackjack(dealer, player);
        }
        if (dealer.isBusted() || player.isBusted()) {
            return matchByBust(dealer, player);
        }
        return matchByScore(dealer, player);
    }

    boolean matchByBlackjack(final Dealer dealer, final Player player);

    boolean matchByBust(final Dealer dealer, final Player player);

    boolean matchByScore(final Dealer dealer, final Player player);
}
