package view;

import domain.user.Name;

import java.util.*;

public class InputView {

    private final Scanner SCANNER = new Scanner(System.in);

    public List<String> inputNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return Arrays.asList(SCANNER.nextLine()
                .replace(" ", "")
                .split(","));
    }

    public Map<Name, Integer> inputBettingMonies(final List<Name> names) {
        Map<Name, Integer> bettingMonies = new HashMap<>();
        for (Name name : names) {
            System.out.println(name.getName() + " 의 배팅 금액은?");
            bettingMonies.put(name, Integer.parseInt(SCANNER.nextLine()));
        }
        return Collections.unmodifiableMap(bettingMonies);
    }
}
