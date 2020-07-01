package controller;

import domain.Game;
import domain.card.Deck;
import domain.user.*;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private Players players;
    private Dealer dealer;

    public Controller(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Game game = createGame();
        game.drawFirst(players, dealer);
        outputView.printFirstCards(dealer, players.getPlayers());
        playPlayers(game);
        playDealer(game);
    }

    private Game createGame() {
        List<Name> names = inputView.inputNames()
                .stream()
                .map(Name::new)
                .collect(Collectors.toList());
        Map<Name, Integer> inputs = inputView.inputBettingMonies(names);
        players = PlayerFactory.createPlayers(inputs);
        dealer = new Dealer();
        return new Game(new Deck());
    }

    private void playPlayers(Game game) {
        for (Player player : players.getPlayers()) {
            playPlayer(player, game);
        }
    }

    private void playPlayer(Player player, Game game) {
        while (player.canDrawCard() && inputView.inputWantMoreCard(player)) {
            game.draw(player);
            outputView.printCards(player);
        }
        if (player.canDrawCard()) {
            player.stay();
        }
    }

    private void playDealer(Game game) {
        if (dealer.canDrawCard()) {
            outputView.printDealerHit();
            game.draw(dealer);
        }
    }
}
