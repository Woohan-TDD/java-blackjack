package view;

import domain.card.Card;
import domain.user.Dealer;
import domain.user.Player;
import domain.user.Players;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public void printFirstCards(Dealer dealer, List<Player> players) {
        String names = players.stream()
                .map(Player::getName)
                .collect(Collectors.joining(", "));
        System.out.println("딜러와 " + names + "에게 2장의 카드를 나누어주었습니다.");
        System.out.println("딜러 : " + dealer.getHands().getCards().get(0).toString());
        for (Player player : players) {
            String cards = player.getHands()
                    .getCards()
                    .stream().map(Card::toString)
                    .collect(Collectors.joining(", "));
            System.out.println(player.getName() + " : " + cards);
        }
        System.out.println();
    }

    public void printCards(Player player) {
        String cards = player.getHands()
                .getCards()
                .stream().map(Card::toString)
                .collect(Collectors.joining(", "));
        System.out.println(player.getName() + " : " + cards);
    }

    public void printDealerHit() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.\n");
    }

    public void printResultCards(Dealer dealer, Players players) {
        String dealerCards = dealer.getHands()
                .getCards()
                .stream().map(Card::toString)
                .collect(Collectors.joining(", "));
        System.out.println("딜러 : " + dealerCards + " - 결과 : " + dealer.getHands().sum());
        for (Player player : players.getPlayers()) {
            String cards = player.getHands()
                    .getCards()
                    .stream().map(Card::toString)
                    .collect(Collectors.joining(", "));
            System.out.println(player.getName() + " : " + cards + " - 결과 : " + player.getHands().sum());
        }
        System.out.println();
    }

    public void printEarningMoney(Map<String, Double> earningMonies) {
        int dealerEarningMoney = earningMonies.values()
                .stream()
                .mapToInt(Double::intValue)
                .sum() * -1;
        System.out.println("## 최종 수익");
        System.out.println("딜러 : " + dealerEarningMoney);
        for (Map.Entry<String, Double> money : earningMonies.entrySet()) {
            System.out.println(money.getKey() + " : " + money.getValue().intValue());
        }

    }
}
