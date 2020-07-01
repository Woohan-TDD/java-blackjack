package domain.user;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Players {
    private final List<Player> players;

    public Players(final List<Player> players) {
        validate(players);
        this.players = players;
    }

    private void validate(final List<Player> players) {
        Objects.requireNonNull(players, "플레이어는 1명 이상이어야 합니다. 입력값 : null");
        if (players.isEmpty()) {
            throw new IllegalArgumentException("플레이어는 1명 이상이어야 합니다. 입력값 : empty");
        }
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
