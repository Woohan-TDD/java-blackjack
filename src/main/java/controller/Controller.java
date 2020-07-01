package controller;

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

    public Controller(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<Name> names = inputView.inputNames()
                .stream()
                .map(Name::new)
                .collect(Collectors.toList());
        Map<Name, Integer> inputs = inputView.inputBettingMoneys(names);
        Players players = PlayerFactory.createPlayers(inputs);
        Dealer dealer = new Dealer();
    }
}
