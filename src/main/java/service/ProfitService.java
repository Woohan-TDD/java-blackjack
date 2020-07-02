package service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import domain.participant.Dealer;
import domain.participant.Player;
import domain.result.GameResult;
import domain.result.ParticipantProfit;

public class ProfitService {
    public List<ParticipantProfit> calculateProfits(final Dealer dealer, final List<Player> players) {
        List<ParticipantProfit> participantProfits = new ArrayList<>();
        for (final Player player : players) {
            GameResult gameResult = GameResult.fromDealerAndPlayer(dealer, player);
            BigDecimal profit = gameResult.calculateProfit(player);
            participantProfits.add(new ParticipantProfit(player, profit));
        }
        ParticipantProfit dealerProfit = new ParticipantProfit(dealer, calculateDealerProfit(participantProfits));
        participantProfits.add(0, dealerProfit);
        return participantProfits;
    }

    private BigDecimal calculateDealerProfit(final List<ParticipantProfit> profits) {
        return profits.stream()
                .map(ParticipantProfit::getProfit)
                .reduce(BigDecimal.ZERO, BigDecimal::subtract);
    }
}
