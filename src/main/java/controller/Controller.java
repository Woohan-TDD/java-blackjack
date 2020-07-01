package controller;

import domain.user.PlayerFactory;
import domain.user.Players;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> names = inputView.inputNames();
        Map<String, Integer> inputs = inputView.inputBettingMoneys(names);
        Players players = PlayerFactory.createPlayers(inputs);
    }
}
