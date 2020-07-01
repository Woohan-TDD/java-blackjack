package domain.user;

import domain.BettingMoney;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerFactory {

    public static Players createPlayers(final Map<Name, Integer> inputs) {
        validate(inputs);
        List<Player> players = new ArrayList<>();
        for (Map.Entry<Name, Integer> input : inputs.entrySet()) {
            players.add(new Player(
                    input.getKey(), new BettingMoney(input.getValue())));
        }
        return new Players(players);
    }

    private static void validate(final Map<Name, Integer> inputs) {
        if (inputs == null || inputs.isEmpty()) {
            throw new IllegalArgumentException("null / empty 값입니다.");
        }
    }
}
