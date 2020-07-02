package controller;

import java.util.ArrayList;
import java.util.List;

import domain.BettingMoney;
import domain.Name;
import domain.card.CardDeck;
import domain.card.CardDeckFactory;
import domain.participant.Dealer;
import domain.participant.Player;
import domain.result.ParticipantProfit;
import service.DrawService;
import service.PlayerService;
import service.ProfitService;
import view.InputView;
import view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final PlayerService playerService;
    private final DrawService drawService;
    private final ProfitService profitService;

    public GameController(final InputView inputView, final OutputView outputView, final PlayerService playerService,
            final DrawService drawService, final ProfitService profitService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.playerService = playerService;
        this.drawService = drawService;
        this.profitService = profitService;
    }

    public void run() {
        CardDeck cardDeck = CardDeckFactory.createRandomCardDeck();
        Dealer dealer = new Dealer();
        List<Player> players = createPlayers();

        drawCards(cardDeck, dealer, players);

        calculateProfit(dealer, players);
    }

    private List<Player> createPlayers() {
        String namesWithComma = inputView.inputNames();
        List<Name> names = Name.fromComma(namesWithComma);
        List<BettingMoney> bettingMonies = new ArrayList<>();
        for (final Name name : names) {
            int money = inputView.inputBettingMoney(name);
            BettingMoney bettingMoney = new BettingMoney(money);
            bettingMonies.add(bettingMoney);
        }
        return playerService.createPlayers(names, bettingMonies);
    }

    private void drawCards(final CardDeck cardDeck, final Dealer dealer, final List<Player> players) {
        drawService.drawInitialCards(cardDeck, dealer, players);
        outputView.printHandsAtFirst(dealer, players);

        for (final Player player : players) {
            drawCardToPlayer(cardDeck, player);
        }
        drawCardToDealer(cardDeck, dealer);
    }

    private void calculateProfit(final Dealer dealer, final List<Player> players) {
        outputView.printHandsAtLast(dealer, players);
        List<ParticipantProfit> participantProfits = profitService.calculateProfits(dealer, players);
        outputView.printProfits(participantProfits);
    }

    private void drawCardToDealer(final CardDeck cardDeck, final Dealer dealer) {
        while (!dealer.isFinished()) {
            drawService.drawDealer(cardDeck, dealer);
            outputView.printDealerHitMessage();
        }
    }

    private void drawCardToPlayer(final CardDeck cardDeck, final Player player) {
        while (!player.isFinished()) {
            String decision = inputView.inputPlayerDecision(player);
            drawService.drawPlayer(cardDeck, player, decision);
            outputView.printHand(player);
        }
    }
}
