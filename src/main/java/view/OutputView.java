package view;

import domain.card.Card;
import domain.user.Dealer;
import domain.user.Player;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printFirstCards(Dealer dealer, List<Player> players) {
        String names = players.stream()
                .map(Player::getName)
                .collect(Collectors.joining(", "));
        System.out.println("딜러와 " + names + "에게 2장의 카드를 나누어주었습니다.");
        System.out.println("딜러 : " + dealer.getHands().get(0).toString());
        for (Player player : players) {
            String cards = player.getHands()
                    .stream().map(Card::toString)
                    .collect(Collectors.joining(", "));
            System.out.println(player.getName() + " : " + cards);
        }
    }

    public void printCards(Player player) {
        String cards = player.getHands()
                .stream().map(Card::toString)
                .collect(Collectors.joining(", "));
        System.out.println(player.getName() + " : " + cards);
    }
}
