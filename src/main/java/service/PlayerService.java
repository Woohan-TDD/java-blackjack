package service;

import java.util.ArrayList;
import java.util.List;

import domain.BettingMoney;
import domain.Name;
import domain.participant.Player;

public class PlayerService {
    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 8;

    public List<Player> createPlayers(List<Name> names, List<BettingMoney> bettingMonies) {
        validateSize(names, bettingMonies);
        validateLength(names);
        List<Player> players = new ArrayList<>();
        for (int count = 0; count < names.size(); count++) {
            players.add(new Player(names.get(count), bettingMonies.get(count)));
        }
        return players;
    }

    private void validateSize(final List<Name> names, final List<BettingMoney> bettingMonies) {
        if (names.size() != bettingMonies.size()) {
            throw new IllegalArgumentException("names와 bettingMonies의 크기가 일치하지 않습니다.\n"
                    + "names size: " + names.size() + "\n"
                    + "bettingMonies size: " + bettingMonies.size());
        }
    }

    private void validateLength(final List<Name> names) {
        int totalPlayer = names.size();
        if (totalPlayer < MIN_PLAYERS || totalPlayer > MAX_PLAYERS) {
            throw new IllegalArgumentException("참여자의 수가 올바르지 않습니다.\n"
                    + "players size: " + names.size());
        }
    }
}
