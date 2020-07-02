package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import dto.PlayerInfo;

public class InputView {
	private static final String DELIMITER = ",";
	private final Scanner scanner;

	public InputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public List<PlayerInfo> inputPlayerInfos() {
		List<PlayerInfo> playerInfos = new ArrayList<>();
		List<String> names = inputName();
		for (String name : names) {
			playerInfos.add(new PlayerInfo(name, inputBattingMoney(name)));
		}
		return playerInfos;
	}

	private List<String> inputName() {
		System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
		return Arrays.stream(scanner.nextLine().split(DELIMITER))
			.map(String::trim)
			.collect(Collectors.toList());
	}

	private int inputBattingMoney(String name) {
		System.out.println(name + "의 배팅 금액은?");
		return Integer.parseInt(scanner.nextLine());
	}

	public String inputYesOrNo(String name) {
		System.out.println(name + "은 한장의 카드를 더 받으시겠습니까?");
		return scanner.nextLine();
	}
}
