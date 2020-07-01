package domain.user;

import domain.card.Card;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Players {
    private final List<Player> players;

    Players(final List<Player> players) {
        validate(players);
        this.players = players;
    }

    private void validate(final List<Player> players) {
        Objects.requireNonNull(players, "플레이어는 1명 이상이어야 합니다. 입력값 : null");
        if (players.isEmpty()) {
            throw new IllegalArgumentException("플레이어는 1명 이상이어야 합니다. 입력값 : empty");
        }
    }

    public void draw(List<Card> drawCards) {
        for (Player player : players) {
            player.draw(drawCards.remove(0));
        }
    }

    public int size() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
