package view;

import java.util.*;

public class InputView {

    private final Scanner SCANNER = new Scanner(System.in);

    public List<String> inputNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return Arrays.asList(SCANNER.nextLine()
                .replace(" ", "")
                .split(","));
    }

    public Map<String, Integer> inputBettingMoneys(List<String> names) {
        Map<String, Integer> bettingMoneys = new HashMap<>();
        for (String name : names) {
            System.out.println(name + " 의 배팅 금액은?");
            bettingMoneys.put(name, Integer.parseInt(SCANNER.nextLine()));
        }
        return bettingMoneys;
    }
}
