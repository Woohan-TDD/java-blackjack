package dto;

import java.util.List;
import java.util.stream.Collectors;

import domain.gamer.Dealer;
import domain.gamer.Gamer;
import domain.gamer.Player;

public class GamerWithScoreDto {
	private String name;
	private List<CardDto> cards;
	private int score;

	public GamerWithScoreDto(String name, List<CardDto> cards, int score) {
		this.name = name;
		this.cards = cards;
		this.score = score;
	}

	public static List<GamerWithScoreDto> listOf(Dealer dealer, List<Player> players) {
		List<GamerWithScoreDto> gamers = players.stream()
			.map(GamerWithScoreDto::of)
			.collect(Collectors.toList());
		gamers.add(0, new GamerWithScoreDto(dealer.getName(), CardDto.listOf(dealer.getCards()),
			dealer.calculateScore()));
		return gamers;
	}

	private static GamerWithScoreDto of(Gamer gamer) {
		return new GamerWithScoreDto(gamer.getName(), CardDto.listOf(gamer.getCards()),
			gamer.calculateScore());
	}

	public String getName() {
		return name;
	}

	public List<CardDto> getCards() {
		return cards;
	}

	public int getScore() {
		return score;
	}
}
