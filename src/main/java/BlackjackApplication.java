import java.util.Scanner;

import controller.GameController;
import service.DrawService;
import service.PlayerService;
import service.ProfitService;
import view.InputView;
import view.OutputView;

public class BlackjackApplication {
    private final GameController gameController;

    public BlackjackApplication(final GameController gameController) {
        this.gameController = gameController;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        OutputView outputView = new OutputView();
        PlayerService playerService = new PlayerService();
        DrawService drawService = new DrawService();
        ProfitService profitService = new ProfitService();

        GameController gameController = new GameController(inputView, outputView, playerService, drawService,
                profitService);
        BlackjackApplication blackjackApplication = new BlackjackApplication(gameController);

        blackjackApplication.run();
    }

    public void run() {
        try {
            gameController.run();
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}
