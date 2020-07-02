package dto;

import java.util.List;
import java.util.stream.Collectors;

import domain.gamer.Dealer;
import domain.gamer.Gamer;
import domain.gamer.Player;

public class GamerDto {
	private String name;
	private List<CardDto> cards;

	public GamerDto(String name, List<CardDto> cards) {
		this.name = name;
		this.cards = cards;
	}

	public static GamerDto of(Gamer gamer) {
		return new GamerDto(gamer.getName(), CardDto.listOf(gamer.getCards()));
	}

	public static List<GamerDto> listOf(Dealer dealer, List<Player> players) {
		List<GamerDto> gamers = players.stream()
			.map(GamerDto::of)
			.collect(Collectors.toList());
		gamers.add(0, new GamerDto(dealer.getName(), CardDto.listOf(dealer.getOneCards())));
		return gamers;
	}

	public String getName() {
		return name;
	}

	public List<CardDto> getCards() {
		return cards;
	}
}
