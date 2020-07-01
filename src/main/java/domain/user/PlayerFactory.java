package domain.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerFactory {

    public static Players createPlayers(Map<String, Integer> inputs) {
        validate(inputs);
        List<Player> players = new ArrayList<>();
        for (Map.Entry<String, Integer> input : inputs.entrySet()) {
            players.add(new Player(
                    new Name(input.getKey()), new BettingMoney(input.getValue())));
        }
        return new Players(players);
    }

    private static void validate(Map<String, Integer> inputs) {
        if (inputs == null || inputs.isEmpty()) {
            throw new IllegalArgumentException("null / empty 값입니다.");
        }
    }
}
