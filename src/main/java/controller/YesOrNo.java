package controller;

import java.util.Arrays;
import java.util.function.BiConsumer;

import domain.card.deck.Deck;
import domain.gamer.Player;

public enum YesOrNo {
	YES("y", Player::hit),
	NO("n", ((player, deck) -> player.stay()));

	private final String shortName;
	private final BiConsumer<Player, Deck> playerBehavior;

	YesOrNo(String shortName, BiConsumer<Player, Deck> playerBehavior) {
		this.shortName = shortName;
		this.playerBehavior = playerBehavior;
	}

	public static YesOrNo findByShortName(String name) {
		return Arrays.stream(values())
			.filter(yesOrNo -> yesOrNo.shortName.equalsIgnoreCase(name))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("잘못된 명령어입니다"));
	}

	public void execute(Player player, Deck deck) {
		playerBehavior.accept(player, deck);
	}
}
