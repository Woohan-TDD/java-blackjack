package controller;

import domain.Game;
import domain.card.Deck;
import domain.user.Dealer;
import domain.user.Name;
import domain.user.PlayerFactory;
import domain.user.Players;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private Game game;

    public Controller(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        game = createGame();
        game.drawFirst();
        outputView.printFirstCards(game.getDealer(), game.getPlayers());
    }

    private Game createGame() {
        List<Name> names = inputView.inputNames()
                .stream()
                .map(Name::new)
                .collect(Collectors.toList());
        Map<Name, Integer> inputs = inputView.inputBettingMonies(names);
        Players players = PlayerFactory.createPlayers(inputs);
        Dealer dealer = new Dealer();
        return new Game(new Deck(), players, dealer);
    }
}
