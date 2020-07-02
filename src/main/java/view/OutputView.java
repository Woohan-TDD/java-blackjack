package view;

import java.util.List;
import java.util.stream.Collectors;

import dto.CardDto;
import dto.GamerDto;
import dto.GamerEarningDto;
import dto.GamerWithScoreDto;

public class OutputView {
	private static final String DELIMITER = ", ";

	public void printGamersCards(List<GamerDto> gamers) {
		System.out.println(transferGamerNamesToString(gamers) + "에게 2장의 카드를 나누어 주었습니다.");
		for (GamerDto gamer : gamers) {
			printGamerCards(gamer);
		}
	}

	public void printGamerCards(GamerDto gamer) {
		System.out.println(gamer.getName() + "카드: " + transferGamerCardsToString(gamer.getCards()));
	}

	private String transferGamerNamesToString(List<GamerDto> gamers) {
		return gamers.stream()
			.map(GamerDto::getName)
			.collect(Collectors.joining(DELIMITER));
	}

	private String transferGamerCardsToString(List<CardDto> cards) {
		return cards.stream()
			.map(cardDto -> cardDto.getRank() + cardDto.getSuit())
			.collect(Collectors.joining(DELIMITER));
	}

	public void printDealerHit() {
		System.out.println("딜러는 17 미만이라 한 장의 카드를 더 뽑았습니다.");
	}

	public void printGamersCardsWithScore(List<GamerWithScoreDto> gamers) {
		for (GamerWithScoreDto gamer : gamers) {
			printGamerCardsWithScore(gamer);
		}
	}

	private void printGamerCardsWithScore(GamerWithScoreDto gamer) {
		System.out.println(
			gamer.getName() + "카드: " + transferGamerCardsToString(gamer.getCards()) + " - 결과 : " + gamer.getScore());
	}

	public void printEarning(List<GamerEarningDto> gamers) {
		System.out.println("## 최종 수익");
		for (GamerEarningDto gamer : gamers) {
			System.out.println(gamer.getName() + ": " + gamer.getEarningMoney());
		}
	}
}
