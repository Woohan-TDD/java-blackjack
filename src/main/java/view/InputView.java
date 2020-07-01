package view;

import domain.user.Name;
import domain.user.Player;

import java.util.*;

import static view.YesOrNo.YES;

public class InputView {

    private final Scanner SCANNER = new Scanner(System.in);

    public List<String> inputNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return Arrays.asList(SCANNER.nextLine()
                .replace(" ", "")
                .split(","));
    }

    public Map<Name, Integer> inputBettingMonies(final List<Name> names) {
        Map<Name, Integer> bettingMonies = new LinkedHashMap<>();
        for (Name name : names) {
            System.out.println(name.getName() + " 의 배팅 금액은?");
            bettingMonies.put(name, Integer.parseInt(SCANNER.nextLine()));
        }
        return Collections.unmodifiableMap(bettingMonies);
    }

    public boolean inputWantMoreCard(Player player) {
        System.out.println(player.getName() + " 은 한 장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        return YES.equals(YesOrNo.of(SCANNER.nextLine()));
    }
}
