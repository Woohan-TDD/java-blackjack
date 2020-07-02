package dto;

import java.util.List;
import java.util.stream.Collectors;

import domain.gamer.Dealer;
import domain.gamer.Player;
import domain.gamer.Players;

public class GamerEarningDto {
	private String name;
	private int earningMoney;

	public GamerEarningDto(String name, int earningMoney) {
		this.name = name;
		this.earningMoney = earningMoney;
	}

	public static List<GamerEarningDto> listOf(Dealer dealer, Players players) {
		List<GamerEarningDto> gamers = players.getPlayers().stream()
			.map(player -> GamerEarningDto.of(player, dealer))
			.collect(Collectors.toList());
		gamers.add(0, new GamerEarningDto(dealer.getName(), dealer.calculateEarning(players)));
		return gamers;
	}

	public static GamerEarningDto of(Player player, Dealer dealer) {
		return new GamerEarningDto(player.getName(), player.calculateEarning(dealer));
	}

	public String getName() {
		return name;
	}

	public int getEarningMoney() {
		return earningMoney;
	}
}
