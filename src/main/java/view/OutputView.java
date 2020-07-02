package view;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

import domain.card.Card;
import domain.participant.Dealer;
import domain.participant.Participant;
import domain.participant.Player;
import domain.participant.hand.Hand;
import domain.result.ParticipantProfit;

public class OutputView {

    private static final String DELIMITER = ", ";

    public void printHandsAtFirst(final Dealer dealer, final List<Player> players) {
        System.out.println();
        System.out.printf("%s와 %s에게 2장의 나누었습니다.\n", dealer.getName(), renderNames(players));

        System.out.printf("딜러카드: %s\n", dealer.getHand().getCards().get(1).alias());
        players.forEach(this::printHand);
    }

    public void printHand(final Participant participant) {
        System.out.println(renderHand(participant));
    }

    public void printDealerHitMessage() {
        System.out.println();
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public void printHandsAtLast(final Dealer dealer, final List<Player> players) {
        System.out.println();
        printHandAtLast(dealer);
        players.forEach(this::printHandAtLast);
    }

    public void printProfits(final List<ParticipantProfit> participantProfits) {
        System.out.println();
        System.out.println("## 최종 수익");
        participantProfits.forEach(this::printProfit);
    }

    private void printHandAtLast(final Participant participant) {
        System.out.printf("%s - 결과: %d\n", renderHand(participant), participant.getHand().calculateScore());
    }

    private String renderHand(final Participant participant) {
        return String.format("%s카드: %s", participant.getName(), renderCards(participant.getHand()));
    }

    private String renderNames(final List<Player> players) {
        return players.stream()
                .map(Participant::getName)
                .collect(Collectors.joining(DELIMITER));
    }

    private String renderCards(final Hand hand) {
        return hand.getCards()
                .stream()
                .map(Card::alias)
                .collect(Collectors.joining(DELIMITER));
    }

    private PrintStream printProfit(final ParticipantProfit participantProfit) {
        return System.out.printf("%s: %d\n", participantProfit.getName(),
                participantProfit.getProfit().longValueExact());
    }
}
