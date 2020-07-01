package domain.money;

import domain.card.Hands;
import domain.user.Dealer;
import domain.user.Player;
import domain.user.Players;

import java.util.LinkedHashMap;
import java.util.Map;

public class EarningMoney {

    public static Map<String, Double> calculateMoney(Dealer dealer, Players players) {
        Map<String, Double> earningMonies = new LinkedHashMap<>();
        for (Player player : players.getPlayers()) {
            earningMonies.put(player.getName(), calculate(dealer, player));
        }
        return earningMonies;
    }

    private static double calculate(Dealer dealer, Player player) {
        Hands dealerHands = dealer.getHands();
        Hands playerHands = player.getHands();
        if (playerHands.isBust()) {
            calculateWhenBust(dealerHands, player);
            return player.getState().profit(player.getBettingMoney());
        }
        if (playerHands.isBlackjack()) {
            calculateWhenBlackjack(dealerHands, player);
            return player.getState().profit(player.getBettingMoney());
        }
        calculateWhenStay(dealerHands, player);
        return player.getState().profit(player.getBettingMoney());
    }

    private static void calculateWhenStay(Hands dealerHands, Player player) {
        if (dealerHands.isBust() || player.getHands().isBiggerThan(dealerHands)) {
            player.stay();
        }
        if (dealerHands.isBiggerThan(player.getHands())) {
            player.bust();
        }
    }

    private static void calculateWhenBlackjack(Hands dealerHands, Player player) {
        if (dealerHands.isBlackjack()) {
            player.stay();
        }
    }

    private static void calculateWhenBust(Hands dealerHands, Player player) {
        if (dealerHands.isBust()) {
            player.stay();
        }
    }

}
