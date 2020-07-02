package view;

import java.util.Scanner;

import domain.Name;
import domain.participant.Player;

public class InputView {
    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputNames() {
        System.out.println();
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return scanner.nextLine();
    }

    public int inputBettingMoney(final Name name) {
        System.out.println();
        System.out.printf("%s의 배팅 금액은?\n", name.getName());
        return Integer.parseInt(scanner.nextLine());
    }

    public String inputPlayerDecision(final Player player) {
        System.out.println();
        System.out.printf("%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)\n", player.getName());
        return scanner.nextLine();
    }
}
