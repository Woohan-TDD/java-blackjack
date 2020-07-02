package domain.gamer;

import java.util.Collections;
import java.util.List;

public class Players {
	private final List<Player> players;

	public Players(List<Player> players) {
		validate(players);
		this.players = players;
	}

	private void validate(List<Player> players) {
		if (players.isEmpty()) {
			throw new IllegalArgumentException("플레이어가 비어있습니다.");
		}
	}

	public int calculateTotalEarning(Dealer dealer) {
		return players.stream()
			.mapToInt(player -> player.calculateEarning(dealer))
			.sum();
	}

	public List<Player> getPlayers() {
		return Collections.unmodifiableList(players);
	}
}
